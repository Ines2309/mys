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
        EstadisticaEspera espera = new EstadisticaEspera();
        EstadisticaOcio ocio = new EstadisticaOcio();
        Ordenador comparator = new Ordenador();
        FutureEventList fel = new FutureEventList(comparator);
        Servidor pista1 = new Servidor(1);
        List<Servidor> servidores = new ArrayList<Servidor>();
        servidores.add(pista1);
        Politica politica = new Politica(servidores);
        
        Bootstraping bootstraping = new Bootstraping(40320, random, fel, politica, espera);

        bootstraping.run();
        
        //PRINTEAR RESULTADOS ESTADISTICOS
        //OCIO
        System.out.println(bootstraping.obtenerEstadisticasDeOcio().toString());
        
    }
}
