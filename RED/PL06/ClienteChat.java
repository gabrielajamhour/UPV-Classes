import java.io.*;
import java.net.*;
import java.util.*;

public class ClienteChat extends Thread {

    Socket cliente;

    public ClienteChat (Socket s) {
        cliente = s;
    }

    public static void main(String[] args) throws UnknownHostException, IOException {
        int puerto = 7777; 
        int contador = 0;
        
        Socket s = new Socket("localhost", 7777);
        
        PrintWriter envia = new PrintWriter(s.getOutputStream(),true);
        Scanner teclado = new Scanner(System.in);
        
        ClienteChat serv = new ClienteChat(s);
            
        serv.start();
        
        while (true) {           
            String mensaje = teclado.nextLine();
            envia.println(mensaje);
            if (mensaje.equalsIgnoreCase("quit")) { break; }
        }
    }
    
    public void run() {
        try {
            Scanner recibe = new Scanner(cliente.getInputStream());
            
            while (true) {
                String mensaje = recibe.nextLine();
                System.out.println(mensaje);
            }
        } catch (Exception e) { System.out.println(e); }
    }
}

