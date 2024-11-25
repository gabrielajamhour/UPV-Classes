package pract5;

import java.util.Scanner;
/**
 * Clase programa para facilitar la prueba del código, desarrollado por 
 * el alumno, para el método removeContains.
 * 
 * Se realizan 9 pruebas partiendo de diferentes conjuntos y eliminando 
 * mediante el método removeContains(String) las palabras de una longitud dada:
 * 
 * El main crea un conjunto con 5 palabras: "blue" "green" "pink" "purple" "yellow"
 * 
 * 1.- Llamar al método removeContains("red") para eliminar las palabras que contienen
 *     el substring "red" y comprobar que el conjunto no cambia porque no hay ninguna 
 *     que contenga dicho substring. 
 * 2.- Llamar al método removeContains("in") para eliminar las palabras que contienen
 *     el substring "in" y comprobar que se elimina la palabra "pink" (la de enmedio).    
 * 3.- Llamar al método removeContains("lu") para eliminar las palabras que contienen
 *     el substring "lu" y comprobar que se elimina la palabra "blue" (la primera) 
 *     y es "green" la que pasa a ser la primera.
 * 4.- Llamar al método removeContains("ello") para eliminar las palabras que contienen
 *     el substring "ello" y comprobar que se elimina la palabra "yellow" (la última) 
 *     y es "purple" la que pasa a ser la última.
 * 5.- Llamar al método removeContains("r") para eliminar las palabras que contienen
 *     el substring "r" y comprobar que se eliminan las palabras "green" y "purple" 
 *     y el conjunto se queda sin palabras.
 * 6.- Llamar al método removeContains("red") para eliminar las palabras que contienen
 *     el substring "red" y comprobar que no ocurre nada porque el conjunto está vacío.
 * 
 * El main crea un conjunto con 5 palabras: "blue" "green" "plum" "red" "yellow"
 * 
 * 7.- Llamar al método removeContains("l") para eliminar las palabras que contienen
 *     el substring "l" y comprobar que se eliminan las palabras "blue", "plum" y "yellow".
 *     
 * El main crea un conjunto con 5 palabras: "blue" "green" "plum" "red" "yellow"
 * 
 * 8.- Llamar al método removeContains("r") para eliminar las palabras que contienen
 *     el substring "r" y comprobar que se eliminan las palabras "green" y "red".
 * 
 * 9.- Llamar al método removeContains("l") para eliminar las palabras que contienen
 *     el substring "l" y comprobar que se eliminan todas las palabras, quedando 
 *     el conjunto vacío.
 *     
 * Esta clase es para uso particular del alumno. 
 * No se entrega. 
 * 
 * @author PRG
 * @version Curso 2023-24
 */
public class TestRemoveContains {
    private TestRemoveContains() { } // No se usan objetos de esta clase
    
    public static void main(String[] args)  {      
        SetStringExam sSE = new SetStringExam();
        sSE.add("blue"); sSE.add("green"); sSE.add("pink"); sSE.add("purple"); sSE.add("yellow"); 
        
        System.out.println("Se crea un conjunto con las 5 palabras que siguen:\n");
        System.out.println(sSE);
        
        System.out.println("** Prueba 1: llamada a removeContains(\"red\") para eliminar \n"
            + "las palabras que contienen el substring \"red\".");              
        pressEnterToContinue();
        sSE.removeContains("red");
        System.out.println(list(sSE));
        System.out.println("...Comprueba que el conjunto no ha cambiado porque\n"
            + " no hay ninguna que contenga dicho substring.");
        pressEnterToContinue();
        
        System.out.println("** Prueba 2: llamada a removeContains(\"in\") para eliminar \n"
            + "las palabras que contienen el substring \"in\".");      
        pressEnterToContinue();
        sSE.removeContains("in");
        System.out.println(list(sSE));
        System.out.println("...Comprueba que se ha eliminado la palabra \"pink\" (la de enmedio).");
        pressEnterToContinue();
        
        System.out.println("** Prueba 3: llamada a removeContains(\"lu\") para eliminar \n"
            + "las palabras que contienen el substring \"lu\".");                
        pressEnterToContinue();
        sSE.removeContains("lu");
        System.out.println(list(sSE));
        System.out.println("...Comprueba que se ha eliminado la palabra \"blue\" (la primera)");
        System.out.println(" y \"green\" ha pasado a ser la primera.");
        pressEnterToContinue();
        
        System.out.println("** Prueba 4: llamada a removeContains(\"ello\") para eliminar \n"
            + "las palabras que contienen el substring \"ello\".");   
        pressEnterToContinue();
        sSE.removeContains("ello");
        System.out.println(list(sSE));
        System.out.println("...Comprueba que se ha eliminado la palabra \"yellow\" (la última)");
        System.out.println(" y \"purple\" ha pasado a ser la última.");
        pressEnterToContinue();
        
        System.out.println("** Prueba 5: llamada a removeContains(\"r\") para eliminar \n"
            + "las palabras que contienen el substring \"r\".");    
        pressEnterToContinue();
        sSE.removeContains("r");
        System.out.println(list(sSE));
        System.out.println("...Comprueba que se han eliminado las palabras \"green\" y \"purple\""); 
        System.out.println(" y el conjunto se ha quedado sin palabras.");
        pressEnterToContinue();
        
        System.out.println("** Prueba 6: llamada a removeContains(\"red\") para eliminar \n"
            + "las palabras que contienen el substring \"red\".");                  
        pressEnterToContinue();
        sSE.removeContains("red");
        System.out.println(list(sSE));
        System.out.println("...Comprueba que no ha ocurrido nada porque el conjunto está vacío.");
        pressEnterToContinue();
        
        sSE = new SetStringExam();
        sSE.add("blue"); sSE.add("green"); sSE.add("plum"); sSE.add("red"); sSE.add("yellow"); 
        
        System.out.println("Se crea un conjunto con las 5 palabras que siguen:\n");
        System.out.println(sSE);
        
        System.out.println("** Prueba 7: llamada a removeContains(\"l\") para eliminar \n"
            + "las palabras que contienen el substring \"l\".");      
        pressEnterToContinue();
        sSE.removeContains("l");
        System.out.println(list(sSE));
        System.out.println("...Comprueba que se han eliminado las palabras \"blue\", \"plum\" y \"yellow\"."); 
        pressEnterToContinue();
        
        sSE = new SetStringExam();
        sSE.add("blue"); sSE.add("green"); sSE.add("plum"); sSE.add("red"); sSE.add("yellow"); 
        
        System.out.println("Se crea un conjunto con las 5 palabras que siguen:\n");
        System.out.println(sSE);
        
        System.out.println("** Prueba 8: llamada a removeContains(\"r\") para eliminar \n"
            + "las palabras que contienen el substring \"r\".");     
        pressEnterToContinue();
        sSE.removeContains("r");
        System.out.println(list(sSE));
        System.out.println("...Comprueba que se han eliminado las palabras \"green\" y \"red\"."); 
        pressEnterToContinue();
                
        System.out.println("** Prueba 9: llamada a removeContains(\"l\") para eliminar \n"
            + "las palabras que contienen el substring \"l\".");    
        pressEnterToContinue();
        sSE.removeContains("l");
        System.out.println(list(sSE));
        System.out.println("...Comprueba que se han eliminado todas las palabras, quedando el conjunto vacío."); 
        
        System.out.println("\nFin de las pruebas!!!"); 
    }
    
    /**
     * Dado un SetStringExam s, devuelve el resultado de aplicarle el método toString().
     * Si el conjunto está vacío, devuelve "empty set\n".
     */
    private static String list(SetStringExam s) {
        String list = s.toString();
        if (list.equals("")) { return "empty set\n"; }
        return list;
    }
    
    private static void pressEnterToContinue() {
        Scanner keyB = new Scanner(System.in);  
        System.out.println("Pulsa ENTER \u21B5 para continuar..."); 
        String s = keyB.nextLine();
    }
}
