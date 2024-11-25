import java.net.*;
import java.io.*;
import java.util.Scanner;

public class ClienteTCP3 {

	public static void main(String args[]) throws IOException {
		try {
			Socket s = new Socket("www.upv.es", 80);
			System.out.println("¡Conectado!");
			
			System.out.println("Puerto remoto: " + s.getPort());	
			System.out.println("IP remota: " + s.getInetAddress());	
			System.out.println("Puerto local: " + s.getLocalPort());
			System.out.println("IP local: " + s.getLocalAddress());

			
			s.close();
			System.out.println("Desconectado");
		} catch(UnknownHostException e) {
			System.out.println("Nombre de servidor desconocido");
		} catch(NoRouteToHostException e) {
			System.out.println("No es posible realizar conexión");
		} 
	}
}
