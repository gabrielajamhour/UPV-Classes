package pract5;
 
import java.util.Scanner;
/**
 * Clase {@code Test5}: permite probar parte de la funcionalidad 
 * de la clase {@link DateTime}, en cuyo main se deben realizar 
 * las siguientes acciones:<br>
 * a. Solicitar al usuario que introduzca desde teclado los valores 
 *    de horas, minutos, día, mes y anyo.
 * b. Si los datos no corresponden a un instante y una fecha correctos, 
 *    mostrar un mensaje por pantalla.
 * c. Si lo son:
 *    - Crear un DateTime dT con estos datos.
 *    - Crear un DateTime now con la fecha y el instante UTC actuales.
 *    - Comparar dT y now.
 *    - Mostrar por pantalla si dT es anterior, posterior o igual a now.
 *    
 * @author IIP 
 * @version Curso 2023-24
 */
public class Test5 {
    /** No hay objetos de esta clase. */
    private Test5() { }
    
    /**
     * Método principal.
     * @param args array de {@link String}.
     */
    public static void main(String[] args) {
        // a. Solicitar al usuario que introduzca desde teclado los valores 
        //    de horas, minutos, día, mes y anyo.
        Scanner kbd = new Scanner(System.in);
        System.out.print("Horas? ");
        int hours = kbd.nextInt();
        System.out.print("Minutos? ");
        int minutes = kbd.nextInt();
        System.out.print("Día? ");
        int day = kbd.nextInt();
        System.out.print("Mes? ");
        int month = kbd.nextInt();
        System.out.print("Anyo? ");
        int year = kbd.nextInt();
        
        // COMPLETAR
        // b. Si los datos no corresponden a un instante y una fecha correctos, 
        //    mostrar un mensaje por pantalla.
        
        if (hours > 24 || hours < 0 || month > 12 || month < 0 || year < 0 || day < 0 || day > 31) {
            System.out.print("Error.");
        }
        
        // c. Si lo son:
        //    - Crear un DateTime dT con estos datos.
        //    - Crear un DateTime now con la fecha y el instante UTC actuales.
        //    - Comparar dT y now.
        //    - Mostrar por pantalla si dT es anterior, posterior o igual a now.
        
        DateTime dT = new DateTime(hours, minutes, day, month, year);
        DateTime now = new DateTime(21, 11, 2023);
        int res = dT.compareTo(now);
        
        if (res == 0) {
            System.out.print("El instante que has inserido es igual al instante atual.");
        }
        else if (res < 0) {
            System.out.print("El instante que has inserido es anterior al instante atual.");
        }
        else {
            System.out.print("El instante que has inserido es posterior al instante atual.");
        } 
    }
}
