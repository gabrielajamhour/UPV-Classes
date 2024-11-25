import java.net.*;
import java.io.*;
import java.util.Scanner;

public class ClienteHTTP {

	public static void main(String args[]) throws UnknownHostException, IOException {
		Socket s = new Socket("www.upv.es", 80);
		System.out.println("Conectado");
		
		PrintWriter salida = new PrintWriter(s.getOutputStream());
		salida.printf("GET / HTTP/1.0\r\n\r\n");
		salida.flush();
		
		Scanner entrada = new Scanner(s.getInputStream());
		while(entrada.hasNext()) {
			System.out.println(entrada.nextLine());
		}
		
		s.close();
		System.out.println("Desconectado");
	}
}
