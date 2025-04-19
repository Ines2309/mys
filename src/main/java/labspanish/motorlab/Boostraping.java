package labspanish.motorlab;

import java.util.List;

import labspanish.Entidad;
import labspanish.utilidades.Politica;
import labspanish.utilidades.RandomMath;

public class Boostraping {
    private double tiempoDeSimulacion; 
    private RandomMath random; 
    private FutureEventList fel; 
    private Politica politica;

    public Boostraping(double tiempoDeSimulacion, RandomMath random, FutureEventList fel, Politica politica) {
        this.tiempoDeSimulacion = tiempoDeSimulacion;
        this.random = random;
        this.fel = fel;
        this.politica = politica;
    } 
    
    
    public void run(){
        Evento evento; 
        double clock =0; 
        
        while(clock< tiempoDeSimulacion){
            //evento= this.fel.inminete(); 
            //clock= evento.getclock; 
            //obtener servidor
            //if(isBusy){
            //entidad=evento.getEntidad;
            //entidad.setClock(Clock)
            //queque.add(entidad)}
            //else{
            //calculaocio }
            //evento.planificador(this.fel, ramdom, servidores)
            ////servidor.setbusy  y  actualizarservidores

        }

    }

    // las politicas se hicieron una nueva clase para luego mejorarl
    
    
    
}


