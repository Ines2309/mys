package labspanish.motorlab;

import java.util.List;

import labspanish.Entidad;
import labspanish.utilidades.EstadisticaEspera;
import labspanish.utilidades.Politica;
import labspanish.utilidades.RandomMath;

public class FinSimulacion extends Evento{

    public FinSimulacion(double findeSimulacion) {
        super(new Entidad(-1), findeSimulacion, 0.5);  //la simualcion termina en el tiempo 60

    }

    @Override
    public void planificar(RandomMath ramdom,FutureEventList fel, Politica politica, EstadisticaEspera estadist) {
        // No se planifica nada, ya que es el fin de la simulacion
    }

}
