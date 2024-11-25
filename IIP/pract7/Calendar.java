package pract7;

import pract5.DateTime;

/**
 * Clase Calendar: clase tipo de datos que representa el calendario 
 * de un lugar donde se celebran eventos.
 *
 * @author IIP - PrÃ¡ctica 7
 * @version Curso 2023/24
 */
public class Calendar {
    /* COMPLETAR declaración de atributos */
    public static final int MAX_EVENTS = 30;
    private int numEvents;
    private Event[] program;
    private int[] numPerType;
    
    /** Crea un Calendar vacío (sin eventos de ningún tipo) */
    public Calendar() {  
        /* COMPLETAR */
        numEvents = 0;
        program = new Event[MAX_EVENTS];
        numPerType = new int[4];
    }
     
    /** Devuelve el número actual de eventos.
     *  @return int, el número de eventos.
     */
    public int getNumEvents() { return this.numEvents; }
    
    /** Devuelve el número de eventos de un tipo type dado, siendo 1 <= type <= 3.
     *  @param type int, el tipo. Precondición: 1 <= type <= 3.
     *  @return int, el número de eventos de tipo type.
     */
    public int getNumType(int type) { return this.numPerType[type]; }
    
    /** Devuelve la representaciÃ³n como String de todos los eventos del calendario.
     *  @return String.
     */
    public String toString() {
        String res = "";
        /* COMPLETAR */
        for(int i = 0; i<numEvents; i++){
            res += this.program[i].toString() + "\n";
        }
        return res;
    }
    
    /** Devuelve true si un Event e dado se solapa con cualquier otro Event 
     *  del calendario. En caso contrario, devuelve false.
     *  @param e Event, el evento.
     *  @return boolean, true si e se solapa y false en caso contrario.
     */
    private boolean overlaps(Event e) {
        boolean exists = false;
        /* COMPLETAR */
        for(int i = 0; i<numEvents && exists == false; i++){
            if(UtilEvent.overlaps(e, this.program[i])) {exists = true;}
        }
        return exists;
    }
    
    /** Dado un Event e, si cabe y no se solapa con ningún otro del calendario, lo añade en orden cronológico, 
     *  y devuelve true. Si no cabe o hay solapamiento, no lo añade y devuelve false.
     *  @param e Event, evento a añadir.  
     *  @return boolean, true si se añade y false en caso contrario.
     */    
    public boolean add(Event e) { 
        /* COMPLETAR */
        if(!overlaps(e) && numEvents < MAX_EVENTS){
            int i = numEvents-1;
            while(i>=0 && e.getStartTime().compareTo(this.program[i].getStartTime()) < 0){
                this.program[i+1] = this.program[i];
                i--;
            }
            
            this.program[i+1] = e;
            numPerType[e.getType()]++;
            numEvents++;
        }
        else{
            return false;
        }
        
        return true; 
    }
    
    /** Devuelve la posición que ocupa en el array program un evento de título dado
     *  o -1 si no existe.
     *  @param title String, el título.
     *  @return int, la posición del evento en el array o -1 si no está. 
     */
    private int searchTitle(String title) {
        /* COMPLETAR */
        for(int i = numEvents-1; i>=0; i--){
            if(title.equals(this.program[i].getTitle())) return i;
        }
        return -1;  
    }
           
    /** Elimina del calendario el evento de título dado, si existe, y devuelve true.
     *  Si no existe, no elimina nada y devuelve false.
     *  @param title String, el título.
     *  @return boolean, true si se elimina y false en caso contrario.
     */
    public boolean delete(String title) {
        /* COMPLETAR */
        int pos = searchTitle(title);
        if(pos < 0) return false;
        else{
            numPerType[this.program[pos].getType()]--;
            for(int i = pos; i<numEvents && i<MAX_EVENTS-1; i++){
                this.program[i] = this.program[i+1];
            }
            numEvents--;
            this.program[numEvents] = null;
        }
        return true;
    }
    
    /** Devuelve el evento más largo (con más duración) del calendario.
     *  Precondición: al menos un evento. 
     *  @return Event, el evento.
     */
    public Event eventLarger() {
        /* COMPLETAR */
        Event larger = this.program[0];
        for(int i = 1; i<numEvents; i++){
            if(larger.getDuration() < this.program[i].getDuration()){
                larger = this.program[i];
            }
        }
        return larger;
    }
    
    /** Devuelve un array con todos los eventos de tipo type del calendario, siendo 1 <= type <= 3. 
     *  El tamaño del array devuelto ha de ser igual al número de eventos de tipo type, 
     *  siendo 0 si no hay ningún evento de dicho tipo.
     *  @param type int, el tipo. Precondición: 1 <= type <= 3.
     *  @return Event[], el array.
     */
    public Event[] filterByType(int type) {
        /* COMPLETAR */
        int n = this.numPerType[type];
        Event[] filtered = new Event[n];
        n = 0;
        for(int i = 0; i<numEvents && n<this.numPerType[type]; i++){
            if(this.program[i].getType() == type){
                filtered[n] = this.program[i];
                n++;
            }
        }
        
        return filtered;
    }
    
}
