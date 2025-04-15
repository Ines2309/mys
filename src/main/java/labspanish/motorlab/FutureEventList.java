package labspanish.motorlab;

import java.util.Comparator;
import java.util.List;

import labspanish.utilidades.Distribucion;

public class FutureEventList {

    private List<Evento> fel;
    private Comparator<Evento> comparador;

    public FutureEventList(List<Evento> fel, Comparator<Evento> comparador) {
        this.fel = fel;
        this.comparador = comparador;
    }

    public Evento inminent(Evento e){
        return fel.remove(0);
    }
    
    public void insertar(Evento e) {
        fel.add(e);
        fel.sort(comparador);
    }
    
    public void inicializar() {
        Arribo primerArribo = new Arribo(0,1);
    }
    
}
