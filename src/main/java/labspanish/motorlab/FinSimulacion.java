package labspanish.motorlab;

import labspanish.Entidad;
import labspanish.utilidades.EstadisticaEspera;
import labspanish.utilidades.Politica;
import labspanish.utilidades.RandomMath;

public class FinSimulacion extends Evento{

    public FinSimulacion(double findeSimulacion) {
        super(new Entidad(-1), findeSimulacion, 0.5);  //la simualcion termina en el tiempo 60

    }

    @Override
    public boolean planificar(RandomMath ramdom,FutureEventList fel, Politica politica, EstadisticaEspera estadist) {
        // No se planifica nada, ya que es el fin de la simulacion
        return false;
    }

    @Override
    public void aplicarEfectoSecundario(RandomMath ramdom) {
        // No se aplica ningun efecto secundario, ya que es el fin de la simulacion
    }

}
