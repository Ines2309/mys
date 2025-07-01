package mys.engine;

import java.util.List;

import mys.estadisticas.EstadisticaEspera;
import mys.estadisticas.EstadisticaOcio;
import mys.mypolitics.Politica;
import mys.numerosaleatorios.RandomMath;
import mys.utilidades.Distribucion;
import mys.utilidades.Mysqueue;

public class Bootstraping {
    private double tiempoDeSimulacion; 
    private RandomMath random; 
    private FutureEventList fel;
    private Politica politica;
    private EstadisticaEspera espera; 
    private Distribucion distribucionArribo;
    private Distribucion distribucionSalida;
    private Mysqueue queue; 

    public Bootstraping(double tiempoDeSimulacion, List<Servidor> servidores, Distribucion arribos, Distribucion salida) {
        this.tiempoDeSimulacion = tiempoDeSimulacion;
        this.random = new RandomMath();
        this.fel = new FutureEventList(arribos, salida);
        this.politica = new Politica(servidores);
        this.espera = new EstadisticaEspera(tiempoDeSimulacion);
        this.distribucionArribo = arribos;
        this.distribucionSalida = salida;
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
         //   System.out.println(fel.toString());
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
