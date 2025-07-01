package mys.estadisticas;

import java.util.List;

import mys.engine.Bootstraping;

public class EstadisticaTotal {
    
    private List<EstadisticaOcio> ocio; //porque tenemos mas de un servidor con sus respectivas estadisticas 
    private EstadisticaEspera espera;
    private List<Double> listaDesgaste; //porque tenemos mas de un servidor con sus respectivos desgastes
    private int maxFila;
    private int minFila;
 
    /* */
    public EstadisticaTotal(Bootstraping bs) {
        this.ocio = bs.getPolitica().getEstadisticasOcio(); 
        this.espera = bs.getEspera();
        this.listaDesgaste = bs.getPolitica().getListaDesgaste();
        this.maxFila = bs.getPolitica().getMaxFilaEspera();
        this.minFila = bs.getPolitica().getMinFilaEspera();
    }
    
    public List<EstadisticaOcio> getOcio() {
        return ocio;
    }

    public void setOcio(List<EstadisticaOcio> ocio) {
        this.ocio = ocio;
    }

    public EstadisticaEspera getEspera() {
        return espera;
    }

    public void setEspera(EstadisticaEspera espera) {
        this.espera = espera;
    }

    public List<Double> getListaDesgaste() {
        return listaDesgaste;
    }

    public void setListaDesgaste(List<Double> listaDesgaste) {
        this.listaDesgaste = listaDesgaste;
    }

    public int getMaxFila() {
        return maxFila;
    }

    public void setMaxFila(int maxFila) {
        this.maxFila = maxFila;
    }

    public int getMinFila() {
        return minFila;
    }

    public void setMinFila(int minFila) {
        this.minFila = minFila;
    }
    


    
}
