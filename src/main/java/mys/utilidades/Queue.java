package mys.utilidades;
import mys.engine.Entida;
public interface Queue {
    
    void enqueue(Entida entidad); 
    Entida dequEntidad();
    boolean isEmpty(); 
    int size();
}
