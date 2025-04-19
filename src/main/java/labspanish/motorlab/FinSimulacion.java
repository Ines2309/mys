package labspanish.motorlab;

import java.util.List;

import labspanish.Entidad;
import labspanish.utilidades.Politica;
import labspanish.utilidades.RandomMath;

public class FinSimulacion extends Evento{

    public FinSimulacion(Entidad entidad, float clock) {
        super(entidad, clock, 1.0);

    }

    @Override
    public void planificar(RandomMath ramdom,FutureEventList fel, List<Servidor> servidor, Politica politica) {
        // No se planifica nada, ya que es el fin de la simulacion
    }

}
