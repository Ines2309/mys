package labspanish.motorlab;

import labspanish.Entidad;
import labspanish.utilidades.EstadisticaOcio;
import labspanish.utilidades.Mysqueue;

public class Servidor {
    private int id; 
    private boolean busy;
    private double clockSalida;
    private EstadisticaOcio estadisticaOcio;
    
    public Servidor(int id, double tiempodeSimulacion) {
        this.id = id;
        this.busy = false;
        this.clockSalida=0.0;
        this.estadisticaOcio= new EstadisticaOcio(tiempodeSimulacion);
    }

    public EstadisticaOcio getEstadisticaOcio() {
        return estadisticaOcio;
    }

    public void setEstadisticaOcio(EstadisticaOcio estadisticaEspera) {
        this.estadisticaOcio = estadisticaEspera;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getClockSalida() {
        return clockSalida;
    }

    public void setClockSalida(double clockSalida) {
        this.clockSalida = clockSalida;
    }

    public boolean isBusy() {
        return this.busy;
    }


    public void setBusy(boolean busy) {
        this.busy = busy;
    }
     
    



    
}
