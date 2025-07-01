package mys.engine;

import java.util.ArrayList;
import java.util.List;

import mys.utilidades.Distribucion;
import mys.utilidades.Ordenador;

public class FutureEventList {
     private List<Evento> fel;
    private Ordenador ordenador = new Ordenador();
    private Distribucion distribucion;
    private Distribucion distibucion2;

    
    public FutureEventList(Distribucion distribucion,Distribucion distibucion2) {
        super();
        this.fel = new ArrayList<Evento>(); //FIJARSE SI ES EL CONSTRUCTOR CORRECTO
        this.distribucion = distribucion;
        this.distibucion2 = distibucion2;
        
    }

    public void inicializar(double tiempoFin) {
        FinSimulacion fin = new FinSimulacion(tiempoFin, distribucion);
        Entida entidadInicial = new Entida(1);
        Arribo inicial = new Arribo(entidadInicial, 0,distribucion, distibucion2);
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
        fel.sort(ordenador);
    }
    
    @Override
        public String toString(){
          String output= "================================== fel ==================================\n";
          for (Evento evento: this.fel ){
            
            output += "["+String.format("%.2f",evento.getClock())+","+ evento.getOrdenDeEstado()+","+ evento.getEntidad().getIdentificador()+"]\n";

          }
          return output +="**************************************";

        }
    
}
