package pract2;

/**
 * Clase TestPract2: clase programa que prueba 
 * los metodos isPrefix, isSubstring de PRGString
 * 
 * @author PRG - ETSINF - DSIC - UPV
 * @version Curso 2023/2024
 */
public class TestPract2 {
    /** No hay objetos de esta clase */
    private TestPract2() { }
    
    public static void testIsPrefix() {
        String[] s = {"", "rec", "pecur", 
                      "recurso", "remursi", 
                      "123456789", "recursion"};
                      
        System.out.printf("%8s %12s %20s %12s\n", 
            "a", "b", "isPrefix(a, b)", "b.startsWith(a)");
            
        // a y b vacias
        /* COMPLETADO */
        System.out.printf("%8s %12s %20s %12s\n", 
            s[0], s[0], PRGString.isPrefix(s[0], s[0]), s[0].startsWith(s[0]));
                          
        // solo a vacia                          
        /* COMPLETADO */
        System.out.printf("%8s %12s %20s %12s\n", 
            s[0], s[1], PRGString.isPrefix(s[0], s[1]), s[1].startsWith(s[0]));
        
        // solo b vacia                  
        /* COMPLETADO */
        System.out.printf("%8s %12s %20s %12s\n", 
            s[1], s[0], PRGString.isPrefix(s[1], s[0]), s[0].startsWith(s[1]));
                          
        // a de mayor longitud que b                  
        /* COMPLETADO */
        System.out.printf("%8s %12s %20s %12s\n", 
            s[2], s[1], PRGString.isPrefix(s[2], s[1]), s[1].startsWith(s[2]));
        
        // a y b de igual longitud y a es prefijo de b                  
        /* COMPLETADO */
        System.out.printf("%8s %12s %20s %12s\n", 
            s[1], s[1], PRGString.isPrefix(s[1], s[1]), s[1].startsWith(s[1]));
        
        // a y b de igual longitud y a no es prefijo de b                  
        /* COMPLETADO */
        System.out.printf("%8s %12s %20s %12s\n", 
            s[3], s[4], PRGString.isPrefix(s[3], s[4]), s[4].startsWith(s[3]));
        
        // a de menor longitud que b y a es prefijo de b                  
        /* COMPLETADO */
        System.out.printf("%8s %12s %20s %12s\n", 
            s[1], s[3], PRGString.isPrefix(s[1], s[3]), s[3].startsWith(s[1]));
        
        // a de menor longitud que b y a no es prefijo de b:
        // por el primer caracter
        /* COMPLETADO */
        System.out.printf("%8s %12s %20s %12s\n", 
            s[2], s[3], PRGString.isPrefix(s[2], s[3]), s[3].startsWith(s[2]));
        
        // a de menor longitud que b y a no es prefijo de b:
        // por el ultimo caracter
        /* COMPLETADO */
        System.out.printf("%8s %12s %20s %12s\n", 
            s[3], s[6], PRGString.isPrefix(s[3], s[6]), s[6].startsWith(s[3]));
        
        // a de menor longitud que b y a no es prefijo de b:
        // por un caracter intermedio
        /* COMPLETADO */ 
        System.out.printf("%8s %12s %20s %12s\n", 
            s[4], s[6], PRGString.isPrefix(s[4], s[6]), s[6].startsWith(s[4]));
    }
      
    public static void testIsSubstring() {
        String[] s = {"", "rec", "pecur", 
                      "recurso", "remursi", 
                      "123456789", "recursion",
                      "sion", "curs"};
               
        System.out.printf("%8s %12s %20s %10s\n", 
                          "a", "b", "isSubstring(a,b)", "b.contains(a)"); 
        // a y b vacias
        /* COMPLETADO */
        System.out.printf("%8s %12s %20s %10s\n", 
                          s[0], s[0], PRGString.isSubstring(s[0],s[0]), s[0].contains(s[0])); 
        
        // solo a vacia                          
        /* COMPLETADO */
        System.out.printf("%8s %12s %20s %10s\n", 
                          s[0], s[1], PRGString.isSubstring(s[0],s[1]), s[1].contains(s[0])); 
        
        // solo b vacia                  
        /* COMPLETADO */
        System.out.printf("%8s %12s %20s %10s\n", 
                          s[1], s[0], PRGString.isSubstring(s[1],s[0]), s[0].contains(s[1])); 
        
        // a de mayor longitud que b                  
        /* COMPLETADO */
        System.out.printf("%8s %12s %20s %10s\n", 
                          s[2], s[1], PRGString.isSubstring(s[2],s[1]), s[1].contains(s[2])); 
        
        // a y b de igual longitud y a es subcadena de b                  
        /* COMPLETADO */
        System.out.printf("%8s %12s %20s %10s\n", 
                          s[1], s[1], PRGString.isSubstring(s[1],s[1]), s[1].contains(s[1])); 
        
        // a y b de igual longitud y a no es subcadena de b                  
        /* COMPLETADO */
        System.out.printf("%8s %12s %20s %10s\n", 
                          s[3], s[4], PRGString.isSubstring(s[3],s[4]), s[4].contains(s[3])); 
        
        // a de menor longitud que b y a es sucadena de b
        // porque a es prefijo de b
        /* COMPLETADO */
        System.out.printf("%8s %12s %20s %10s\n", 
                          s[1], s[3], PRGString.isSubstring(s[1],s[3]), s[3].contains(s[1])); 
        
        // a de menor longitud que b y a es sucadena de b
        // porque a es sufijo de b
        /* COMPLETADO */
        System.out.printf("%8s %12s %20s %10s\n", 
                          s[7], s[6], PRGString.isSubstring(s[7],s[6]), s[6].contains(s[7])); 
        
        // a de menor longitud que b y a es sucadena de b
        // porque a esta en b a partir de una posicion intermedia
        /* COMPLETADO */ 
        System.out.printf("%8s %12s %20s %10s\n", 
                          s[8], s[3], PRGString.isSubstring(s[8],s[3]), s[3].contains(s[8])); 
        
    }
     
    private static void compareIsPrefix(String a, String b) {
        System.out.printf("%12s %12s %12b %12b\n", a, b, 
                          PRGString.isPrefix(a, b),
                          b.startsWith(a));
    }
    
    private static void compareIsSubstring(String a, String b) {
        System.out.printf("%12s %12s %12b %12b\n", a, b, 
                          PRGString.isSubstring(a, b),
                          b.contains(a));
    }
   
}
