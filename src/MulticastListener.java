import java.io.EOFException;
import java.io.IOException;
import java.net.*;

public class MulticastListener extends Thread{
    private String ip;
    private String port;
    @Override
    public void run(){
        try {
            byte[] buffer = new byte[1000];
            MulticastSocket mSocket = null;
            mSocket = new MulticastSocket(Integer.parseInt(this.port));
            InetAddress group = InetAddress.getByName(this.ip);
            mSocket.joinGroup(group);
            while (true) {
                DatagramPacket packet = new DatagramPacket(buffer, buffer.length);
                mSocket.receive(packet);
                String msg = new String(packet.getData(), packet.getOffset(), packet.getLength());
                System.out.println(msg);
                if (msg.equals(Client.name+":!quit")) {
                    break;
                }
            }
            mSocket.leaveGroup(group);
            mSocket.close();
        } catch (UnknownHostException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void send(String m) throws IOException {
        DatagramSocket socket = new DatagramSocket();
        InetAddress group = InetAddress.getByName(this.ip);
        byte[] msg = m.getBytes();
        DatagramPacket packet = new DatagramPacket(msg, msg.length, group, Integer.parseInt(this.port));
        socket.send(packet);
    }

    public MulticastListener(String ip, String port) {
        this.ip = ip;
        this.port = port;
        Thread t = new Thread(this);
        t.start();
    }
}
