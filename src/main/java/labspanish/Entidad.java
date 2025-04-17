package labspanish;

import labspanish.motorlab.Servidor;

public class Entidad {

    private int identificador; 
    private Servidor servidor;
    private double clockArribo;

    public Entidad(int identificador, Servidor servidor) {
        this.identificador = identificador;
        this.servidor = servidor;
        this.clockArribo = 0.0;
    }
    
    public double getClockArribo() {
        return clockArribo;
    }

    public void setClockArribo(double clockArribo) {
        this.clockArribo = clockArribo;
    }

    public Servidor getServidor() {
        return servidor;
    }

    public void setServidor(Servidor servidor) {
        this.servidor = servidor;
    }

    public int getIdentificador() {
        return identificador;
    }

    public void setIdentificador(int identificador) {
        this.identificador = identificador;
    }
    
    
}
