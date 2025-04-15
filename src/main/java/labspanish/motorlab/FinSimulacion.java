/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package labspanish.motorlab;

import java.util.List;
import javax.swing.text.html.parser.Entity;
import labspanish.utilidades.Distribucion;
import labspanish.utilidades.Randomizer;

/**
 *
 * @author santi
 */
public class FinSimulacion extends Evento{

    public FinSimulacion(Entity entidad, float clock, double ordenDeEstado, Distribucion distribucion) {
        super(entidad, clock, ordenDeEstado, distribucion);
    }
    
    @Override
    public void planificar(FutureEventList fel, Randomizer ramdom, List<Servidor> Servidores) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
}
