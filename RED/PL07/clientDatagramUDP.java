import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class clientDatagramUDP {
    public static void main(String[] args) {
    
        String nombre = "Gabriela Rego Jamhour";

        try {
        
            DatagramSocket ds = new DatagramSocket();
        
            DatagramPacket dp = new DatagramPacket(nombre.getBytes(), nombre.getBytes().length, InetAddress.getByName("localhost"), 7777);
            
            ds.send(dp);
            
            ds.close();
        } catch (Exception e) { System.out.println(e); }
    }
}
