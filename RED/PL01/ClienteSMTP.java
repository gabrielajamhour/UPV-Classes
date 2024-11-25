import java.net.*;
import java.io.*;
import java.util.Scanner;

public class ClienteSMTP {
	public static void main(String args[]) throws UnknownHostException, IOException {
		Socket s=new Socket("smtp.upv.es", 25);
		System.out.println("Conectado");
		
		PrintWriter salida = new PrintWriter(s.getOutputStream());
		salida.print("HELO rdc14.redes.upv.es\r\n");
		salida.flush();

		Scanner entrada=new Scanner(s.getInputStream());
		System.out.println(entrada.nextLine());
		
		s.close();
		System.out.println("Desconectado");
	}
}
