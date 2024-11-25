package exam2;

/**
 * Clase IIPMath: clase de utilidades que implementa
 * algunas operaciones matematicas.
 * 
 * @author Parcial 2 - Ejercicio 1 
 * @version IIP - Curso 2023/24
 */
public class IIPMath {
    /** No se pueden crear objetos de este tipo. */
    private IIPMath() { }
    
    /** Devuelve el numero de terminos que se deben 
     *  calcular de la serie siguiente:
     *     a_1 = Raiz cuadrada de 2 
     *     a_i = Raiz cuadrada de (2 * a_(i-1)), i > 1
     *  hasta obtener uno cuyo valor sea mayor o 
     *  igual que 2 - epsilon.
     *  PRECONDICION: 0 < epsilon
     */     
    public static int numberOfTerms(double epsilon) {
        double term = Math.sqrt(2);  // ultimo termino calculado
        int noTerms = 1;             // numero de terminos calculados
        
        /* COMPLETAR con un bucle */
                
        while( term < (2 - epsilon) ) {
            term = Math.sqrt(2 * term);
            noTerms++;            
        }
        
        return noTerms;  
    }
}
