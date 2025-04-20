package labspanish.motorlab;

import java.util.ArrayList;
import java.util.List;

import labspanish.Entidad;
import labspanish.utilidades.EstadisticaEspera;
import labspanish.utilidades.EstadisticaOcio;
import labspanish.utilidades.Politica;
import labspanish.utilidades.RandomMath;

public class Bootstraping {
    private double tiempoDeSimulacion; 
    private RandomMath random; 
    private FutureEventList fel; 
    private Politica politica;
    private EstadisticaEspera espera;

    public Bootstraping(double tiempoDeSimulacion, RandomMath random, FutureEventList fel,
     Politica politica, EstadisticaEspera espera) {
        this.tiempoDeSimulacion = tiempoDeSimulacion;
        this.random = random;
        this.fel = fel;
        this.politica = politica;
        this.espera = espera;
    } 
    

    public void run(){
        
        this.fel.inicializar(tiempoDeSimulacion);
        Evento evento; 
        double clock =0;
        
        while(clock < tiempoDeSimulacion){  // 
             
            evento = this.fel.inminente();
            evento.planificar(this.random, this.fel, this.politica,this.espera);
            //actualizo estadisticas

        }

    }

    public EstadisticaOcio obtenerEstadisticasDeOcio() {
        
        return politica.getServidor().getEstadisticaOcio();
    }

    // las politicas se hicieron una nueva clase para luego mejorarl
    
    
    
}


