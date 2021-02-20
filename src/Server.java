import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;
import java.util.ArrayList;
import java.util.Locale;

public class Server {
    public static ArrayList<Sala> salas=new ArrayList();
    public static void main(String args[]) {

        DatagramSocket aSocket = null;


        try {
            aSocket = new DatagramSocket(6789);
            System.out.println("Servidor: ouvindo porta UDP/6789.");


            while (true) {
                byte[] buffer = new byte[1000];
                DatagramPacket request = new DatagramPacket(buffer, buffer.length);
                aSocket.receive(request);
                String comand = new String(request.getData()).trim();
                System.out.println("^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^\nRecebido do cliente  {" + comand  + "}");
                String message = menu(comand);
                System.out.println("Enviado como resposta{ \n " + message  + "<\n}\n^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^");
                DatagramPacket reply = new DatagramPacket(
                        message.getBytes(),
                        message.length(),
                        request.getAddress(),
                        request.getPort());
                aSocket.send(reply);
            }
        } catch (SocketException e) {
            System.out.println("Socket: " + e.getMessage());
        } catch (IOException e) {
            System.out.println("IO: " + e.getMessage());
        }
        catch (IndexOutOfBoundsException e) {
            System.out.println("IndexOutOfBounds: " + e.getMessage());
            main(e.getMessage().split(" "));

        }finally {
            if (aSocket != null)
                aSocket.close();
        }
    }

    public static String menu(String comand){
        try{
        if (comand.contains("!listarSalas")){
            return listarSalas();
        }
        else if(comand.contains("!criarSala")){
            return criaSala(comand.split(";"));
        }
        else if(comand.contains("!listarParticipantes")){

            return listarParticipantes(comand.split(";")[1]);
        }
        else if (comand.contains("!entrar")){
            String[] info=comand.split(";");
            String nomeDaSala=info[1];
            String nomeClient=info[0].split(":")[0];
            return entrarSala(nomeDaSala,nomeClient);
        }
        else if(comand.contains("!criarSala")){
            return criaSala(comand.split(";"));
        }
        else if(comand.contains("!quit")){
            return quit(comand.split(";"));
        }
        else if(comand.contains("!removerSala")){
            return removerSala(comand.split(";")[1]);
        }
        else {
            return "-------------MENU----------------\n"+
                    "1) !criarSala;nomeDaSala;ipMultcast + Enter -> cria a sala\n"+
                    "2) !entrar;nomeDaSala + Enter -> entra na sala\n"+
                    "3) !listarSalas + Enter -> lista salas\n"+
                    "4) !listarParticipantes;nomeDaSala + Enter -> lista particioantes\n"+
                    "5) !removerSala;nomeDaSala + Enter -> Exclui Sala";

        }
        }
        catch (IndexOutOfBoundsException e){
            return "Comando incompleto escreva novamente";
        }
    }

    public static String listarSalas(){
        String retorno="----------Lista de Salas----------\n";
        if(!salas.isEmpty()){
            for (int i=0;i<salas.size();i++){
                retorno +=(i+1)+") "+salas.get(i).getNome()+"\n";
            }
            return retorno;
        }
        else return "Nenhuma sala foi criada ainda\n";
    }
    public static String criaSala(String info[]){
        String retorno;
            retorno="";
            String nomeDaSala=info[1];
            String ip=info[2];
            String[] nome=info[0].split(":");
            Sala adicionada=new Sala(nomeDaSala,ip);
            if(salas.stream().noneMatch(x->x.getNome().toLowerCase(Locale.ROOT).equals(nomeDaSala.toLowerCase(Locale.ROOT)))) {
                salas.add(new Sala(nomeDaSala, ip));
                retorno ="Sala criada com sucesso";
            }
            else
                retorno= "Erro: sala ja existente";
        return retorno;
    }
    public static String removerSala(String salaName){
        salas.remove(indexByNameSala(salaName));
        return "Sala removida com sucesso";
    }
    public static String entrarSala(String nomeDaSala,String nomeClient) {
            salas.get(indexByNameSala(nomeDaSala)).adicionarParticipante(nomeClient);
            System.out.println(salas.get(indexByNameSala(nomeDaSala)).getIp());
            return "!conect;"+nomeDaSala+";"+salas.get(indexByNameSala(nomeDaSala)).getIp()+";"+"7000";
    }
    public static String listarParticipantes(String nomeDaSala){
            return salas.get(indexByNameSala(nomeDaSala)).getParticipantes();
    }
    public static String quit(String[]info){
            salas.get(indexByNameSala(info[1])).removerParticipante(info[2]);
            return "Saida do chat com sucesso!";
    }
    public static int indexByNameSala(String nomeDaSala){
            for (int i=0;i<salas.size();i++){
                if(salas.get(i).getNome().equals(nomeDaSala)){
                    return i;
            }
        }
        return -1;
    }

}
