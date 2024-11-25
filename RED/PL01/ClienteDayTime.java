import java.net.*;
import java.io.*;
import java.util.Scanner;

public class ClienteDayTime {

	public static void main(String args[]) throws UnknownHostException, IOException {
		Socket s=new Socket("zoltar.redes.upv.es", 13);
		System.out.println("Conectado");
		
		Scanner entrada=new Scanner(s.getInputStream());
		System.out.println(entrada.nextLine());
		
		s.close();
		System.out.println("Desconectado");
	}
}
