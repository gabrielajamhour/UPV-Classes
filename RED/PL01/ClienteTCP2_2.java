import java.net.*;
import java.io.*;
import java.util.Scanner;

public class ClienteTCP2_2 {

	public static void main(String args[]) throws UnknownHostException, IOException {
		Socket s=new Socket("wwww.upv.es", 80);
		System.out.println("¡Conectado!");
		s.close();
		System.out.println("Desconectado");
	}
}
