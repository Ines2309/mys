package labspanish.motorlab;

import java.util.Comparator;
import java.util.List;
import labspanish.Entidad;
import labspanish.utilidades.Mysqueue;


public class FutureEventList {

    private List<Evento> fel;
    private Comparator<Evento> comparador;
    private Mysqueue fila;

    public FutureEventList(List<Evento> fel, Comparator<Evento> comparador) {
        this.fel = fel;
        this.comparador = comparador;
    }
 
     public Servidor pedirServidor(Servidor servidor) { 
     return servidor;
    }
    
    public void ponerEnCola(Entidad entidad) { // poner en la fila de espera 
       fila.enqueue(entidad);
    }

    public Entidad extraerCola(){
        return fila.dequEntidad();
    }

    public Evento inminent(){
        return fel.remove(0);
    }
    
    public void insertar(Evento evento) {
        fel.add(evento);
        fel.sort(comparador);
    }
    
    public Mysqueue getFila() {
        return fila;
    }

    public void setFila(Mysqueue fila) {
        this.fila = fila;
    }
    @Override
        public String toString(){
          String output= "================================== fel ==================================";
          for (Evento evento: this.fel ){
            output += "["+evento.getClock()+","+ evento.getOrdenDeEstado()+"]\n";

          }
          return output +="**************************************";

        }
}
