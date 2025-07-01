package mys.engine;

public class Entida {
      private int identificador; 
    private double clockArribo;

    public Entida(int identificador) {
        this.identificador = identificador;
        this.clockArribo = 0.0;
    }
    
    public double getClockArribo() {
        return clockArribo;
    }

    public void setClockArribo(double clockArribo) {
        this.clockArribo = clockArribo;
    }

    public int getIdentificador() {
        return identificador;
    }

    public void setIdentificador(int identificador) {
        this.identificador = identificador;
    }
    
}
