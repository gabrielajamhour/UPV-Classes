import java.net.*;
import java.io.*;
import java.util.*;
a
class ClienteHTTP {

  static String nombre_servidor;
  static Socket s;
  static ScannerRedes entrada;
  static PrintWriter salida;
  static int longitud;
  

  public static void envia_peticion(String objeto) {
	salida.printf("GET / HTTP/1.1\r\n");
	salida.printf("Host: zoltar.redes.upv.es\r\n");
	salida.printf("Connection: close\r\n");
	salida.printf("\r\n");		// Línea en blanco que determina el final de la petición
	salida.flush();
  }

  public static void lee_linea_estado() {
    System.out.println(">>>>>>>>>>>>>>> LINEA DE ESTADO <<<<<<<<<<<<<<<");
    System.out.println(entrada.nextLine());

  }

  public static void lee_cabeceras() {
    System.out.println(">>>>>>>>>>>>>>>    CABECERAS    <<<<<<<<<<<<<<<");
    longitud = -1;
    while(entrada.hasNext()) {
    	String linea = entrada.nextLine();
    	if (linea.isEmpty()) { break; }
    	System.out.println(linea);
	if (linea.contains("Content-Length: ")) {
           longitud = extrae_entero(linea);
	}
    }
  }
  
  public static int extrae_entero(String cadena) {
     String tmp = cadena.replaceAll("[^0-9]", "");
     return Integer.parseInt(tmp);
  }

  public static void lee_cuerpo_texto() {
    System.out.println(">>>>>>>>>>>>>>>   CUERPO TEXTO  <<<<<<<<<<<<<<<");
    while(entrada.hasNext()) {
    	System.out.println(entrada.nextLine());
    }
  }

  public static void lee_cuerpo_binario(String nombre_fichero) throws IOException {
    System.out.println(">>>>>>>>>>>>>>>  CUERPO BINARIO <<<<<<<<<<<<<<<");
    int contador = 0;
    for (int i = 0; i < longitud; i++) {
    	int byteS = s.getInputStream().read();
    	System.out.print(byteS + " ");
    	contador++;
    }
  }



  public static void main(String args[]) throws Exception {
    nombre_servidor = "zoltar.redes.upv.es";
    s = new Socket(nombre_servidor, 80);
    entrada = new ScannerRedes(s.getInputStream());
    salida = new PrintWriter(s.getOutputStream());
    
    //envia_peticion("/");
    envia_peticion("/oto1.jpg");
    lee_linea_estado();
    lee_cabeceras();
    //lee_cuerpo_texto();
    lee_cuerpo_binario("oto1.jpg");

    s.close();
  }

}
