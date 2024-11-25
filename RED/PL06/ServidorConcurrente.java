import java.io.*;
import java.net.*;
import java.util.*;

public class ServidorConcurrente extends Thread {

    Socket cliente;

    public ServidorConcurrente (Socket s) {
        cliente = s;
    }

    public static void main(String argv[]) throws UnknownHostException, IOException {
        
        int puerto = 7777; 
        int contador = 0;
        
        ServerSocket servidor = new ServerSocket(puerto);
        
        while (true) {
            Socket cliente = servidor.accept(); // Espero un cliente
            // Esta instruccion bloquea el codigo hasta que se accepte un cliente
            
            System.out.println("Se ha conectado un nuevo cliente");
            
            contador++;
            
            // Para atender la peticion se crea un objeto ServidorConcurrente
            // Se ejecuta el constructor sobre el socket "cliente"
            ServidorConcurrente servEco = new ServidorConcurrente(cliente);
            // Y se arranca el hilo para atender al cliente en paralelo
            
            servEco.setName("Cliente" + contador);
            
            servEco.start();
        } 
    }
    
    public void run() {
        try {
            Scanner recibe = new Scanner(cliente.getInputStream());
            PrintWriter envia = new PrintWriter(cliente.getOutputStream(),true);
                
            while (true) {
                String mensaje = recibe.nextLine();
                envia.println(mensaje);
                if (mensaje.equalsIgnoreCase("FIN")) { break; }
            }
            
            cliente.close();
        } catch (Exception e) { System.out.println(e); }
    }
}
