package labspanish.motorlab;


import java.util.List;

import labspanish.Entidad;
import labspanish.utilidades.DistribucionArribo;
import labspanish.utilidades.DistribucionSalida;
import labspanish.utilidades.Mysqueue;
import labspanish.utilidades.Politica;
import labspanish.utilidades.RandomMath;
import labspanish.motorlab.Servidor;

public class Arribo extends Evento {

    private DistribucionArribo distribucion = new DistribucionArribo();  
    private DistribucionSalida distribucionSalida = new DistribucionSalida();


    public Arribo(Entidad entidad, float clock) {
        super(entidad, clock, 1.0);
    }


  @Override
    public void planificar(RandomMath ramdom, FutureEventList fel, List<Servidor> servidores, Politica politica) {

        Servidor servidor= politica.getServidor(); //Me devuelve un servidor desocupado segun la politica

        if(servidor != null){ //Me devuelve un servidor desocupado
            servidor.setBusy(true);  
              
            Salida planDesalida = new Salida(this.getEntidad(),this.getClock()+distribucionSalida.getEvento(ramdom.tirarRandom()),servidor);
            fel.insertar(planDesalida);

        }else{
            Entidad entidad = this.getEntidad();
            entidad.setClockArribo(this.getClock());
            fel.ponerEnCola(entidad);
        }
        //Planifico el siguiente arrivo
        Entidad e = new Entidad(this.getEntidad().getIdentificador()+1);
        Arribo a = new Arribo(e, this.getClock()+distribucion.getEvento(ramdom.tirarRandom()));
        fel.insertar(a);
    }
      

    
    

    
    
}
