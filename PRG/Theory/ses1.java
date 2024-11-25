/**
 * Ejercicios en clase
 * Sesión 1 (12 Febrero)
 * 
 * @gabrielajamhour 
 * @12-02-2024
 */
public class Sesion1 {
    /**
     * Problema 1. Producto
     * 
     * Dados dos números enteros a y b, siendo b >= 0, se puede definir recursivamente su producto a * b de manera
     * similar al ejemplo de la potencia a^n del vídeo didáctico, es decir, en este caso la multiplicación se reduciría 
     * a una secuencia de sumas.
     * 
     * Considerando que solo puedes usar operaciones aditivas (prohibido usar el * para multiplicar), escribe un 
     * método de clase recursivo (static) que calcule la operación indicada.
     */
    public static int producto(int a, int b) {
        if(b == 0) { return 0; }                      // Caso Base
        else {                                        // Caso General      
            return a + producto(a, b-1);              // Llamada recursiva
            // El producto de a * b es igual a la suma de "a" b veces
        }    
    }

    /**
     * Problema 2. Cociente de la División Entera
     * 
     * Escribir un método de clase recursivo (estático) que, dados dos números naturales a>= 0 y b>= 0, calcule el
     * cociente de su división entera, basándose en el hecho de que dicha operación se puede realizar como una serie
     * de restas sucesivas (de forma similar al problema del cálculo del resto de la división entera del viídeo didáctico)
     */
    public static int cociente(int a, int b) {
        if (a < b) { return 0; }                      // Caso Base
        else {                                        // Caso General
            return 1 + cociente(a-b, b);              // Llamada recursiva
            // El cociente c de a / b es igual a subtrair "b" de "a" c veces
        }
    }
    
    /**
     * Problema 3. Multiplicación a la Rusa
     * 
     * Dados dos números enteros a y b, siendo b >= 0, otra forma de definir recursivamente su producto a * b es la
     * siguiente:
     * 
     * a * b = 0, si b = 0,
     * a * b = (2a) * (b/2), si b > 0 y b es par, y
     * a * b = (2a) * (b/2) + a, si b > 0 y b es impar.
     * 
     * Este tipo de multiplicación se conoce como multiplicación a la rusa, siendo utilizada antiguamente por los
     * comerciantes de dicho país, que no conocían la tabla de multiplicar, para efectuar el producto de dos números
     * positivos cualesquiera utilizando solamente sumas, producto por 2 y divisiones por 2.
     * 
     * Considerando que tan sólo se pueden utilizar productos y divisiones por 2, así como sumas, escribir un método
     * de clase recursivo para realizar la operación pedida, siguiendo la definición anterior
     */
    public static int multiplicacionALaRusa(int a, int b) {
        if (b == 0) { return 0; }                     // Caso Base
        else {                                        // Caso General
            if (b % 2 == 0) { return multiplicacionALaRusa(2*a, b/2); }   // b es par
            else { return multiplicacionALaRusa(2*a, b/2) + a; }          // b es impar
        }
    }
    
    /**
     * Problema 4. Potencia "a la Rusa"
     * 
     * Dados dos números enteros a != 0 y b >= 0, se puede definir recursivamente la potencia a^b del modo siguiente:
     * 
     * a^b = 1, si b = 0,
     * a^b = a, si b = 1,
     * a^b = (a^(b/2)) * (a^(b/2)), si b > 1 y b es par, y
     * a^b = (a^(b/2)) * (a^(b/2)) * a, si b > 1 y b es impar.
     * 
     * Considerando que tan sólo se pueden utilizar divisiones por 2 y productos, escribir un método de clase recursivo
     * para realizar la operación pedida, siguiendo la definición anterior.
     */
    public static int potenciaALaRusa(int a, int b) {
        if (b <= 1) {                                 // Caso Base  
            if (b == 0) { return 1; }
            else {return a; }     // b == 1
        }
        else {                                        // Caso General    
            if (b % 2 == 0) { return potenciaALaRusa(a, b/2) * potenciaALaRusa(a, b/2); }
            else { return potenciaALaRusa(a, b/2) * potenciaALaRusa(a, b/2) * a; }
        }
    }
    
    /**
     * Problema 5. Número de Dígitos
     * 
     * El siguiente método es una implementación iterativa que calcula el número de cifras de un número entero dado
     * >= 0. Por ejemplo, para el número 2347 el método devuelve 4, para el número 8 devuelve 1, para el número 0
     * también devuelve 1.
     * 
     * /** Calcula el número de cifras de n, n >=0.
     *  * public static int digits(int n) {
     *  *    if (n == 0) { return 1; }
     *  *    int count = 0;
     *  *    while (n > 0) {
     *  *        n = n / 10;
     *  *        count++;
     *  *    }
     *  *    return count;
     *  * }
     *  
     * Escribir un método de clase que haga lo mismo pero recursivamente, es decir, tiene que devolver el número
     * de dígitos de un número natural n >= 0 pasado como parámetro.
     */
    public static int numDigitos(int n) {
        if (n < 10) { return 1; }                     // Caso Base            
        else { return numDigitos(n/10) + 1;}          // Caso General               
    }
    
    /**
     * Problema 6. Suma de Dígitos
     * 
     * Escribir un método de clase recursivo que devuelva la suma de los dígitos de un número natural n>= 0 pasado
     * como parámetro.
     */
    public static int sumaDigitos(int n) {
        if (n < 10) { return n; }                     // Caso Base 
        else { return sumaDigitos(n/10) + (n%10); }   // Caso General
    }
    
    /**
     * Problema 7. Inverso de un número natural
     * 
     * Dado un entero n >= 0, se desea calcular el invertido de n, es decir, otro entero que contenga las mismas cifras
     * que n pero en orden inverso.
     * 
     * El siguiente método es una implementación iterativa que, usando el método del Problema 5, calcula el invertido
     * de un número entero dado >= 0. Por ejemplo, para el 2347 calcula el 7432.
     * 
     * /** Calcula el invertido de n, n >=0.
     *  * public static int reversed(int n) {
     *  *     int i = digits(n) - 1;
     *  *     int add = 0;
     *  *     while (i >= 0) {
     *  *         add = add + (n % 10) * (int) (Math.pow(10, i));
     *  *         n = n / 10;
     *  *         i--;
     *  *     }
     *  *     return add;
     *  * }
     * 
     * Escribir un método de clase que haga lo mismo pero recursivamente.
     */
    public static int inversoNatural(int n) {
        if (n < 10) { return n;}                      // Caso Base  
        else {                                        // Caso General 
            int i = numDigitos(n) - 1;
            int parcial = n % 10 * (int) Math.pow(10, i);
            int z = inversoNatural(n/10);
            return parcial + z;
        }
    }
    
    /**
     * Problema 8. De decimal a binario (dec2bin)
     * 
     * Escribir un método de clase recursivo que devuelva el valor binario (representado como un entero) de un
     * número natural n >= 0 dado. Por ejemplo, si n = 5 el método devuelve 101, pero si n = 31 el método
     * devuelve 11111.
     */
    public static int dec2bin(int n) {
        if (n <= 1) { return n; }                     // Caso Base  
        else { return dec2bin(n/2) * 10 + (n % 2); }  // Caso General
    }
}
