package labspanish.motorlab;


import labspanish.utilidades.DistribucionSalida;
import labspanish.utilidades.Randomizer;



public class Salida extends Evento {

    DistribucionSalida distribucion = new DistribucionSalida();

    public Salida(Entidad entidad, float clock , FutureEventList fel) {
        super(entidad, clock, 0.0,fel);
    }

    @Override
    public void planificar(FutureEventList fel, Randomizer ramdom, Servidor Servidores) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'planificar'");
    }
     
    //controlar servidor 
}
