package practica3;


/**
 * interface ComparableRange<T>
 * 
 * @author Gabriela Rego Jamhour
 * @version 2024-25
 */

public interface ComparableRange<T> extends Comparable<T>
{
    int compareToRange(T o);
}
