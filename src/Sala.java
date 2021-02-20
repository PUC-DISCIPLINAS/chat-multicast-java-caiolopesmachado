import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.ArrayList;

public class Sala implements Comparable{
    private String nome;
    private String ip;
    public ArrayList<String> participantes=new ArrayList();

    public Sala(String nome, String ip)throws NullPointerException {
        this.nome = nome;
        this.ip = ip;
    }

    public String getParticipantes(){
        if(participantes.isEmpty()){
            return "Não há ninguem no chat";
        }
        String retorno="------ Lista de Participantes -------\n";
        for (int i=0;i<participantes.size();i++){
            retorno+=(i+1)+") "+participantes.get(i)+"\n";
        }
        return retorno;
    }
    public void adicionarParticipante(String nome){
        participantes.add(nome);
    }
    public void removerParticipante(String nome){
        participantes.remove(nome);
    }

    public String getIp() {
        return ip;
    }

    public String getNome() {
        return nome;
    }

    @Override
    public int compareTo(Object o) {
        return compareTo((Sala) o);
    }
    public int compareTo(Sala o){
        return this.getNome().compareTo(o.getNome());
    }
}
