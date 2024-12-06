import java.net.*;
import java.io.*;
import java.util.Scanner;

class ServidorECO {

    public static void main(String args[]) {
    
        try{
            ServerSocket ss = new ServerSocket(7777);
            while(true){
            Socket s = ss.accept(); // Espera un cliente
            
            Scanner recibe = new Scanner(s.getInputStream());
            String mensaje = recibe.nextLine();
            
            PrintWriter envia = new PrintWriter(s.getOutputStream(),true);
            envia.println(mensaje);
            envia.flush();
            System.out.println("Se ha conectado un cliente al servidor");
            
            recibe.close();
            envia.close();
            s.close();
            }
        } catch(IOException e) { System.out.println(e); }
    }
}
