/**
 * Ejercicios en clase
 * Sesión 1 (19 Febrero)
 * 
 * @gabrielajamhour 
 * @19-02-2024
 */
public class Sesion3 {
    /**
     * Problema
     * 
     * Dados un array v de String y un número natural n, escribe un método recursivo que devuelva cuántos
     * elementos del array v tienen una longitud n.
     * 
     * Por ejemplo, si el array v contuviera {"barco", "autobus", "tren", "moto", "bici"}, y n fuera 4, entonces el m[etodo
     * devolvería 3. Si el array fuera el mismo, y n fuera 5, entonces el método devolvería 1. Para el mismo array v, y
     * n igual a 3, el método devolvería 0.
     * 
     * Se pide:
     * 1. Perfil del método, con los parámetros adecuados para resolver recursivamente el problema, y
     * precondición relativa a dichos parámetros.
     * 2. Caso base y caso general.
     * 3. Implementación en Java.
     * 4. Llamada inicial para que se realice el cálculo sobre todo el array.
     * 
     * Para practicar lo estudiado, vamo sa resolverlo de distintos modos: ascendente/descendente y simplificado/no
     * simplificado
     */
    
    // Ascendente No Simplificado
    // n > 0
    // 0 <= inicio <= v.length
    // fin = v.length - 1
    public static int contarPalabrasANS(String[] v, int n, int inicio, int fin) {
        if (inicio > fin) { return 0; }
        else {
            if (v[inicio].length() == n) {
                return 1 + contarPalabrasANS(v, n, inicio+1, fin);
            }
            else {
                return contarPalabrasANS(v, n, inicio+1, fin);
            }
        }
    }
    
    // Descendiente No Simplificado
    // n > 0
    // inicio = 0
    // -1 <= fin <= v.length - 1
    public static int contarPalabrasDNS(String[] v, int n, int inicio, int fin) {
        if (inicio > fin) { return 0; }
        else {
            if (v[fin].length() == n) {
                return 1 + contarPalabrasDNS(v, n, inicio, fin-1);
            }
            else {
                return contarPalabrasDNS(v, n, inicio, fin-1);
            }
        }
    }
    
    // Ascendente Simplificado
    // n > 0
    // 0 <= pos <= v.length (inicio)
    public static int contarPalabrasAS(String[] v, int n, int pos) {
        if (pos == v.length) { return 0; }
        else {
            if (v[pos].length() == n) {
                return 1 + contarPalabrasAS(v, n, pos+1);
            }
            else {
                return contarPalabrasAS(v, n, pos+1);
            }
        }
    }
    
    // Descendente Simplificado
    // n > 0
    // -1 <= pos <= v.length
    public static int contarPalabrasDS(String[] v, int n, int pos) {
        if (pos == -1) { return 0; }
        else {
            if (v[pos].length() == n) {
                return 1 + contarPalabrasDS(v, n, pos-1);
            }
            else {
                return contarPalabrasDS(v, n, pos-1);
            }
        }
    }
}
