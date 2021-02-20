import java.io.IOException;
import java.net.*;
import java.util.Scanner;

public class Client {
    public static DatagramSocket aSocket = null;
    public static String ipServer="192.168.0.12";
    public static String name;
    public static void main(String args[]) {
        // args fornecem a mensagem e o endere�o do servidor.
        Scanner scan = new Scanner(System.in);

        int serverPort = 6789;
        String message;
        System.out.println("Escreva o seu nickname :");
        name=scan.nextLine();
        try {
            aSocket = new DatagramSocket();
            System.out.println("Aperte ENTER para aparecer o menu");
            while(true) {
                System.out.println("Escreva o comando:");
                scan=new Scanner(System.in);
                String m = name+":"+scan.nextLine();
                InetAddress aHost = InetAddress.getByName(ipServer);
                DatagramPacket request = new DatagramPacket(m.getBytes(), m.length(), aHost, serverPort);
                aSocket.send(request);
                byte[] buffer = new byte[100000];
                DatagramPacket reply = new DatagramPacket(buffer, buffer.length);
                aSocket.receive(reply);
                message = new String(reply.getData()).trim();
                if(message.contains("!conect")) {

                    aSocket.send(endChat(ipServer,6789,name,startChat(message.split(";"),name)));
                    System.exit(0);
                }
                else
                System.out.println("\n\n\n\n\n\nResposta: \n" + message);
            }
        } catch (SocketException e) {
            System.out.println("Socket: " + e.getMessage());
        } catch (IOException e) {
            System.out.println("IO: " + e.getMessage());
        } finally {
            if (aSocket != null)
                aSocket.close();
        }
    }
    public static String startChat(String[] info,String name) throws IOException {
        MulticastListener mSocket=new MulticastListener(info[2],info[3]);
        Scanner scan= new Scanner(System.in);
        System.out.println("Apartir de agora voce poderá mandar mensagens!");
        System.out.println("Escreva !quit para sair");
        while (true) {
            String m =name+":"+ scan.nextLine();
            if (m.contains("!quit")) {
                break;
            }
            mSocket.send(m);
        }
        return info[1];
    }
    public static DatagramPacket endChat(String ip,int port,String name, String salaName) throws IOException {
        String m="!quit;"+salaName+";"+name+";";
        DatagramPacket request = new DatagramPacket(m.getBytes(), m.length(), InetAddress.getByName(ip), port);
        return request;
    }

}
