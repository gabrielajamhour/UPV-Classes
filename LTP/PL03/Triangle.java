package practica3;


/**
 * class Triangle.
 * 
 * @author LTP
 * @version 2020-21
 */

public class Triangle extends Figure {
    private double base; 
    private double height;

    public Triangle(double x, double y, double b, double h) {
        super(x, y);
        base = b;
        height = h;
    }

    public boolean equals(Object o) {
        if (!(o instanceof Triangle)) { return false; }
        Triangle t = (Triangle) o;      // Convierte el objeto genérico Object al tipo específico, en este caso Triangle
        return super.equals(o) && this.base == t.base && this.height == t.height;
    }
    
    public String toString() {
        return "Triangle:\n\t" +
            super.toString() +
            "\n\tBase: " + base +
            "\n\tHeight: " + height;
    }
    
    public double area() {
        return base * height / 2;
    }
    
    public double perimeter() {
        return -1;
    }
}
