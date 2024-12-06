import java.net.*;
import java.io.*;
import java.util.Scanner;

public class ClienteSMTP {

        static void error(String cadena) {
		System.out.println(cadena);
		System.exit(0);
	}

	public static void main(String args[]) {
	try{
		Socket s=new Socket("serveis-rdc.redes.upv.es", 25);
		System.out.println("Conectado al servidor SMTP de serveis-rdc");
		PrintWriter salida = new PrintWriter(s.getOutputStream());
		Scanner entrada=new Scanner(s.getInputStream());
		String respuesta = entrada.nextLine();
		System.out.println(respuesta);
		if (!respuesta.startsWith("220")) {error(respuesta);}

		salida.print("HELO 158.42.180.13\r\n");
		salida.flush();
		respuesta = entrada.nextLine();
		System.out.println(respuesta);
		if (!respuesta.startsWith("250")) {error(respuesta);}

		salida.print("MAIL FROM:<redes13@redes.upv.es>\r\n");
		salida.flush();
		respuesta = entrada.nextLine();
		System.out.println(respuesta);
		if (!respuesta.startsWith("250")) {error(respuesta);}

		salida.print("RCPT TO:<redes13@redes.upv.es>\r\n");
		salida.flush();
		respuesta = entrada.nextLine();
		System.out.println(respuesta);
		if (!respuesta.startsWith("250")) {error(respuesta);}

		salida.print("DATA\r\n");
		salida.flush();
		respuesta = entrada.nextLine();
		System.out.println(respuesta);
		if (!respuesta.startsWith("354")) {error(respuesta);}

		salida.print("To: redes13@redes.upv.es\r\n");
		salida.print("From: Alumno de Redes  <redes13@redes.upv.es>\r\n");
		salida.print("Subject: Message\r\n");
		salida.print("\r\n");
		salida.print("Hello world\r\n");
		salida.print(".\r\n");

		salida.flush();
		respuesta = entrada.nextLine();
		System.out.println(respuesta);
		if (!respuesta.startsWith("250")) {error(respuesta);}

		salida.print("QUIT\r\n");
		salida.flush();
		respuesta = entrada.nextLine();
		System.out.println(respuesta);
		if (!respuesta.startsWith("221")) {error(respuesta);}

		s.close();
		System.out.println("Desconectado");

	} catch (UnknownHostException e) {
		System.out.println("Host desconocido");
		System.out.println(e);
	} catch (IOException e) {
		System.out.println("No se puede conectar");
		System.out.println(e);
	}
	}
}
