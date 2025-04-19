package labspanish.motorlab;


import java.util.List;

import labspanish.Entidad;
import labspanish.utilidades.DistribucionSalida;
import labspanish.utilidades.Mysqueue;
import labspanish.utilidades.Politica;
import labspanish.utilidades.RandomMath;



public class Salida extends Evento {

    DistribucionSalida distribucion = new DistribucionSalida();
    Servidor servidor;

    public Salida(Entidad entidad, float clock ,Servidor servidor) {
        super(entidad, clock, 0.0);
        this.servidor=servidor;
    }

    @Override
    public void planificar(RandomMath ramdom, FutureEventList fel, List<Servidor> serv, Politica pol) {
        if(fel.getFila().isEmpty()){             //no hay fila
            this.servidor.setBusy(false);
        }else{                                   //hay fila
            Entidad entidad = fel.extraerCola();
            Salida salida = new Salida(entidad, getClock()+distribucion.getEvento(ramdom.tirarRandom()), this.servidor);
            fel.insertar(salida);
            this.servidor.setBusy(true);
            /*double espera = this.
            if(this.getClock()-entidad.getClockArribo()>)

            */
        }
    }
     
    //controlar servidor 
}
