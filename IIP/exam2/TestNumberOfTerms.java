package exam2;

import java.util.Locale;
import others2.CasesEx1T4;
/**
 * Clase programa para facilitar la prueba del código, desarrollado por
 * el alumno, para el método numberOfTerms.
 *
 * @author Parcial 2 - Ejercicio 1 
 * @version IIP - Curso 2023/24
 */
public class TestNumberOfTerms {
    
    private TestNumberOfTerms() { }        

    public static void main(String[] args) {
        System.out.println("Se realizan 10 llamadas a numberOfTerms(double).");
        System.out.println("Las dos primeras con epsilon = 0.3 y 2 - Math.sqrt(2).");
        System.out.println("El resto con valores aleatorios para epsilon en [0.0, 1.0[.");
        System.out.println("Se muestra la solución correcta y tu solución.\n");
        
        int solCorrecta = CasesEx1T4.correcto(0.3);
        int solAlumno = IIPMath.numberOfTerms(0.3);
        System.out.printf(Locale.US, 
            "numberOfTerms(%.1f) = %d\n   ---> Tu solución: %d\n", 
            0.3, solCorrecta, solAlumno);
        
        solCorrecta = CasesEx1T4.correcto(2 - Math.sqrt(2));
        solAlumno = IIPMath.numberOfTerms(2 - Math.sqrt(2));
        System.out.printf(Locale.US, 
            "numberOfTerms(%.15f) = %d\n\t\t ---> Tu solución: %d\n", 
            2 - Math.sqrt(2), solCorrecta, solAlumno);   
            
        for (int i = 3; i <= 10; i++) {
            double aleat = Math.random();
            solCorrecta = CasesEx1T4.correcto(aleat);
            solAlumno = IIPMath.numberOfTerms(aleat);
            System.out.printf(Locale.US, 
                "numberOfTerms(%.15f) = %d\n\t\t ---> Tu solución: %d\n", 
                aleat, solCorrecta, solAlumno);
        }         
    }
}
