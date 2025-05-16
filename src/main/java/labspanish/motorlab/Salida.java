package labspanish.motorlab;


import java.util.List;

import labspanish.Entidad;
import labspanish.utilidades.DistribucionSalida;
import labspanish.utilidades.EstadisticaEspera;
import labspanish.utilidades.Mysqueue;
import labspanish.utilidades.Politica;
import labspanish.utilidades.RandomMath;



public class Salida extends Evento {

    DistribucionSalida distribucion = new DistribucionSalida();
    Servidor servidor;

    public Salida(Entidad entidad, double clock ,Servidor servidor) {
        super(entidad, clock, 0.0);
        this.servidor=servidor;
    }

    @Override
    public void planificar(RandomMath ramdom, FutureEventList fel, Politica politica, EstadisticaEspera estadisticaEspera) {
        
        if(fel.getFila().isEmpty()){             //no hay fila
            this.servidor.setBusy(false);
        
        }else{                                   //hay fila
            Entidad entidad = fel.extraerCola();
            Salida salida = new Salida(entidad, getClock()+distribucion.getEvento(ramdom.tirarRandom()), this.servidor);
            fel.insertar(salida);
            this.servidor.setBusy(true);
            
            //calculo el tipo de espera de la entidad que acaba de salir
            double espera = this.getClock() - entidad.getClockArribo(); //calculo el tiempo de espera
            estadisticaEspera.sumarAlTotalEspera(espera);
            
            //estadisticaEspera.setTotalEspera(estadisticaEspera.getTotalEspera()+espera);
            estadisticaEspera.aumentarArribos();
            //estadisticaEspera.setCantArribos(estadisticaEspera.getCantArribos()+1);
            if(espera < estadisticaEspera.getMinEspera() && espera!=0.0){
                estadisticaEspera.setMinEspera(espera);
            }else if(estadisticaEspera.getMinEspera() == 0.0){
                estadisticaEspera.setMinEspera(espera);
            }
            if(espera > estadisticaEspera.getMaxEspera()){
                estadisticaEspera.setMaxEspera(espera);
            }

        }
        //calculo el tiempo en sistema
        double tiempoEnSistema = this.getClock() - this.getEntidad().getClockArribo();
        estadisticaEspera.setCantTotalSistema(estadisticaEspera.getCantTotalSistema()+tiempoEnSistema);
        if(tiempoEnSistema < estadisticaEspera.getCanMinSistemas() || estadisticaEspera.getCanMinSistemas() == 0){
            estadisticaEspera.setCanMinSistemas(tiempoEnSistema);
        }
        if(tiempoEnSistema > estadisticaEspera.getCanMaxSistemas()){
            estadisticaEspera.setCanMaxSistemas(tiempoEnSistema);
        }

        this.servidor.setClockSalida(this.getClock()); //guarda ultima salida
        politica.setEstadoServiodor(this.servidor);
        estadisticaEspera.setCantAterrizaje(estadisticaEspera.getCantAterrizaje()+1);

    }
     
    //controlar servidor 
}
