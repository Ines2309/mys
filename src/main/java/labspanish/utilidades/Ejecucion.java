package labspanish.utilidades;

import java.util.ArrayList;
import java.util.List;

import labspanish.motorlab.Bootstraping;
import labspanish.motorlab.Servidor;

public class Ejecucion {
    private List<Servidor> servidores;

    private Bootstraping bootstraping;
    private EstadisticaTotal estadisticaTotal;

    public Ejecucion(double tiempoSimulacion, int cantidadServidores) {
        this.servidores = new ArrayList<Servidor>();
        Servidor pista= null;
        for (int i = 1; i <= cantidadServidores; i++) {
            pista = new Servidor(i, tiempoSimulacion);
            servidores.add(pista);
        }

        this.bootstraping = new Bootstraping(tiempoSimulacion, servidores);
        this.bootstraping.run();
        this.estadisticaTotal = new EstadisticaTotal(bootstraping);
    }

    public EstadisticaTotal getEstadisticaTotal() {
        return estadisticaTotal;
    }
   public int getTamañoList(){
    return servidores.size();
   }
  
}
