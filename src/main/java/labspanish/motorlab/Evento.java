package labspanish.motorlab;

import java.util.List;

import javax.swing.text.html.parser.Entity;

import labspanish.utilidades.Distribucion;
import labspanish.utilidades.Randomizer;

public abstract class Evento {
 
    private Entity entidad; 
    private float clock; 
    private double  ordenDeEstado; // salida, arrivo y fin de servicio  //1) arribo   0.5 fin de simulacion  0) salida // 
    private Distribucion distribucion; 
  

    public void setDistribucion(Distribucion distribucion) {
        this.distribucion = distribucion;
    }

    public abstract  void planificar(FutureEventList fel, Randomizer ramdom, List<Servidor>Servidores);

    public Evento(Entity entidad, float clock, double ordenDeEstado, Distribucion distribucion) {
        this.entidad = entidad;
        this.clock = clock;
        this.ordenDeEstado = ordenDeEstado;
        this.distribucion= distribucion;
    }

    public Entity getEntidad() {
        return entidad;
    }

    public void setEntidad(Entity entidad) {
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
      
    public Distribucion getDistribucion() {
        return distribucion;
    }

    
    



    
}
