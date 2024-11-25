package practica3;


/**
 * class Figure.
 * 
 * @author LTP 
 * @version 2020-21
 */

public abstract class Figure implements Comparable<Figure> {
    private double x;
    private double y;
    
    public Figure(double x, double y) {
        this.x = x; 
        this.y = y; 
    }
    
    public boolean equals(Object o) {
        if (!(o instanceof Figure)) { return false; }
        Figure f = (Figure) o;
        return x == f.x && y == f.y;
    }
    
    public String toString() {
        return "Position: (" + x + ", " + y + ")"; 
    }
    
    public abstract double area();
    // Método abstractos: métodos sin cuerpo (sin implementación). Las clases hijas *deben* implementar estos métodos
    
    public abstract double perimeter();
    
    public int compareTo(Figure other) {
        return Double.compare(this.area(), other.area());
    }
}