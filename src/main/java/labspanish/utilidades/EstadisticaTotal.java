package labspanish.utilidades;

import java.util.List;

import labspanish.motorlab.Bootstraping;

// es utilizado para almacenar la informacion de 1 bootstraping 

public class EstadisticaTotal {
    private List<EstadisticaOcio> ocio; //porque tenemos mas de un servidor con sus respectivas estadisticas 
    private EstadisticaEspera espera;
    private List<Double> listaDesgaste; //porque tenemos mas de un servidor con sus respectivos desgastes
    private int maxFila;
    private int minFila;
 

    public EstadisticaTotal(Bootstraping bs) {
        this.ocio = bs.getPolitica().getEstadisticasOcio();
        this.espera = bs.getEspera();
        this.listaDesgaste = bs.getPolitica().getListaDesgaste();
        this.maxFila = bs.getPolitica().getMaxFilaEspera();
        this.minFila = bs.getPolitica().getMinFilaEspera();
    }
    
    
    

    
}