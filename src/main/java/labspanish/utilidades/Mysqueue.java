package labspanish.utilidades;

import java.util.ArrayList;
import java.util.List;

import labspanish.Entidad;
import labspanish.motorlab.Queue;

public final class Mysqueue implements Queue {

    private  List<Entidad> entidades; 
    private int cantMax;
    private int cantMin;

    public Mysqueue(){
        entidades = new ArrayList<Entidad>();
        cantMax = 0;
        cantMin = 0;
    }

    @Override
    public void enqueue(Entidad entidad) {
        this.entidades.add(entidad); 
        this.cantidades();
        
    }

    @Override
    public Entidad dequEntidad() {
        Entidad entidad = this.entidades.remove(0);
        this.cantidades();
        return entidad;
    }

    @Override
    public boolean isEmpty() {
        return this.entidades.isEmpty();
    }

    @Override
    public int size() {
        return this.entidades.size();
    }

    public void cantidades(){
        if(cantMax < this.size()){
            cantMax = this.size();
        }
        if((cantMin > this.size() && this.size()!=0)||(cantMin == 0)){
            cantMin = this.size();
        }
    }

    public int getCantMax() {
        return cantMax;
    }
    public int getCantMin() {
        return cantMin;
    }

    @Override
    public String toString() {
        return("+Largo maximo de fila de espera: " + cantMax +"\n+Largo minimo de fila de espera: " + cantMin + "\n");
    }

}
