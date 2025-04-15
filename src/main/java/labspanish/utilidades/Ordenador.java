package labspanish.utilidades;

import java.util.Comparator;

import labspanish.motorlab.Evento;

public class Ordenador implements Comparator<Evento>{
    @Override
    public int compare(Evento e1, Evento e2) {

        if(e1.getClock() < e2.getClock()){
            return -1;
        }
        else if (e1.getClock() > e2.getClock()){
            return 1;
        }
        else if (e1.getOrdenDeEstado() < e2.getOrdenDeEstado()) {
            return -1;
        }
        else if (e1.getOrdenDeEstado() > e2.getOrdenDeEstado()) {
            return 1;
        }
        else {
            return 0;
        }
    }
}
