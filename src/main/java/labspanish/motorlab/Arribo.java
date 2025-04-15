package labspanish.motorlab;

import java.util.List;

import javax.swing.text.html.parser.Entity;

import labspanish.utilidades.Distribucion;
import labspanish.utilidades.Ramdomizer;

public class Arribo extends Evento{
      
    private Distribucion distribucionFinaldeServicio;
      
  

    public Arribo(Entity entidad, float clock, int ordenDeEstado, Distribucion distribucion,
            Distribucion distribucionFinaldeServicio) {
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
    public void planificar( FutureEventList  fel, Ramdomizer ramdom, List <Servidor> Servidores) {
        // TODO Auto-generated method stub
        
    }
    
    
    

    
    
}
