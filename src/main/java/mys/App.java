package mys;

import java.util.ArrayList;
import java.util.List;

import mys.distribuciones.Exponencial;
import mys.distribuciones.Uniforme;
import mys.estadisticas.Intervalo;
import mys.utilidades.Ejecucion;
import mys.utilidades.ReplicacionDeEjecuciones;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        double tiempoSimulacion = 40320; // 40320
        int cantidadEjecuciones = 50; // 50
        int cantidadServidores = 5; // 5
        //se gurda la informacion de cada ejecucion
        //informacion del promedio de arribos y salidas
        
        Uniforme distribucionSalida = new Uniforme(10, 25);
        Exponencial distribucionArribo = new Exponencial(15);
        
        List<Ejecucion> ejecuciones = new ArrayList<Ejecucion>();
        for(int i = 0; i < cantidadEjecuciones; i++){
            Ejecucion ejecucion = new Ejecucion(tiempoSimulacion,cantidadServidores,distribucionArribo, distribucionSalida);
            ejecuciones.add(ejecucion);


        }

        ReplicacionDeEjecuciones replicacion = new ReplicacionDeEjecuciones(ejecuciones);

        Intervalo esperaMedia = replicacion.estadisticaEsperaMedia();
        Intervalo esperaMinima = replicacion.estadisticaEsperaMin();
        Intervalo esperaMaxima =  replicacion.estadisticaEsperaMax();
        Intervalo esperaTotal = replicacion.estadisticaEsperaTotal();
        Intervalo minFila = replicacion.estadisticaMinFila();
        Intervalo maxFila = replicacion.estadisticaMaxFila();
        Intervalo promedioArribos = replicacion.estadisticaPromedioArribos();
        Intervalo promedioSalidas = replicacion.estadisticaPromedioSalidas();

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
        System.out.println("Cantidad de Arribos:"+ promedioArribos.toString() + " "+ promedioArribos.mediaIntervalo());
        System.out.println("Cantidad de Salidas:"+ promedioSalidas.toString()+""+ promedioSalidas.mediaIntervalo());
        System.out.println("-----------------------------Estadísticas de espera:-----------------------------------");
        System.err.println("Media de espera: " + esperaMedia.toString()+" "+ esperaMedia.mediaIntervalo());
        System.err.println("Mínima de espera: " + esperaMinima.toString()+" "+ esperaMinima.mediaIntervalo());
        System.err.println("Máxima de espera: " + esperaMaxima.toString()+" "+ esperaMaxima.mediaIntervalo());
        System.err.println("Total de espera: " + esperaTotal.toString()+" "+ esperaTotal.mediaIntervalo());
        System.out.println("-----------------------------Estadísticas de fila:-----------------------------------");
        System.err.println("Mínima de fila: " + minFila.toString()+" "+ minFila.mediaIntervalo());
        System.err.println("Máxima de fila: " + maxFila.toString()+" "+ maxFila.mediaIntervalo());
        System.out.println("-----------------------------Estadísticas de ocio:-----------------------------------");
        for(int i=0; i<cantidadServidores; i++){
            System.err.println("Pista " + (i+1) + ":");
            System.err.println("    Media de ocio: " + ocioMedia.get(i).toString()+" "+ ocioMedia.get(i).mediaIntervalo());
            System.err.println("    Mínima de ocio: " + ocioMin.get(i).toString()+" "+ ocioMin.get(i).mediaIntervalo());
            System.err.println("    Máxima de ocio: " + ocioMax.get(i).toString()+" "+ ocioMax.get(i).mediaIntervalo());
            System.err.println("    Total de ocio: " + ocioTotal.get(i).toString()+" "+ ocioTotal.get(i).mediaIntervalo());
        }
        System.out.println("-----------------------------Estadísticas de desgaste:-----------------------------------");
        for(int i=0; i<cantidadServidores; i++){
            System.err.println("Pista " + (i+1) + ":");
            System.err.println("    Desgaste medio: " + desgastes.get(i).toString()+" "+ desgastes.get(i).mediaIntervalo());
        }
        System.out.println("---------------------------------------------------------------------------------------");
        
    }
}

