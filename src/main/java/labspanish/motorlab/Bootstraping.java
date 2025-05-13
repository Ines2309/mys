package labspanish.motorlab;

import java.util.List;

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
        double clock = 0;
        EstadisticaOcio nuevaEstadisticaOcio;
        
        while(clock < tiempoDeSimulacion){  // 
             
            System.out.println(fel.toString());
            evento = this.fel.inminente();
            evento.planificar(this.random, this.fel, this.politica,this.espera);
            //actualizo estadisticas por si acaso tienen valores distintos
            for (Servidor  servidor : politica.getServidores()) {
                if(servidor.getEstadisticaOcio().getCantArribos() > espera.getCantArribos()){
                    espera.setCantArribos(servidor.getEstadisticaOcio().getCantArribos());
                }else{
                    nuevaEstadisticaOcio = servidor.getEstadisticaOcio();
                    nuevaEstadisticaOcio.setCantArribos(espera.getCantArribos());
                    servidor.setEstadisticaOcio(nuevaEstadisticaOcio);
                    politica.setEstadoServiodor(servidor);
                }

                if(servidor.getEstadisticaOcio().getCantAterrizaje() > espera.getCantAterrizaje()){
                    espera.setCantAterrizaje(servidor.getEstadisticaOcio().getCantAterrizaje());
                }else{
                    nuevaEstadisticaOcio = servidor.getEstadisticaOcio();
                    nuevaEstadisticaOcio.setCantAterrizaje(espera.getCantAterrizaje());
                    servidor.setEstadisticaOcio(nuevaEstadisticaOcio);
                    politica.setEstadoServiodor(servidor);
                }

            }
            clock = evento.getClock();
            

        }

    }

    public List<Servidor> obtenerServidores() {

        return politica.getServidores();
    }
    
    public EstadisticaEspera getEspera() {
        return espera;
    }
    
    
}


