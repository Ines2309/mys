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
        boolean ejecutaArribo;
        int cantidadArribos=0;
        int cantidadAterrizaje=0;
        
        while(clock < tiempoDeSimulacion){  // no esta arribando
            System.out.println(fel.toString());
            evento = this.fel.inminente();
            ejecutaArribo=evento.planificar(this.random, this.fel, this.politica,this.espera);
            //actualizo estadisticas por si acaso tienen valores distintos

            if(ejecutaArribo){
                cantidadArribos+=1;
            }
            if(evento.getOrdenDeEstado()== 0.0){
                cantidadAterrizaje+=1;
            }

            evento.aplicarEfectoSecundario(random);
            
            clock = evento.getClock();
        }
        
        //Guarda cantidades
        espera.setCantArribos(cantidadArribos);
        espera.setCantAterrizaje(cantidadAterrizaje);

        for (Servidor  servidor : politica.getServidores()) {

                nuevaEstadisticaOcio = servidor.getEstadisticaOcio();
                nuevaEstadisticaOcio.setCantArribos(cantidadArribos);
                nuevaEstadisticaOcio.setCantAterrizaje(cantidadAterrizaje);
                servidor.setEstadisticaOcio(nuevaEstadisticaOcio);

            }

    }

    public List<Servidor> obtenerServidores() {

        return politica.getServidores();
    }
    
    public EstadisticaEspera getEspera(){
        return espera;
    }
    
    public Politica getPolitica() {
        return politica;
    }

    public FutureEventList getFel() {
        return fel;
    }
}


