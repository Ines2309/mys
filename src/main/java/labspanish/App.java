package labspanish;

import java.util.ArrayList;
import java.util.List;

import labspanish.utilidades.Ejecucion;
import labspanish.utilidades.Intervalo;
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

        ReplicacionDeEjecuciones replicacion = new ReplicacionDeEjecuciones(ejecuciones);

        Intervalo esperaMedia = replicacion.estadisticaEsperaMedia();
        Intervalo esperaMinima = replicacion.estadisticaEsperaMin();
        Intervalo esperaMaxima =  replicacion.estadisticaEsperaMax();
        Intervalo esperaTotal = replicacion.estadisticaEsperaTotal();
        Intervalo minFila = replicacion.estadisticaMinFila();
        Intervalo maxFila = replicacion.estadisticaMaxFila();

        List<Intervalo> ocioMedia = new ArrayList<>();
        int cant= replicacion.getTamaño();
        for(int i=0; i<cant; i++){
            ocioMedia.add(replicacion.estadisticaOsciomedia(i));
        }
        
        List<Intervalo> ocioMin = new ArrayList<>();
        for(int i=0; i<cant; i++){
            ocioMin.add(replicacion.estadisticaOcioMin(i));
        }   

        List<Intervalo> ocioMax = new ArrayList<>();
        for(int i=0; i<cant; i++){
            ocioMax.add(replicacion.estadisticaOcioMax(i));
        }

        List<Intervalo> ocioTotal = new ArrayList<>();
        for(int i=0; i<cant; i++){
            ocioTotal.add(replicacion.estadisticaOcioTotal(i));
        }

        List<Intervalo> desgastes = new ArrayList<>();
        for(int i=0; i<cant; i++){
            desgastes.add(replicacion.estadisticaDesgasteMedia(i));
        }

        //Mostrar resultados 
        System.out.println("Resultados de la replicación de ejecuciones:");
        System.out.println("Tiempo de simulación: " + tiempoSimulacion);
        System.out.println("Estadísticas de espera:");


        
    }
}
