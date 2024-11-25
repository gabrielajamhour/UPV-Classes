package pract7;

import pract5.DateTime;
/**
 * Clase Event: clase tipo de datos que representa un evento con un título, 
 * de un tipo determinado y con una fecha de inicio y una fecha de fin.
 *
 * @author IIP - Práctica 7
 * @version Curso 2023/24
 */
public class Event {
    public static final int CONGRESS = 1, SHOW = 2, EXHIBITION = 3;    
    private DateTime startTime, endTime;
    private String title;
    private int type;
    
    /** Crea un Event dadas las fechas de inicio y de fin, el título y el tipo.
     *  @param start DateTime, la fecha de inicio, anterior a la fecha de fin.
     *  @param end DateTime, la fecha de fin, posterior a la fecha de inicio.
     *  @param tit String, el título.
     *  @param type int, el tipo, 1 <= type <= 3.
     */
    public Event(DateTime start, DateTime end, String tit, int type) {
        startTime = start;
        endTime = end;
        title = tit;
        this.type = type;
    }
    
    /** Devuelve la fecha de inicio.
     *  @return DateTime, la fecha de inicio.
     */
    public DateTime getStartTime() { return startTime; }
    
    /** Devuelve la fecha de fin.
     *  @return DateTime, la fecha de fin.
     */
    public DateTime getEndTime() { return endTime; }
    
    /** Devuelve el tipo.
     *  @return int, el tipo.
     */
    public int getType() { return type; }
        
    /** Devuelve el título.
     *  @return String, el título.
     */
    public String getTitle() { return title; }  
    
    /** Cambia la fecha de inicio por otra fecha dada.
     *  @param d DateTime, la nueva fecha de inicio.
     */
    public void setStartTime(DateTime d) { startTime = d; }
    
    /** Cambia la fecha de fin por otra fecha dada.
     *  @param d DateTime, la nueva fecha de fin.
     */
    public void setEndTime(DateTime d) { endTime = d; }
    
    /** Cambia el tipo por otro tipo dado.
     *  @param t int, el nuevo tipo, siendo 1 <= t <= 3.
     */
    public void setType(int t) { type = t; }
    
    /** Cambia el título por otro título dado.
     *  @param t String, el nuevo título.
     */
    public void setTitle(String t) { title = t; }
    
    /** Devuelve la duración en minutos.
     *  @return int, los minutos transcurridos entre la fecha de inicio y la de fin.
     */
    public int getDuration() {
        return UtilEvent.getDuration(startTime, endTime);
    }
    
    /** Devuelve la descripción del evento, con el siguiente formato:
     *  en una línea, el título, en la siguiente, la fecha de inicio separada por un guión de la fecha de fin y,
     *  en la última línea y entre paréntesis, una palabra que indica el tipo del evento en 
     *  plural y mayúsculas (CONGRESSES, SHOWS, EXHIBITIONS) acabado en salto de línea.
     *  @return String, la descripción.
     */
    public String toString() {
        String res = title + "\n" + startTime + " - " + endTime + "\n";
        switch (type) {
            case CONGRESS: 
                res += "(CONGRESSES)\n"; break;
            case SHOW: 
                res += "(SHOWS)\n"; break; 
            default:
                res += "(EXHIBITIONS)\n";
        }
        return res;
    }
    
    /**
     * Comprueba si el Event en curso es igual a otro dado.
     * @param o Object.
     * @return boolean, true si título, tipo y fechas de inicio y 
     * de fin del Event en curso coinciden con los del Event dado y  
     * false en caso contrario.
     */
    public boolean equals(Object o) {
        return o instanceof Event
            && title.equals(((Event) o).title)
            && type == ((Event) o).type
            && startTime.equals(((Event) o).startTime)
            && endTime.equals(((Event) o).endTime);
    }
}
