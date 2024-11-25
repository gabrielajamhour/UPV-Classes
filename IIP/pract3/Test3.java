package pract3;

import java.util.Scanner;

/**
 *  Clase Test3.
 *  Una primera clase con lectura de datos desde teclado, 
 *  y uso de operaciones con int, long, Math y String.
 *  Contiene tres errores de compilacion.
 *  @author IIP 
 *  @version Curso 2023-24
 */
 
public class Test3 {
    public static void main(String[] args){
        // ----- Actividad 4 ----- //
        Scanner kbd=new Scanner(System.in);
        System.out.println("Lectura de teclado de una hora.");
        System.out.print("   -> Introduzca las horas (entre 0 y 23): ");
        int h = kbd.nextInt();
        System.out.print("   -> Introduzca los minutos (entre 0 y 59): ");
        int m = kbd.nextInt();
        
        int len = 0;
        
        String horas = "0" + h;
        len = horas.length();
        horas = horas.substring(len - 2);
        
        String minutos = "0" + m;
        len = minutos.length();
        minutos = minutos.substring(len - 2);
        
        String hhmmIntroducidos = horas + ":" + minutos;
        
        System.out.println("Hora introducida: " + hhmmIntroducidos);
        
        // ----- Actividad 5 ----- //
        
        long tMinTotal = System.currentTimeMillis() / (60 * 1000);
    
        int tMinCurrent = (int) (tMinTotal % (24 * 60));
        // Devuelve los minutos actuales
    
        int horasUTC = tMinCurrent / 60;
        // Devuelve las horas actuales
    
        int minutosUTC = tMinCurrent % 60;
        // Devuelve los minutos actuales
            
        int lenUTC = 0;
        
        String hUTC = "0" + horasUTC;
        lenUTC = hUTC.length();
        hUTC = hUTC.substring(lenUTC - 2);
        
        String minUTC = "0" + minutosUTC;
        lenUTC = minUTC.length();
        minUTC = minUTC.substring(lenUTC - 2);
        
        String hhmmActuales = hUTC + ":" + minUTC;
    
        System.out.println("Hora actual: " + hhmmActuales + " (tiempo UTC)");
        
        // ----- Actividad 6 ----- //
        
        int diferencia = Math.abs(tMinCurrent - (h * 60 + m));
        int diferenciaHoras = diferencia / 60;
        int diferenciaMinutos = diferencia % 60;
        
        System.out.println("La diferencia en minutos entre ambas horas: " + diferencia + " (" + diferenciaHoras + " hor. y " + diferenciaMinutos + " min.)");
    } 
}
