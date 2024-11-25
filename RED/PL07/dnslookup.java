import java.net.InetAddress;
import java.net.UnknownHostException;

public class dnslookup {
    public static void main(String[] args) {

        String hostname = args[0];

        try {
            InetAddress nombreHost = InetAddress.getByName(hostname);
            System.out.println(nombreHost.toString());
        } catch (UnknownHostException e) {
            System.out.println("No se pudo traducir el nombre del host '" + hostname + "'");
        }
    }
}
