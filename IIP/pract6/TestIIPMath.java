package pract6;
import java.util.Locale;
import graph2D.Graph2D; // Importa la clase Graph2D (del paquete graph2D)
import java.awt.Color; // Si se desea cambiar el color de los elementos a dibujar

/**
 * Escreva uma descrição da classe TestIIPMath aqui.
 * 
 * @author (seu nome) 
 * @version (um número da versão ou uma data)
 */
public class TestIIPMath {
    /** Escribe en la salida estándar, línea a línea, los valores de
     * Math.sin(x) e IIPMath.sin(x), para x desde 0 a 20 radianes.
     * Muestra la diferencia en valor absoluto entre estos valores.
     */ 
    public static void table() {
        double x = 0;
        
        while (x <= 20) {
            double yMath = Math.sin(x);
            double y = IIPMath.sin(x);
            
            double dif = yMath - y;
            
            System.out.printf(Locale.US,"%4.1f %23.15f %23.15f %23.15f\n", x, yMath, y, Math.abs(dif));
            
            x++;
        }
    }
    
        /** Obtiene el gráfico de la función IIPMath.sin(x) en el intervalo [-20, 20]. */
    public static void graph() {
        // Definir intervalo de valores para x y para y
        double xMin = -20;
        double xMax = 20;
        double yMin = -2;
        double yMax = 2;
        
        // Crear el espacio de dibujo con las dimensiones deseadas
        Graph2D gd = new Graph2D(xMin, xMax, yMin, yMax, 800, 250);
        gd.setTitle("IIPMath");
        
        // Calcular el incremento en cada paso de x (delta)
        double delta = (xMax - xMin) / Graph2D.INI_WIDTH;
        
        // Recorrer cada punto en x, calcular f(x) y dibujar (x, f(x))
        for (double x = xMin; x <= xMax; x = x + delta) {
            double y = IIPMath.sin(x);
            gd.drawPoint(x, y, Color.BLUE, 2); // representar el punto (x, y)
            // en color azul y grosor 2
        }
    }
}
