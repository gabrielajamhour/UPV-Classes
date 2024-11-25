package pract5;

import java.io.File;
import java.util.Scanner;
import java.io.FileNotFoundException;
import pract4.utilPRG.CorrectReading;
/**
 * TextComparing 
 * Clase que calcula la union o interseccion
 * de las palabras de ciertos textos.
 *
 * @author (PRG. ETSINF. UPV)
 * @version (Curso 2023/24)
 */
public class TextComparing {

    private final static String DELIMITERS = 
        "[\\p{Space}\\p{Punct}\\p{Digit}¡¿]+";

    /**
     * Pide al usuario el nombre de dos ficheros de texto, y realiza 
     * la interseccion o la union de los conjuntos de palabras en
     * los textos.
     * 
     * Resultado en la salida estandar.
     */
    public static void main(String[] args) {  
        Scanner keyB = new Scanner(System.in);  
        System.out.print("Nombre del primer fichero: "); 
        String nF1 = keyB.next();
        System.out.print("Nombre del segundo fichero: "); 
        String nF2 = keyB.next();
        Scanner s1 = null; Scanner s2 = null;             
        try {
            // Apertura de los ficheros:
            s1 = new Scanner(new File(nF1));
            s2 = new Scanner(new File(nF2));
            s1.useDelimiter(DELIMITERS);
            s2.useDelimiter(DELIMITERS);
            // Lectura de los conjuntos a partir de los ficheros:
            SetString cS1 = SetString.setReading(s1); // COMPLETADO            
            SetString cS2 = SetString.setReading(s2); // COMPLETADO

            // Lectura de la opción y procesamiento de los conjuntos
            int option = menu(keyB);
            switch(option) {
                case 1:
                    SetString intersection = cS1.intersection(cS2); // COMPLETADO 
                    System.out.println(intersection);
                    break;
                case 2:
                    SetString union = cS1.union(cS2); // COMPLETADO
                    System.out.println(union);
                    break;
            }  

        } catch (FileNotFoundException e) {
            System.out.print("Mal acceso al fichero: " + e.getMessage());
        } finally {
            if (s1 != null) { s1.close(); }
            if (s2 != null) { s2.close(); }        
        }    
    }   

    /**
     * Muestra un menu de opciones por pantalla y
     * lee desde teclado una opcion valida.
     * @param kb Scanner, el teclado.
     * @return int, la opcion valida.
     */
    private static int menu(Scanner kb) {        
        String msg = "======================================\n"
            + "OPCIONES: \n"
            + "   1. Intersección de los conjuntos de palabras.\n"
            + "   2. Unión de los conjuntos de palabras.\n";
        int result = CorrectReading.nextInt(kb, msg, 1, 2);    
        return result;
    }    
}
