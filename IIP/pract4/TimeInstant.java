package pract4;
import java.util.*; 

/**
 * Clase TimeInstant. 
 *
 * Esta clase permite representar instantes o marcas de tiempo
 * (Timestamp) con detalle de horas y minutos. Así, la clase 
 * representa un instante de tiempo o momento del día, en este
 * caso, las horas y los minutos de un día cualquiera.
 *
 * @author IIP - ETSINF - UPV 
 * @version Curso 2023-24
 */
public class TimeInstant {      
    // ATRIBUTOS:
    /** 
     *  Variable entera para almacenar las horas. 
     *  Debe pertenecer al rango [0..23].
     */
    
    private int hours;
    
    /** 
     *  Variable entera para almacenar los minutos. 
     *  Debe pertenecer al rango [0..59]. 
     */
    
    private int minutes;
    
    // CONSTRUCTORES:
    /**
     *  Crea un TimeInstant con el valor de las horas y 
     *  los minutos que recibe como argumentos,iniHours
     *  y iniMinutes, respectivamente.
     *  Precondición: 0 <= iniHours < 24, 0 <= iniMinutes < 60.
     */
   
    public TimeInstant(int iniHours, int iniMinutes) {
        this.hours = iniHours;
        this.minutes = iniMinutes;
    }
    
    /**
     * Crea un TimeInstant con el valor del instante
     * actual UTC (tiempo universal coordinado).
     */
    
    public TimeInstant() {
        long tMinTotal = System.currentTimeMillis() / (60 * 1000);
    
        int tMinCurrent = (int) (tMinTotal % (24 * 60));
        // Devuelve los minutos actuales
    
        this.hours = tMinCurrent / 60;
        // Devuelve las horas actuales
    
        this.minutes = tMinCurrent % 60;
        // Devuelve los minutos actuales
    }
   
    // CONSULTORES Y MODIFICADORES:
    
    /** Devuelve las horas del TimeInstant. */ 
    public int getHours() {
        return hours;
    }
    
    /** Devuelve los minutos del TimeInstant. */
    public int getMinutes() {
        return minutes;
    }
    
    /** Actualiza las horas del TimeInstant. */ 
    public void setHours(int newHours) {
        this.hours = newHours;
    }
   
    /** Actualiza los minutos del TimeInstant. */ 
    public void setMinutes(int newMinutes){
        this.minutes = newMinutes;
    }
   
    // OTROS MÉTODOS:
    /** Devuelve el TimeInstant en el formato "hh:mm". */
   
    public String toString() {
        String hh = "0" + hours;
        hh = hh.substring(hh.length() - 2);
        
        String mm = "0" + minutes;
        mm = mm.substring(mm.length() - 2);        
        
        return hh + ":" + mm;
    }
    
    /** Devuelve true si o es un objeto de la clase
     *  TimeInstant y sus horas y minutos coinciden con
     *  los del objeto en curso this. 
     */
    
    public boolean equals(Object o) {
        return o instanceof TimeInstant
            && this.hours == ((TimeInstant) o).hours
            && this.minutes == ((TimeInstant) o).minutes;
    }
    
    /** Devuelve el número de minutos transcurridos desde las 00:00 
     *  hasta el instante representado por this.
     */
    
    public int toMinutes() {
        return this.hours * 60 + this.minutes;
    }
    
    /** Compara cronológicamente el instante del objeto en curso con 
     *  el del objeto de la clase TimeInstant referenciado por tInstant.
     *  El resultado es negativo si this es anterior a tInstant,
     *  cero si son iguales, y positivo si this es posterior a tInstant. 
     *  Se calcula como la resta entre la conversión a minutos
     *  de ambos objetos.
     */
    
    public int compareTo(TimeInstant tInstant) {
        return this.toMinutes() - tInstant.toMinutes();
    }
    
    // ACTIVIDAD EXTRA:
    /** Devuelve un TimeInstant a partir de la descripción 
     *  textual (String) en formato "hh:mm".
     */
    
    public static TimeInstant valueOf(String textInstant) {
        int hourTens = textInstant.charAt(0) - '0';
        int hourUnits = textInstant.charAt(1) - '0';
        int minuteTens = textInstant.charAt(3) - '0';
        int minuteUnits = textInstant.charAt(4) - '0';
        
        int hours = hourTens * 10 + hourUnits;
        int minutes = minuteTens * 10 + minuteUnits;
        
        return new TimeInstant(hours, minutes);
    }
}
