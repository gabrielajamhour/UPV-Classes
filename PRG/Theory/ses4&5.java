/**
 * Ejercicios en clase
 * Sesión 4 (22 Febrero) y Sesión 5 (26 Febrero)
 * 
 * @gabrielajamhour 
 * @22-02-2024 & @26-02-2024
 */
public class Sesion4y5 {
    /**
     * Problema 1
     * 
     * Sea a un array de double cuyas componentes representan valores de la coordenada Y de una enumeración de
     * puntos pertencientes a una recta de pendiente positiva, de manera que el array está ordenado
     * ascendentemente. Se debe escribir un método recursivo que busque el punto de corte de la recta con el eje X, o
     * que devuelva -1 si el punto de corte no se encuentra entre los puntos de a. Por ejemplo: si el array es {-7.4,
     *  -1.3, 0.0, 1.8, 2.3, 3.6} el método debe devolver 2. Si el array es {-7.4, -1.3, 0.0, 1.8, 2.3, 3.6} el
     *  método debe devolver -1.
     *  
     *  Se pide:
     *  1. Perfil del método, con los parámetros adecuados para resolver recursivamente el problema, y precondición
     *  relativa a dichos parámetros.
     *  2. Caso base y caso general.
     *  3. Implementación en Java.
     *  4. Llamada inicial para que, dado un cierto array, se realice el cálculo sobre todo el array completo.
     */
    
    // Ascendente Simplificado
    // a está ordenado ascendentemente
    // 0 <= pos <= a.length
    public static int puntoCorte(double[] a, int pos) {
        if (pos == a.length) { return -1; }       // Caso Base 
        else {                                    // Caso General  
            if (a[pos] == 0) { return pos; }      // Condición Búsqueda1
            else if (a[pos] > 0) { return -1; }   // Condición Búsqueda 2
            // Como está ordenado ascendentemente, si el número es mayor que 0, los restantes no serán 0
            else { return puntoCorte(a, pos+1); } 
        }
    }
    
    /**
     * Problema 2
     * 
     * Implementa un método Java que determine si cierto array de números enteros recibido como parámetro
     * representa o no un palíndromo. NOTA: Un array se considera palíndromo si el listado de su contenido es el
     * mismo de izquierda a derecha que de derecha a izquierda.
     * 
     * Se pide:
     * 1. Perfil de método.
     * 2. Indicar caso base y caso general del diseño recursivo.
     * 3. Implementación en Java.
     * 4. Llamada inicial para poder resolver el problema sobre toda la clase.
     */
    
    // 0 <= inicio
    // fin <= a.length - 1
    public static boolean palindromo(int[] a, int inicio, int fin) {
        if (inicio >= fin) { return true; }
        else {
            if(a[inicio] != a[fin]) { return false; }
            else { return palindromo(a, inicio + 1, fin - 1); }
        }
    }
    
    /**
     * Problema 3
     * 
     * Un bitarray es un array de números enteros cuyas posiciones contienen exclusivamente un 0 o un 1. Dado un
     * bitarray que contiene la representación en formato binario de un cierto número pero en orden inverso, escribe
     * un método de clase recursivo que, añadiendo los parámetros posicionales que consideres oportuno, permita
     * transformar dicha representación a formato decimal. Por ejemplo, el array a = {1, 0, 1, 1}, leído de forma
     * inversa es el 1101 en binario, y el número 13 en decimal.
     * 
     * Se pide:
     * 1. Perfil del método.
     * 2. Indicar caso base y caso general del diseño recursivo.
     * 3. Implementación en Java.
     * 4. Llamada inicial al método para obtener la conversión de binario a decimal del array completo.
     */

    // 0 <= pos <= a.length
    public static int bitarray(int[] a, int pos) {
        if (pos == a.length) { return 0; }
        else {
            int num = a[pos] * (int) Math.pow(2, pos);
            // Se lee los números de derecha a izquierda
            return num + bitarray(a, pos+1);
        }
    }
}
