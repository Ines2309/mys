package labspanish;

import java.util.ArrayList;
import java.util.List;

import labspanish.motorlab.Bootstraping;
import labspanish.motorlab.FutureEventList;
import labspanish.motorlab.Servidor;
import labspanish.utilidades.Ejecucion;
import labspanish.utilidades.EstadisticaEspera;
import labspanish.utilidades.EstadisticaOcio;
import labspanish.utilidades.EstadisticaTotal;
import labspanish.utilidades.Ordenador;
import labspanish.utilidades.Politica;
import labspanish.utilidades.RandomMath;
import labspanish.utilidades.ReplicacionDeEjecuciones;


/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )    {
        double tiempoSimulacion = 403; // 40320
        //se gurda la informacion de cada ejecucion
        
        
        List<Ejecucion> ejecuciones = new ArrayList<Ejecucion>();
        for(int i = 0; i < 50; i++){
            Ejecucion ejecucion = new Ejecucion(tiempoSimulacion);
            ejecuciones.add(ejecucion);
        }

        

        
    }
}
