import java.net.*;
import java.io.*;
import java.util.Scanner;

public class ClienteTCP2 {

	public static void main(String args[]) throws UnknownHostException, IOException {
		Socket s=new Socket("www.upv.es", 81);
		System.out.println("¡Conectado!");
		s.close();
		System.out.println("Desconectado");
	}
}
