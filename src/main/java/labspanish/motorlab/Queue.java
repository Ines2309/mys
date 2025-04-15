package labspanish.motorlab;

public interface Queue {
 
    void enqueue(Entidad entidad); 
    Entidad dequEntidad();
    boolean isEmpty(); 
    int size();
}
