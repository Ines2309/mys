package labspanish.motorlab;

import labspanish.Entidad;
import labspanish.utilidades.Randomizer;

public class FinSimulacion extends Evento{

    public FinSimulacion(Entidad entidad, float clock, FutureEventList fel) {
        super(entidad, clock, 1.0,fel);

    }

    @Override
    public void planificar(FutureEventList fel, Randomizer ramdom, Servidor Servidores) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'planificar'");
    }

}
