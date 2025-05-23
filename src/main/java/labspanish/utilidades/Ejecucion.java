package labspanish.utilidades;

import java.util.List;

import labspanish.motorlab.Bootstraping;
import labspanish.motorlab.Servidor;

public class Ejecucion {
    private List<Servidor> servidores;

    private Bootstraping bootstraping;
    private EstadisticaTotal estadisticaTotal;

    public Ejecucion(double tiempoSimulacion) {
        Servidor pista1 = new Servidor(1,tiempoSimulacion);
        Servidor pista2 = new Servidor(2,tiempoSimulacion);
        Servidor pista3 = new Servidor(3,tiempoSimulacion);
        Servidor pista4 = new Servidor(4,tiempoSimulacion);
        Servidor pista5 = new Servidor(5,tiempoSimulacion);
        servidores.add(pista1);
        servidores.add(pista2);
        servidores.add(pista3);
        servidores.add(pista4);
        servidores.add(pista5);
        this.bootstraping = new Bootstraping(tiempoSimulacion, servidores);
        this.bootstraping.run();
        this.estadisticaTotal = new EstadisticaTotal(bootstraping);
    }
}
