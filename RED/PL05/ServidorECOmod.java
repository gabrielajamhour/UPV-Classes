import java.net.*;
import java.io.*;
import java.util.Scanner;

class ServidorECOmod {

    public static void main(String args[]) {
        try {
            // Crear el ServerSocket para escuchar en el puerto 7777
            ServerSocket ss = new ServerSocket(7777);

            while (true) {
                // Aceptar una conexión de cliente
                Socket s = ss.accept();

                // Mostrar dirección IP y puerto del Socket del cliente
                System.out.println("Dirección IP del cliente: " + s.getInetAddress());
                System.out.println("Puerto del cliente: " + s.getPort());

                // Crear un Scanner para recibir datos del cliente
                Scanner recibe = new Scanner(s.getInputStream());
                String mensaje = recibe.nextLine();

                // Crear un PrintWriter para enviar respuesta al cliente
                PrintWriter envia = new PrintWriter(s.getOutputStream(), true);
                envia.println(mensaje); // Devolver el mensaje recibido

                // Cerrar los flujos y la conexión
                recibe.close();
                envia.close();
                s.close();
            }

        } catch (IOException e) {
            System.out.println("Error en el servidor: " + e.getMessage());
        }
    }
}
