package mys.engine;

import mys.estadisticas.EstadisticaEspera;
import mys.mypolitics.Politica;
import mys.numerosaleatorios.RandomMath;
import mys.utilidades.Distribucion;
import mys.utilidades.MyqueuePriority;

public abstract class Evento {
    private Entida entidad;     
    private double clock; 
    private double  ordenDeEstado; // salida, arribo y fin de servicio  //1) arribo   0.5 fin de simulacion  0) salida // 
    private Distribucion distribucion;

    public abstract boolean planificar(RandomMath ramdom, FutureEventList fel, Politica politica, EstadisticaEspera estadisticaEspera, MyqueuePriority queue);

    public abstract void aplicarEfectoSecundario(RandomMath ramdom);

    public Evento(Entida entidad, double clock, double ordenDeEstado, Distribucion distribucion) {
        this.entidad = entidad;
        this.clock = clock;
        this.ordenDeEstado = ordenDeEstado;
        this.distribucion = distribucion;
    }

    public Entida getEntidad() {
        return entidad;
    }

    public void setEntidad(Entida entidad) {
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
      
    public Distribucion getDistribucion() {
        return distribucion;
    }
    public void setDistribucion(Distribucion distribucion) {
        this.distribucion = distribucion;
    }
}
