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
        int cantidadEjecuciones = 3; // 50
        int cantidadServidores = 3; // 5
        //se gurda la informacion de cada ejecucion
        
        
        List<Ejecucion> ejecuciones = new ArrayList<Ejecucion>();
        for(int i = 0; i < cantidadEjecuciones; i++){
            Ejecucion ejecucion = new Ejecucion(tiempoSimulacion,cantidadServidores);
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

        for(int i=0; i<cantidadServidores; i++){
            ocioMedia.add(replicacion.estadisticaOsciomedia(i));
        }
        
        List<Intervalo> ocioMin = new ArrayList<>();
        for(int i=0; i<cantidadServidores; i++){
            ocioMin.add(replicacion.estadisticaOcioMin(i));
        }   

        List<Intervalo> ocioMax = new ArrayList<>();
        for(int i=0; i<cantidadServidores; i++){
            ocioMax.add(replicacion.estadisticaOcioMax(i));
        }

        List<Intervalo> ocioTotal = new ArrayList<>();
        for(int i=0; i<cantidadServidores; i++){
            ocioTotal.add(replicacion.estadisticaOcioTotal(i));
        }

        List<Intervalo> desgastes = new ArrayList<>();
        for(int i=0; i<cantidadServidores; i++){
            desgastes.add(replicacion.estadisticaDesgasteMedia(i));
        }

        //Mostrar resultados 
        System.out.println("Resultados de la replicación de ejecuciones:");
        System.out.println("---------------------------------------------------------------------------------------");
        System.out.println("Tiempo de simulación: " + tiempoSimulacion + " minutos.        Cantidad de ejecuciones: " + cantidadEjecuciones);
        System.out.println("-----------------------------Estadísticas de espera:-----------------------------------");
        System.err.println("Media de espera: " + esperaMedia.toString());
        System.err.println("Mínima de espera: " + esperaMinima.toString());
        System.err.println("Máxima de espera: " + esperaMaxima.toString());
        System.err.println("Total de espera: " + esperaTotal.toString());
        System.out.println("-----------------------------Estadísticas de fila:-----------------------------------");
        System.err.println("Mínima de fila: " + minFila.toString());
        System.err.println("Máxima de fila: " + maxFila.toString());
        System.out.println("-----------------------------Estadísticas de ocio:-----------------------------------");
        for(int i=0; i<cantidadServidores; i++){
            System.err.println("Pista " + (i+1) + ":");
            System.err.println("    Media de ocio: " + ocioMedia.get(i).toString());
            System.err.println("    Mínima de ocio: " + ocioMin.get(i).toString());
            System.err.println("    Máxima de ocio: " + ocioMax.get(i).toString());
            System.err.println("    Total de ocio: " + ocioTotal.get(i).toString());
        }
        System.out.println("-----------------------------Estadísticas de desgaste:-----------------------------------");
        for(int i=0; i<cantidadServidores; i++){
            System.err.println("Pista " + (i+1) + ":");
            System.err.println("    Desgaste medio: " + desgastes.get(i).toString());
        }
        System.out.println("---------------------------------------------------------------------------------------");
    }
}
