package labspanish;

import labspanish.utilidades.RandomMath;

import java.util.ArrayList;
import java.util.List;

import labspanish.motorlab.Bootstraping;
import labspanish.motorlab.FutureEventList;
import labspanish.utilidades.EstadisticaEspera;
import labspanish.utilidades.EstadisticaOcio;
import labspanish.utilidades.Ordenador;
import labspanish.utilidades.Politica;
import labspanish.motorlab.Servidor;


/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )    {
        RandomMath random = new RandomMath();
        EstadisticaEspera espera = new EstadisticaEspera(100);
        Ordenador comparator = new Ordenador();
        FutureEventList fel = new FutureEventList(comparator);
        Servidor pista1 = new Servidor(1,100);
        List<Servidor> servidores = new ArrayList<Servidor>();
        servidores.add(pista1);
        Politica politica = new Politica(servidores);
        
        //Tiempo de simulacion 40320
        Bootstraping bootstraping = new Bootstraping(100, random, fel, politica, espera);

        bootstraping.run();
        
        System.out.println(fel.toString());
        System.out.println(fel.getFila().toString());

        System.out.println(bootstraping.getEspera().toString());
        for (Servidor servidor : bootstraping.obtenerServidores()) {
            System.out.println(servidor.getEstadisticaOcio().toString());
        }

        
    }
}
