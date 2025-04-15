package labspanish.motorlab;

import java.util.List;

import labspanish.utilidades.Randomizer;
import labspanish.motorlab.Servidor;

public class Boostraping {
    private double tiempoDeSimulacion; 
    private Randomizer random; 
    private FutureEventList fel; 
    private List <Servidor> servidores;

    public Boostraping(double tiempoDeSimulacion, Randomizer random, FutureEventList fel, List<Servidor> servidores) {
        this.tiempoDeSimulacion = tiempoDeSimulacion;
        this.random = random;
        this.fel = fel;
        this.servidores = servidores;
    } 
    
    public void run(){
        Evento evento; 
        double clock =0; 
        while(clock< tiempoDeSimulacion){
            //evento= this.fel.inminete(); 
            //clock= evento.getclock; 
            //evento.planificador(this.fel, ramdom, servidores)
        



        }

    }

    public Servidor buscarServidor() { //por la politica
        for (Servidor s: servidores) {
            if(!s.isBusy()) {
                return s;
            }
        }

        return null;
    }
    

}
