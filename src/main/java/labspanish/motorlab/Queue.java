package labspanish.motorlab;

import labspanish.Entidad;

public interface Queue {
 
    void enqueue(Entidad entidad); 
    Entidad dequEntidad();
    boolean isEmpty(); 
    int size();
}
