package mys.utilidades;

import java.util.ArrayList;
import java.util.List;

import mys.engine.Bootstraping;
import mys.engine.Servidor;
import mys.estadisticas.EstadisticaTotal;

public class Ejecucion {
     private List<Servidor> servidores;

    private Bootstraping bootstraping;
    private EstadisticaTotal estadisticaTotal;

    public Ejecucion(double tiempoSimulacion, int cantidadServidores,Distribucion distribucionArribo, Distribucion distribucionSalida) {
        this.servidores = new ArrayList<Servidor>();
        Servidor pista= null;
        MyqueuePriority cola = new MyqueuePriority();
        for (int i = 1; i <= cantidadServidores; i++) {
            pista = new Servidor(i, tiempoSimulacion, cola); //Ahora asigna una misma cola para los 5 servidores
            servidores.add(pista);
        }

        this.bootstraping = new Bootstraping(tiempoSimulacion, servidores,distribucionArribo,distribucionSalida);
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
