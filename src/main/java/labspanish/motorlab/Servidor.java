package labspanish.motorlab;

import labspanish.Entidad;
import labspanish.utilidades.Mysqueue;

public class Servidor {
    private int id; 
    private boolean busy;
    private Mysqueue queue;
    
    public Servidor(int id, boolean busy, Mysqueue queue) {
        this.id = id;
        this.busy = false;
        this.queue=queue;
    }

    public void ponerencola( Entidad entidad){
      queue.enqueue(entidad);
    }
    public Entidad popEntidad (){

       return queue.dequEntidad();

    }

    public int getId() {
        return id;
    }


    public void setId(int id) {
        this.id = id;
    }


    public boolean isBusy() {
        return this.busy;
    }


    public void setBusy(boolean busy) {
        this.busy = busy;
    }
     
    



    
}
