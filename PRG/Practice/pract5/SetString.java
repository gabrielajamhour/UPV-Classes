package pract5;
import java.util.Scanner;
/**
 * Clase SetString. Implementacion de un
 * conjunto de String mediante una secuencia
 * enlazada ordenada lexicograficamente.
 *
 * @author (PRG. ETSINF. UPV)
 * @version (Curso 2023/24)
 */
public class SetString {
    
    // ATRIBUTOS
    private NodeString first; // Acceso al primer elemento de la secuencia enlazada
    private int size;         // Número de elementos en el conjunto 
    
    /**
     * Crea un conjunto vacio.
     */
    public SetString() {
        first = null;
    }

    /**
     * Inserta s en el conjunto.
     * Si s ya pertenece al conjunto, el conjunto no cambia.
     * @param s String. Elemento que se inserta en el conjunto.
     */
    public void add(String s) {
        // COMPLETADO
        
        NodeString aux = this.first; // Nodo a revisar, inicialmente el primero
        NodeString ant = null;       // Anterior al nodo aux, inicialmente null
        
        int compare = -1;
        
        while (aux != null && compare < 0) {            
            compare = aux.data.compareTo(s);
            
            if (compare < 0) {
                ant = aux;
                aux = aux.next;
            }
        }
        
        if(compare != 0) {
            if (ant == null) {
                first = new NodeString(s, first); //  Inserción por cabecera
            }
            else {
                ant.next = new NodeString(s, ant.next); // Inserción en cualquier posición
            }
            size++;
        }
    }
    
    /**
     * Comprueba si s pertenece al conjunto.
     * @param s String.
     * @return true sii s pertenece al conjunto.
     */
    public boolean contains(String s) {
        // COMPLETADO
        
        NodeString aux = this.first; // Nodo a revisar, inicialmente el primero
        
        int compare = -1;
        
        while (aux != null && compare < 0) {           
            compare = aux.data.compareTo(s);
            if (compare < 0) { aux = aux.next; }
        }
        
        // {1,2,3}        
        return compare == 0;
    }

    /**
     * Elimina s del conjunto.
     * Si s no pertenece al conjunto, el conjunto no cambia.
     * @param s String.
     */
    public void remove(String s) {
        // COMPLETADO
        
        NodeString aux = this.first; // Nodo a revisar, inicialmente el primero
        NodeString ant = null;       // Anterior al nodo aux, inicialmente null
        
        int compare = -1;
        
        while (aux != null && compare < 0) {            
            compare = aux.data.compareTo(s);
            
            if (compare < 0) {
                ant = aux;
                aux = aux.next;
            }
        }
        
        if(compare == 0) {
            if (ant == null) { first = first.next; }
            else { ant.next = aux.next; }
            size--;
        }
    }
    
    /**
     * Devuelve la talla o cardinal del conjunto.
     * @return la talla del conjunto.
     */
    public int size() { 
        // COMPLETADO
        return size;
    }    
    
    /**
     * Devuelve el conjunto interseccion del conjunto y del otro conjunto.
     * @param other SetString.
     * @return el conjunto interseccion.
     */
    public SetString intersection(SetString other) {
        // COMPLETADO
        
        NodeString aux1 = this.first;
        NodeString aux2 = other.first;
        
        SetString result = new SetString();
        
        NodeString lastResult = null;
        
        while (aux1 != null && aux2 != null) {
            String s1 = aux1.data;
            String s2 = aux2.data;
            
            int compare = s1.compareTo(s2);
            
            if (compare == 0) {
                NodeString newNode = new NodeString(s1, null);
                
                if (lastResult == null) { 
                    result.first = newNode;
                }
                else { 
                    lastResult.next = newNode;
                }
                
                lastResult = newNode;

                aux1 = aux1.next;
                aux2 = aux2.next;
                
                result.size++;
            }
            else {
                if (compare < 0) { aux1 = aux1.next; }
                else { aux2 = aux2.next; }
            }
        }
        
        return result;
    }
    
    /**
     * Devuelve el conjunto union del conjunto y del otro conjunto.
     * @param other SetString.
     * @return el conjunto union.
     */
    public SetString union(SetString other) {
        // COMPLETADO
        
        NodeString aux1 = this.first;
        NodeString aux2 = other.first;
        
        SetString result = new SetString();
        
        NodeString lastResult = null;
        
        while (aux1 != null || aux2 != null) {
            NodeString newNode;
            
            if (aux1 == null) { // Solo aux2 tiene elementos
                newNode = new NodeString(aux2.data, null);
                aux2 = aux2.next;
            }
            else if (aux2 == null) { // Solo aux1 tiene elementos
                newNode = new NodeString(aux1.data, null);
                aux1 = aux1.next;
            }
            else {  // Los dos tienen elementos
                int compare = aux1.data.compareTo(aux2.data);
                
                if (compare > 0) {
                    newNode = new NodeString(aux2.data, null);
                    aux2 = aux2.next;
                }
                else {
                    newNode = new NodeString(aux1.data, null);
                    aux1 = aux1.next;
                    if (compare == 0) { aux2 = aux2.next; }
                }
            }
            
            if (lastResult == null) { result.first = newNode; }
            else { lastResult.next = newNode; }
                
            lastResult = newNode;
                
            result.size++;
        }
            
        return result;
    }   
    
    /**
     * Devuelve el listado de los Strings en el conjunto, en orden
     * lexicografico, y separados por saltos de linea.
     * Si el conjunto es vacio devuelve "", la String vacia.
     * @return el listado de los elementos del conjunto.
     */
    public String toString() {
        String result = "";
        NodeString aux = this.first;
        while (aux != null) {
            result += aux.data + "\n"; 
            aux = aux.next; 
        }
        return result;
    }
  
    /**
     * Devuelve el SetString de las palabras leidas de s 
     * segun los separadores con que se haya configurado el
     * Scanner. 
     * @param s Scanner
     * @return el conjunto de palabras leidas de s.
     */
    public static SetString setReading(Scanner s) {            
        SetString setS = new SetString();
        while (s.hasNext()) {
            String word = s.next();
            setS.add(word);    
        }
        return setS;
    }
    
}
