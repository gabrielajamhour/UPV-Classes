package exam2;

import java.util.Scanner;
import others2.DateTime;
import others2.Event;
import others2.TimeInstant;
import others2.UtilEvent;
/**
 * Clase TestEventsStartTimeAt: clase programa para facilitar la prueba del código, 
 * desarrollado por el alumno, para el método eventsStartTimeAt(TimeInstant).
 *
 * Esta clase es para uso particular del alumno. 
 * No se entrega.
 * 
 * @author Parcial 2 - Ejercicio 2 
 * @version IIP - Curso 2023/24
 */
public class TestEventsStartTimeAt {
    private static Event[] event = {
        new Event(new DateTime(15, 1, 2024, 9, 30), new DateTime(24, 1, 2024, 20, 30), "FABERGÉ", Event.EXHIBITION),
        new Event(new DateTime(16, 3, 2024, 18, 0), new DateTime(20, 3, 2024, 21, 0), "CIRQUE DU SOLEIL", Event.SHOW),
        new Event(new DateTime(1, 5, 2024, 9, 30), new DateTime(25, 6, 2024, 20, 0), "SOROLLA", Event.EXHIBITION),
        new Event(new DateTime(29, 11, 2024, 10, 30), new DateTime(29, 11, 2024, 13, 30), "JIDINF'24", Event.CONGRESS),
        new Event(new DateTime(22, 12, 2024, 9, 30), new DateTime(6, 1, 2025, 20, 30), "PLAYMOBIL", Event.EXHIBITION)
    };
    
    private TestEventsStartTimeAt() {  }

    public static void main(String[] args)  {
        Scanner keyB = new Scanner(System.in);
        
        Calendar c = new Calendar();
        for (int i = 0; i < event.length; i++) {
            boolean add = c.add(event[i]);
        }
        System.out.println("Se crea un calendario con los 5 eventos que siguen, ");
        System.out.println("fíjate en su instante de inicio:\n");
        System.out.println(c.toString());
        System.out.println("** Prueba 1: llamada a eventsStartTimeAt para obtener ");
        System.out.println("un String con todos los eventos que comiencen a las 09:00.");        
        System.out.println("Pulsa INTRO para continuar..."); 
        String s = keyB.nextLine();
        System.out.println(c.eventsStartTimeAt(new TimeInstant(9, 0)));
        System.out.println("...Comprueba que no se muestra ningún evento porque ninguno comienza a las 09:00.");
        System.out.println("Pulsa INTRO para continuar..."); 
        s = keyB.nextLine();
        System.out.print('\u000C'); // Limpia el terminal
        
        System.out.println("** Prueba 2: llamada a eventsStartTimeAt para obtener ");
        System.out.println("un String con todos los eventos que comiencen a las 09:30.");        
        System.out.println("Pulsa INTRO para continuar..."); 
        s = keyB.nextLine();
        System.out.println(c.eventsStartTimeAt(new TimeInstant(9, 30)));
        System.out.println("...Comprueba que se muestran los eventos que comienzan a las 09:30,\n"
            + "con títulos: FABERGÉ, SOROLLA y PLAYMOBIL.");
        System.out.println("Pulsa INTRO para continuar..."); 
        s = keyB.nextLine();        
        System.out.print('\u000C'); // Limpia el terminal 
        
        // Cambia el instante de inicio de todos los eventos a las 09:30
        for (int i = 0; i < event.length; i++) {
            event[i].getStartTime().setInstant(9, 30);
        }
        System.out.println("Ahora las 09:30 es el instante de inicio de todos los eventos.");
        System.out.println("** Prueba 3: llamada a eventsStartTimeAt para obtener ");
        System.out.println("un String con todos los eventos que comiencen a las 09:30.");        
        System.out.println("Pulsa INTRO para continuar..."); 
        s = keyB.nextLine();    
        System.out.println(c.eventsStartTimeAt(new TimeInstant(9, 30)));
        System.out.println("...Comprueba que se muestran todos los eventos, con títulos:\n"
            + "FABERGÉ, CIRQUE DU SOLEIL, SOROLLA, JIDINF'24 y PLAYMOBIL.");
              
        System.out.println("\nFin de las pruebas!!!"); 
    }
}
