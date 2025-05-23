package practica3;
import java.util.*;

/**
 * class FiguresGroup.
 * 
 * @author LTP 
 * @version 2020-21
 */

public class FiguresGroup implements Printable {
    private static final int NUM_FIGURES = 10;
    private Figure[] figuresList = new Figure[NUM_FIGURES];
    private int numF = 0;

    public void add(Figure f) { figuresList[numF++] = f; }

    public String toString() {
        String s = "";
        for (int i = 0; i < numF; i++) {
            s += "\n" + figuresList[i];
        }
        return s;
    }

    private boolean found(Figure f) {            // Verifica si la figura recibida como argumento se encuentra o no en el grupo de figuras que invoca el método
        for (int i = 0; i < numF; i++) {
            if (figuresList[i].equals(f)) return true;
        }
        return false;
    }

    private boolean included(FiguresGroup g) {   // Verifica si el grupo g recibido como argumento está incluido o no en el grupo de figuras que invoca al método
        for (int i = 0; i < g.numF; i++) {
            if (!found(g.figuresList[i])) return false;
        }
        return true;
    }

    public boolean equals(Object o) {
        if (!(o instanceof FiguresGroup)) { return false; }
        FiguresGroup fg = (FiguresGroup) o;
        return this.included(fg) && fg.included(this);   // Verifica si fg está incluido en this y viceversa
    }
    
    public void print(FiguresGroup g) {
        System.out.println(g);
    }
    
    private double area() {
        double sum = 0;
        for (int i = 0; i < numF; i++) {
            sum += figuresList[i].area();
        }
        return sum;
    }
    
    private Figure greatestFigure() {
        double biggestArea = 0;
        Figure greatestFigure = null;
        for (int i = 0; i < numF; i++) {
            double currentArea = figuresList[i].area();
            if (currentArea > biggestArea) {
                biggestArea = currentArea;
                greatestFigure = figuresList[i];
            }
        }
        return greatestFigure;
    }

    public List<Figure> orderedList() {
        List<Figure> figuresArray = new ArrayList<>();
        figuresArray.add(figuresList[0]);
        
        for (int i = 1; i < numF; i++) {
            Figure fList = figuresList[i];
            int pos = figuresArray.size() - 1;
            
            while (pos >= 0) {
                Figure fArray = figuresArray.get(pos); // Obtiene la figura de la lista
                                
                if (fList.compareTo(fArray) < 0) {
                    figuresArray.add(pos+1, fList);
                    break;
                }
                pos--;
            }
            
            if (pos == -1) {
                figuresArray.add(0, fList);
            }
        }
        
        return figuresArray;
    }
    
    public void print(char c) {
        for (int i = 0; i < numF; i++) {
            if (figuresList[i] instanceof Printable) {
                ((Printable) figuresList[i]).print(c);
            }
        }
    }  
}
