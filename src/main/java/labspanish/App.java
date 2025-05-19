package labspanish;

import java.util.ArrayList;
import java.util.List;

import labspanish.motorlab.Bootstraping;
import labspanish.motorlab.FutureEventList;
import labspanish.motorlab.Servidor;
import labspanish.utilidades.EstadisticaEspera;
import labspanish.utilidades.EstadisticaOcio;
import labspanish.utilidades.EstadisticaTotal;
import labspanish.utilidades.Ordenador;
import labspanish.utilidades.Politica;
import labspanish.utilidades.RandomMath;


/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )    {
        double tiempoSimulacion = 403; // 40320
        RandomMath random = new RandomMath();
        EstadisticaEspera espera = new EstadisticaEspera(tiempoSimulacion);        
        Ordenador comparator = new Ordenador();
        FutureEventList fel = new FutureEventList(comparator);
        Servidor pista1 = new Servidor(1,tiempoSimulacion);
        Servidor pista2 = new Servidor(2,tiempoSimulacion);
        Servidor pista3 = new Servidor(3,tiempoSimulacion);
        Servidor pista4 = new Servidor(4,tiempoSimulacion);
        Servidor pista5 = new Servidor(5,tiempoSimulacion);

        List<Servidor> servidores = new ArrayList<Servidor>();
        
        servidores.add(pista1);
        servidores.add(pista2);
        servidores.add(pista3);
        servidores.add(pista4);
        servidores.add(pista5);

        Politica politica = new Politica(servidores);

        //se gurda la informacion de cada ejecucion
        List<EstadisticaTotal> estadisticas = new ArrayList<EstadisticaTotal>();
        
        //Tiempo de simulacion 40320
        Bootstraping bootstraping = new Bootstraping(tiempoSimulacion, random, fel, politica, espera);

        bootstraping.run();
        
        /*System.out.println(bootstraping.getEspera().toString());
        for (Servidor servidor : bootstraping.obtenerServidores()) {
            System.out.println(servidor.mostrarDesgasteString());
            System.out.println(servidor.getEstadisticaOcio().toString());
        }
        System.out.println(politica.inforServidor());
           //aca queremos ver el maximo y minimo de espera de todos los servidores
        */
    }
}
