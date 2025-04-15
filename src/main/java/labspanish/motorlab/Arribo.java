package labspanish.motorlab;


import labspanish.utilidades.DistribucionArribo;
import labspanish.utilidades.Randomizer;

public class Arribo extends Evento{

    private DistribucionArribo distribucion = new DistribucionArribo();  

    public Arribo(Entidad entidad, float clock, FutureEventList fel ) {
        super(entidad, clock, 1.0,fel);
    }
      

    @Override
    public void planificar( FutureEventList  fel, Randomizer ramdom, Servidor servidor) {
        
        
    }
    
    
    

    
    
}
