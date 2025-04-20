package labspanish.motorlab;


import java.util.List;

import labspanish.Entidad;
import labspanish.utilidades.DistribucionArribo;
import labspanish.utilidades.DistribucionSalida;
import labspanish.utilidades.EstadisticaEspera;
import labspanish.utilidades.EstadisticaOcio;
import labspanish.utilidades.Mysqueue;
import labspanish.utilidades.Politica;
import labspanish.utilidades.RandomMath;
import labspanish.motorlab.Servidor;

public class Arribo extends Evento {

    private DistribucionArribo distribucion = new DistribucionArribo();  
    private DistribucionSalida distribucionSalida = new DistribucionSalida();


    public Arribo(Entidad entidad, double clock) {
        super(entidad, clock, 1.0);
    }


  @Override
    public void planificar(RandomMath ramdom, FutureEventList fel, Politica politica, EstadisticaEspera estadisticaEspera) {
        double tiempodeServicio=0; 
        double tiempoEntreArribos=0;
        Servidor servidor= politica.getServidor(); //Me devuelve un servidor desocupado segun la politica

        Entidad entidad = this.getEntidad();
        entidad.setClockArribo(this.getClock());

        if(servidor != null){ //Me devuelve un servidor desocupado
            servidor.setBusy(true);  
            Salida planDesalida = new Salida(entidad,this.getClock()+distribucionSalida.getEvento(ramdom.tirarRandom()),servidor);
            fel.insertar(planDesalida);

            // calcular ocio de este servidor
            EstadisticaOcio estadistica = servidor.getEstadisticaOcio();
            double ocio = this.getClock() - servidor.getClockSalida();
            estadistica.sumarAlTotalOcio(ocio); // Reemplazo el estadistica.setTotalOcio(estadistica.getTotalOcio()+ocio)

            //estadistica.setCantArribos(estadistica.getCantArribos()+1);
            estadistica.aumentarArribos();
            if(ocio < estadistica.getMinOcio() && ocio!=0.0){
                estadistica.setMinOcio(ocio);
            }else if(estadistica.getMinOcio()==0.0){
                
                estadistica.setMinOcio(ocio);
            }
            if(ocio > estadistica.getMaxOcio()){
                estadistica.setMaxOcio(ocio);
            }
            
            politica.setEstadoServiodor(servidor);

        }else{
            fel.ponerEnCola(entidad);
        }
        //Planifico el siguiente arrivo
        Entidad evento = new Entidad(this.getEntidad().getIdentificador()+1);
        Arribo arribo = new Arribo(evento, this.getClock()+distribucion.getEvento(ramdom.tirarRandom()));
        fel.insertar(arribo);
        
    }
      

    
    

    
    
}
