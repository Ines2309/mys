package labspanish.motorlab;


import labspanish.Entidad;
import labspanish.utilidades.DistribucionSalida;
import labspanish.utilidades.RandomMath;



public class Salida extends Evento {

    DistribucionSalida distribucion = new DistribucionSalida();

    public Salida(Entidad entidad, float clock , FutureEventList fel) {
        super(entidad, clock, 0.0,fel);
    }

    @Override
    public void planificar(RandomMath ramdom) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'planificar'");
    }
     
    //controlar servidor 
}
