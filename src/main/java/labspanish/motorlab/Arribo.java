package labspanish.motorlab;

import java.util.List;

import javax.swing.text.html.parser.Entity;

import labspanish.utilidades.Distribucion;
import labspanish.utilidades.Randomizer;

public class Arribo extends Evento{
      
    private Distribucion distribucionFinaldeServicio;

    public Arribo(Distribucion distribucionFinaldeServicio, Entity entidad, float clock, double ordenDeEstado, Distribucion distribucion) {
        super(entidad, clock, ordenDeEstado, distribucion);
        this.distribucionFinaldeServicio = distribucionFinaldeServicio;
    }
      

    public Distribucion getDistribucionFinaldeServicio() {
        return distribucionFinaldeServicio;
    }

    public void setDistribucionFinaldeServicio(Distribucion distribucionFinaldeServicio) {
        this.distribucionFinaldeServicio = distribucionFinaldeServicio;
    }

    @Override
    public void planificar( FutureEventList  fel, Randomizer ramdom, List <Servidor> Servidores) {
        // TODO Auto-generated method stub
        
    }
    
    
    

    
    
}
