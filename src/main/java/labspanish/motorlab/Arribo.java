package labspanish.motorlab;


import labspanish.Entidad;
import labspanish.utilidades.DistribucionArribo;
import labspanish.utilidades.RandomMath;

public class Arribo extends Evento{

    private DistribucionArribo distribucion = new DistribucionArribo();  

    public Arribo(Entidad entidad, float clock, FutureEventList fel) {
        super(entidad, clock, 1.0,fel);
    }
      

    @Override
    public void planificar(RandomMath ramdom) {

        Servidor servidor = this.getFel().pedirServidor();
        if(servidor != null){ //Me devuelve un servidor desocupado
                Salida s = new Salida(getEntidad(), this.getClock()+distribucion.getEvento(ramdom.tirarRandom()), this.getFel());
                this.getFel().insertar(s);
                servidor.setBusy(true);
        } else{ //No hay servidores disponibles
            this.getFel().ponerEnCola(this.getEntidad()); //Pongo la entidad en la cola del servidor
        }
        //Planifico el siguiente arribo
        Entidad e = new Entidad(this.getEntidad().getIdentificador()+1);
        Arribo a = new Arribo(e, this.getClock()+distribucion.getEvento(ramdom.tirarRandom()), this.getFel());
        this.getFel().insertar(a);
    }
    
    
    

    
    
}
