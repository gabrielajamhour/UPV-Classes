package exam1;

/**
 * Clase TimeInstant: permite representar instantes o marcas de tiempo
 * (Timestamp) con detalle de horas y minutos. Asi, esta clase representa 
 * el momento que define un instante de tiempo, en este caso, las horas y 
 * los minutos de un dia cualquiera.
 * 
 *  @author IIP 
 *  @version Curso 2023-24
 */
public class TimeInstant {
    /** 
     *  Variable entera para almacenar el atributo horas. 
     *  Debe pertenecer al rango [0..23].
     */
    private int hours;
    /** 
     *  Variable entera para almacenar el atributo minutos. 
     *  Debe pertenecer al rango [0..59]. 
     */
    private int minutes;
    
    /**
     *  Crea un TimeInstant con el valor de las horas y 
     *  los minutos que recibe como argumentos, iniHours y 
     *  iniMinutes, respectivamente.
     *  Precondicion: 0 <= iniHours < 24, 0 <= iniMinutes < 60.
     */
    public TimeInstant(int iniHours, int iniMinutes) {
        hours = iniHours;
        minutes = iniMinutes;
    }
    
    /** Devuelve el número de minutos transcurridos desde las 00:00 
     *  hasta el instante representado por el objeto en curso.
     */
    public int toMinutes() {
        return hours * 60 + minutes;
    }
   
    /** Devuelve el TimeInstant this en el formato "hh:mm". */
    public String toString() {
        String hh = "0" + hours;
        hh = hh.substring(hh.length() - 2);
        String mm = "0" + minutes;
        mm = mm.substring(mm.length() - 2);
        return hh + ":" + mm;
    }
   
    /** Actualiza las horas y los minutos del TimeInstant this 
     *  dividiendolos entre 2. Para dividir entre 2, el TimeInstant 
     *  this se pasa a minutos y estos se dividen entre 2. A partir 
     *  de dichos minutos, se obtienen las horas y los minutos equivalentes
     *  con los que actualizar las horas y los minutos de this. 
     *  Por ejemplo, las 13:10, dividiendo entre 2 las horas y los 
     *  minutos, quedarian las 06:35 (las 13:10 equivalen a 790 minutos;
     *  al dividir entre 2 son 395 minutos, que se corresponden con
     *  6 horas y 35 minutos).
     */
    public void divideBy2() {
        int hourMin = this.toMinutes();
        int dividedby2 = hourMin / 2;
        
        this.hours = hourMin / 60;
        this.minutes = hourMin % 60;
    }
}
