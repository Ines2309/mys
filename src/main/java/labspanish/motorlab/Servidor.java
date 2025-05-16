package labspanish.motorlab;

import labspanish.Entidad;
import labspanish.utilidades.EstadisticaOcio;
import labspanish.utilidades.Mysqueue;

public class Servidor {
    private int id; 
    private boolean busy;
    private double clockSalida;
    private EstadisticaOcio estadisticaOcio;
    private Mysqueue fila;
    private int desgaste;
    
    public Servidor(int id, double tiempoDeSimulacion) {
        this.id = id;
        this.busy = false;
        this.clockSalida=0.0;
        this.estadisticaOcio= new EstadisticaOcio(tiempoDeSimulacion);
        this.fila = new Mysqueue();
        this.desgaste=3000;
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
     
    public void setFila(Mysqueue fila) {
        this.fila = fila;
    }

    public Mysqueue getFila() {
        return fila;
    }

    public void ponerEnCola(Entidad entidad) { // poner en la fila de espera 
        fila.enqueue(entidad);
     }
 
     public Entidad extraerCola(){
         return fila.dequEntidad();
     }
   
    public void setDesgaste(double desgaste){ //aca solo le pasa lo que calcula la distribucion
        this.desgaste -=desgaste;
    }

    public double getDesgaste(){
        return desgaste;
    }


    public String mostrarDesgasteString(){
        return ("+Desgaste del servidor \""+this.id+ "\" : "+ this.desgaste + "\n");
    }

    
}
