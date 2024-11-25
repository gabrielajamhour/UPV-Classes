package practica3;


/**
 * class Rectangle.
 * 
 * @author LTP
 * @version 2020-21
 */

public class Rectangle extends Figure implements ComparableRange<Figure>, Printable {
    private double base; 
    private double height;

    public Rectangle(double x, double y, double b, double h) {
        super(x, y);
        base = b;
        height = h;
    }

    public boolean equals(Object o) {
        if (!(o instanceof Rectangle)) { return false; }
        Rectangle r = (Rectangle) o;      // Convierte el objeto genérico Object al tipo específico, en este caso Rectangle
        return super.equals(r) && this.base == r.base && this.height == r.height;
    }
    
    public String toString() {
        return "Rectangle:\n\t" +
            super.toString() +
            "\n\tBase: " + base +
            "\n\tHeight: " + height;
    }
    
    public double area() {
        return base * height;
    }
    
    public double perimeter() {
        return 2 * (base + height);
    }
    
    public int compareToRange(Figure o) {
        // Considera iguales dos figuras si la diferencia de sus áreas en valor absoluto es menor o igual al 10% de la suma de sus áreas
           
        if (o instanceof Rectangle) { 
            Rectangle r = (Rectangle) o;
        }
        
        double thisArea = this.area();
        double otherArea = o.area();
        
        double dif = Math.abs(thisArea - otherArea);
        double sum = thisArea + otherArea;
        
        if (dif <= (0.1*sum)) { return 0; } // Se consideran iguales
        else {
            return Double.compare(thisArea, otherArea);
        }
    }
    
    public void print(char c) {
        int b = (int) base;
        int h = (int) height;
        for (int i = 0; i < h; i++) {
            for (int j = 0; j < b; j++) {
                System.out.print(c);
            }
            System.out.println();
        }  
    }
}
