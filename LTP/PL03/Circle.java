package practica3;


/**
 * class Circle.
 * 
 * @author LTP 
 * @version 2020-21
 */

public class Circle extends Figure implements Printable { // La palabra reservada 'extends' se utiliza para indicar que Circle hereda de la clase Figura
    private double radius;

    public Circle(double x, double y, double r) {
        super(x, y); // La palabra reservada 'super' se utiliza para referirse a elementos de la clase padre (Figure)
        radius = r;
    }

    public boolean equals(Object o) {
        if (!(o instanceof Circle)) { return false; } // instanceof permite verificar si un objecto es instancia de una determinada clase, en este caso Circle
        Circle c = (Circle) o;      // Convierte el objeto genérico Object al tipo específico (casting o coerción explícita), en este caso Circle 
        return super.equals(c) && this.radius == c.radius;
    }
    
    public double area() {
        return Math.PI * radius * radius;
    }
    
    public double perimeter() {
        return 2 * Math.PI * radius;
    }
    
    public void print(char c) {
        int n = (int)radius;
        for (int j = 0; j <= n * 2; j++) {
            for (int i = 0; i <= n * 2; i++) {
                if (Math.pow(i - n, 2.0) + Math.pow(j - n, 2.0)
                <= (int)Math.pow(n, 2)) {
                System.out.print(c);
            }
            else {
                System.out.print(" ");
            }
        }
        System.out.println();
        }    
    }
}
