package labspanish.utilidades;

public abstract class Distribucion {

    public double mediaDistribucion;
    public double desviacionDistribucion;
    
    public Distribucion() {   
    }
    public Distribucion (double media, double desviacion ){
        this.mediaDistribucion=media;
        this.desviacionDistribucion=desviacion;
    }
    abstract public double getProbabilidad(double Evento);
    abstract public double getTiempo(double acumulativo); 
    
}
