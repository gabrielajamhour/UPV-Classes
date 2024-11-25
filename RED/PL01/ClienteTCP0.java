import java.net.*;
import java.io.*;
import java.util.Scanner;

public class ClienteTCP0 {
	public static void main(String args[]) throws UnknownHostException, IOException {
		Socket s=new Socket("zoltar.redes.upv.es", 7);
		System.out.println("Conectado");
		
		PrintWriter salida = new PrintWriter(s.getOutputStream());
		salida.printf("Hola Mundo!\r\n");
		salida.flush();
		
		Scanner entrada=new Scanner(s.getInputStream());
		System.out.println(entrada.nextLine());
		
		s.close();
		System.out.println("Desconectado");
	}
}
