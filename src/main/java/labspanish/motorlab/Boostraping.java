package labspanish.motorlab;

import java.util.List;

import com.sun.security.ntlm.Server;

import labspanish.utilidades.Ramdomizer;

public class Boostraping {
    private double tiempoDeSimulacion; 
    private Ramdomizer ramdom; 
    private FutureEventList fel; 
    private List <Server> servidores;

    public Boostraping(double tiempoDeSimulacion, Ramdomizer ramdom, FutureEventList fel, List<Server> servidores) {
        this.tiempoDeSimulacion = tiempoDeSimulacion;
        this.ramdom = ramdom;
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
    

}
