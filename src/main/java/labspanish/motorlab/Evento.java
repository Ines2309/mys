package labspanish.motorlab;


import labspanish.utilidades.Randomizer;

public abstract class Evento {
 
    private Entidad entidad;     
    private float clock; 
    private double  ordenDeEstado; // salida, arribo y fin de servicio  //1) arribo   0.5 fin de simulacion  0) salida // 
    private FutureEventList fel;
  

    public abstract  void planificar(FutureEventList fel, Randomizer ramdom, Servidor Servidores);

    public Evento(Entidad entidad, float clock, double ordenDeEstado, FutureEventList fel) {
        this.entidad = entidad;
        this.clock = clock;
        this.ordenDeEstado = ordenDeEstado;
        this.fel = fel;
    }

    public FutureEventList getFel() {
        return fel;
    }

    public void setFel(FutureEventList fel) {
        this.fel = fel;
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
