package mys.engine;

import mys.estadisticas.EstadisticaEspera;
import mys.mypolitics.Politica;
import mys.numerosaleatorios.RandomMath;
import mys.utilidades.Distribucion;

public class FinSimulacion extends Evento {
     public FinSimulacion(double findeSimulacion,Distribucion distribucion) {
        super(new Entida(-1,2.0), findeSimulacion, 0.5,distribucion);  //la simualcion termina en el tiempo 60

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
