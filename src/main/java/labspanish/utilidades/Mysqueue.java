package labspanish.utilidades;

import java.util.List;

import labspanish.motorlab.Entidad;
import labspanish.motorlab.Queue;

public final class Mysqueue implements Queue {

    private  List<Entidad> entidades; 

    @Override
    public void enqueue(Entidad entidad) {
        this.entidades.add(entidad); 

    }

    @Override
    public Entidad dequEntidad() {
        return this.entidades.remove(0);
    }

    @Override
    public boolean isEmpty() {
        return this.entidades.isEmpty();
    }

    @Override
    public int size() {
        return this.entidades.size();
    }


    

}
