package labspanish.motorlab;

import java.util.Comparator;
import java.util.List;

import labspanish.Entidad;


public class FutureEventList {

    private List<Evento> fel;
    private Comparator<Evento> comparador;
    private Boostraping bt;

    public FutureEventList(List<Evento> fel, Comparator<Evento> comparador, Boostraping bt) {
        this.fel = fel;
        this.comparador = comparador;
        this.bt = bt;
    }

    public Servidor pedirServidor() {
        return bt.buscarServidor();
    }
    
    public void ponerEnCola(Entidad entidad) {
        bt.ponerEnCola(entidad);
    }

    public Evento inminent(Evento e){
        return fel.remove(0);
    }
    
    public void insertar(Evento e) {
        fel.add(e);
        fel.sort(comparador);
    }
    
    public void inicializar(Servidor servidor) {
        //Entidad primerEntidad = new Entidad(1, servidor);
        //Arribo primerArribo = new Arribo(primerEntidad,0.0);

    }
    
}
