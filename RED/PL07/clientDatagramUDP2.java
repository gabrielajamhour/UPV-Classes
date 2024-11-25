import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class clientDatagramUDP2 {
    public static void main(String[] args) {
    
        String mensaje = "Hola mundo";

        try {
            DatagramSocket ds = new DatagramSocket();
            
            DatagramPacket dp = new DatagramPacket(mensaje.getBytes(), mensaje.getBytes().length, InetAddress.getByName("localhost"), 7777);
            
            ds.send(dp);

            byte[] buffer = new byte[1000];
            
            DatagramPacket p = new DatagramPacket(buffer, 1000);

            ds.receive(p);

            String s = new String(p.getData(), 0, p.getLength());
            System.out.println(s);

            ds.close();
        } catch (Exception e) {
 System.out.println(e); }
    }
}
