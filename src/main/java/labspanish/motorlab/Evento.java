package labspanish.motorlab;


import labspanish.Entidad;
import labspanish.utilidades.EstadisticaEspera;
import labspanish.utilidades.Politica;
import labspanish.utilidades.RandomMath;

public abstract class Evento {
 
    private Entidad entidad;     
    private double clock; 
    private double  ordenDeEstado; // salida, arribo y fin de servicio  //1) arribo   0.5 fin de simulacion  0) salida // 
  

    public abstract void planificar(RandomMath ramdom, FutureEventList fel, Politica politica, EstadisticaEspera estadisticaEspera);

    public abstract void aplicarEfectoSecundario(RandomMath ramdom);

    public Evento(Entidad entidad, double clock, double ordenDeEstado) {
        this.entidad = entidad;
        this.clock = clock;
        this.ordenDeEstado = ordenDeEstado;
    }

    public Entidad getEntidad() {
        return entidad;
    }

    public void setEntidad(Entidad entidad) {
        this.entidad = entidad;
    }

    public double getClock() {
        return clock;
    }

    public void setClock(double clock) {
        this.clock = clock;
    }

    public double getOrdenDeEstado() {
        return ordenDeEstado;
    }

    public void setOrdenDeEstado(double ordenDeEstado) {
        this.ordenDeEstado = ordenDeEstado;
    }
      

    
    



    
}
