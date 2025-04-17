package labspanish.motorlab;

import labspanish.Entidad;
import labspanish.utilidades.RandomMath;
import labspanish.utilidades.Randomizer;

public class FinSimulacion extends Evento{

    public FinSimulacion(Entidad entidad, float clock, FutureEventList fel) {
        super(entidad, clock, 1.0,fel);

    }

    @Override
    public void planificar(FutureEventList fel, RandomMath ramdom) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'planificar'");
    }

}
