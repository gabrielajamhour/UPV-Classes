package exam1;

import java.util.Scanner;
import others.TimeInstant;
/**
 * Clase MainExam: clase programa que usa la clase TimeInstant del paquete others, 
 * identica a tu clase TimeInstant con el metodo divideBy2() correcto. 
 * 
 * @author IIP
 * @version Curso 2023-24
 */
public class MainExam {
    // No se usan objetos de esta clase
    private MainExam() { }
    
    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);
        System.out.println("Lectura de teclado de una hora.");
        System.out.print("   -> Introduzca las horas (entre 0 y 23): ");
        int h = teclado.nextInt();
        System.out.print("   -> Introduzca los minutos (entre 0 y 59): ");
        int m = teclado.nextInt();
        // Una vez leidos los datos de horas y minutos desde el teclado y 
        // suponiendo que son correctos:
        // a) Crea un TimeInstant ti a partir de dichos datos,
        TimeInstant ti = new TimeInstant(h, m);
        
        // b) Muestra por pantalla ti (en el formato "hh:mm")        
        System.out.println(ti.toString());
        
        // c) Actualiza las horas y los minutos de ti dividiendolos entre 2,
        //    haciendo uso del metodo divideBy2
        ti.divideBy2();
        
        // d) Muestra de nuevo por pantalla ti (en el formato "hh:mm")        
        System.out.println(ti.toString());
    }
}
