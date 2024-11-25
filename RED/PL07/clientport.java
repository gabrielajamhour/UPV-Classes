import java.net.DatagramSocket;

public class clientport {
    public static void main(String[] args) {
        try {
            DatagramSocket ds = new DatagramSocket();
            
            int p = ds.getLocalPort();
            System.out.println(p);
            
            ds.close();
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
