package mys.engine;

public class Entida {
      private int identificador; 
      private double clockArribo;
      private double priority; // 1 leve, 2 normal, 3 urgente el unico que va a cambiar es el de la cola de espera, el resto no cambia

    public Entida(int identificador,double priority) {
        this.identificador = identificador;
        this.clockArribo = 0.0;
        this.priority = priority; // por defecto es normal
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
    public double getPriority() {
        return priority;
    }
    public void setPriority(double priority) {
        this.priority = priority;
    }
    
}
