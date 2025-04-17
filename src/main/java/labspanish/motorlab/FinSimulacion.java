package labspanish.motorlab;

import labspanish.Entidad;
import labspanish.utilidades.RandomMath;

public class FinSimulacion extends Evento{

    public FinSimulacion(Entidad entidad, float clock, FutureEventList fel) {
        super(entidad, clock, 1.0,fel);

    }

    @Override
    public void planificar(RandomMath ramdom) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'planificar'");
    }

}
