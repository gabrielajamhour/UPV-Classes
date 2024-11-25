/**
 * Ejercicios en clase
 * Sesión 1 (15 Febrero)
 * 
 * @gabrielajamhour 
 * @15-02-2024
 */
public class Sesion2 {
    /**
     * Problema 1. Mostrar números en orden decreciente
     * 
     * Escribir un método de clase recursivo que muestre en pantalla los números naturales del n al 1, donde n > 0 es
     * el valor pasado como parámetro en la llamada inicial.
     */
    public static void ordenDecreciente(int n) {
        System.out.println(n);
        if (n > 1) {
            ordenDecreciente(n-1);
        }
    }
    
    /**
     * Problema 2. Mostrar números en orden creciente
     * 
     * Escribir un método de clase recursivo que muestre en pantalla los números naturales del 1 al n, donde n > 0 es
     * el valor pasado como parámetro en la llamada inicial.
     */
    public static void ordenCreciente(int n) {
        if (n > 1) {
            ordenCreciente(n-1);
            System.out.println(n);
        }
        else { System.out.println(n); }
    }
    
    /**
     * Problema 3. Traza Recursiva
     * 
     * Escribir qué muestra por pantalla al ejecutar este programa:
     * 
     * public class Raro {
     *     /** n >= 0.
     *     public static void escribeRaro(int n) {
     *         if (n > 0) {
     *             System.out.print(n);
     *             escribeRaro(n-1);
     *             System.out.print(n)
     *         }
     *         else { System.out.print(0); }
     *     }
     *     public static void main(String[] args) { escribeRaro(5); }
     * }
     * 
     * 
     * Respuesta: 54321012345
     */
    
    /**
     * Problema 4. Mostrar dígitos en orden inverso
     * 
     * Escribir un método de clase recursivo que muestre en orden inverso los dígitos que componen un número
     * natural n >= 0 dado.
     */
    public static void digitosOrdenInverso(int n) {
        if (n < 10) { System.out.println(n); }
        else{
            System.out.println(n % 10);
            digitosOrdenInverso(n / 10);
        }
    }
}
