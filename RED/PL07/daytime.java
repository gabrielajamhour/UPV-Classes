import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.util.Date;

public class daytime {
    public static void main(String[] args) {

        try {
            DatagramSocket ds = new DatagramSocket(7777);

            while (true) {
                byte[] b = new byte[1000];
                DatagramPacket p = new DatagramPacket(b, 1000);

                ds.receive(p);

                Date now = new Date();
                String now_string = now.toString() + "\r\n";
                
                DatagramPacket dp = new DatagramPacket(
now_string.getBytes(), now_string.getBytes().length, 
p.getAddress(), 
p.getPort()
);

                ds.send(dp);
                System.out.println(now_string);
            }
        } catch (Exception e) {
 System.out.println(e);
 }
    }
}
