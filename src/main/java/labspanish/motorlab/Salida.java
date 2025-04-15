package labspanish.motorlab;

import java.util.List;

import javax.swing.text.html.parser.Entity;

import labspanish.utilidades.Distribucion;
import labspanish.utilidades.Ramdomizer;



public class Salida extends Evento {


    public Salida(Entity entidad, float clock, int ordenDeEstado, Distribucion distribucion) {
        super(entidad, clock, ordenDeEstado, distribucion);
    }
    
    @Override
    public void planificar(FutureEventList fel, Ramdomizer ramdom, List<Servidor> Servidores) {
        throw new UnsupportedOperationException("Not supported yet.");
    }
     
    //controlar servidor 
}
