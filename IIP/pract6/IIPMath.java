package pract6;


/**
 * Escreva uma descrição da classe IIPMath aqui.
 * 
 * @author (seu nome) 
 * @version (um número da versão ou uma data)
 */
public class IIPMath {
    
    /** Devuelve el seno del ángulo x, con un error máximo epsilon.
     * Precondición: x en radianes, 0 < epsilon.
     */
    public static double sin(double x, double epsilon) {
        x = reducFirstCirc(x);
        double term = x;
        double suma = term;
        
        int k = 1;
        
        while (term > epsilon) {
            term = term * -1 * ((x * x) / (2 * k * (2 * k + 1)));
            
            suma = suma + term;
            
            k++;
        }
    
        return suma;
    } 
    
    /** Devuelve el seno del ángulo x con un error máximo 1e-15.
     * Precondición: x en radianes.
     */
    public static double sin(double x) { return sin(x, 1e-15); }
    
    /** Devuelve la reducción del ángulo x a la primera circunferencia.
    * Precondición: x en radianes.
    */
    public static double reducFirstCirc(double x) {
        double resto = x % (2 * Math.PI);

        return resto;
    }
}
