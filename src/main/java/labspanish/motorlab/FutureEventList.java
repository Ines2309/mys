package labspanish.motorlab;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import labspanish.Entidad;



public class FutureEventList {

    private List<Evento> fel;
    private Comparator<Evento> comparador;

    
    public FutureEventList(Comparator<Evento> comparador) {
        this.fel = new ArrayList<Evento>(); //FIJARSE SI ES EL CONSTRUCTOR CORRECTO
        this.comparador = comparador;
    }

    public void inicializar(double tiempoFin) {
        FinSimulacion fin = new FinSimulacion(tiempoFin);
        Entidad entidadInicial = new Entidad(1);
        Arribo inicial = new Arribo(entidadInicial, 0);
        insertar(fin);
        insertar(inicial);
    }
 
     public Servidor pedirServidor(Servidor servidor) { 
     return servidor;
    }

    public Evento inminente(){
        return fel.remove(0);
    }
    
    public void insertar(Evento evento) {
        fel.add(evento);
        fel.sort(comparador);
    }
    
    @Override
        public String toString(){
          String output= "================================== fel ==================================\n";
          for (Evento evento: this.fel ){
            
            output += "["+evento.getClock()+","+ evento.getOrdenDeEstado()+","+ evento.getEntidad().getIdentificador()+"]\n";

          }
          return output +="**************************************";

        }
}
