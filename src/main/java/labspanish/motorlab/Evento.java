package labspanish.motorlab;


import java.util.List;

import labspanish.Entidad;
import labspanish.utilidades.Politica;
import labspanish.utilidades.RandomMath;

public abstract class Evento {
 
    private Entidad entidad;     
    private float clock; 
    private double  ordenDeEstado; // salida, arribo y fin de servicio  //1) arribo   0.5 fin de simulacion  0) salida // 
  

    public abstract  void planificar(RandomMath ramdom, FutureEventList fel, List<Servidor> servidores, Politica politica);

    public Evento(Entidad entidad, float clock, double ordenDeEstado) {
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

    public float getClock() {
        return clock;
    }

    public void setClock(float clock) {
        this.clock = clock;
    }

    public double getOrdenDeEstado() {
        return ordenDeEstado;
    }

    public void setOrdenDeEstado(double ordenDeEstado) {
        this.ordenDeEstado = ordenDeEstado;
    }
      

    
    



    
}
