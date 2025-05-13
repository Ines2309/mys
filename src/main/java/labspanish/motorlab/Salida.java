package labspanish.motorlab;

import java.util.ArrayList;

import labspanish.Entidad;
import labspanish.distributions.Normal;
import labspanish.distributions.Uniforme;
import labspanish.utilidades.EstadisticaEspera;
import labspanish.utilidades.Politica;
import labspanish.utilidades.RandomMath;

public class Salida extends Evento {

    private Uniforme distribucionUniforme = new Uniforme(10, 25);
    private Servidor servidor;

    public Salida(Entidad entidad, double clock, Servidor servidor) {
        super(entidad, clock, 0.0);
        this.servidor = servidor;
    }

    @Override
    public void planificar(RandomMath ramdom, FutureEventList fel, Politica politica, EstadisticaEspera estadisticaEspera) {

        if (servidor.getFila().isEmpty()) {  //no hay fila
            this.servidor.setBusy(false);

        } else {                                   //hay fila
            Entidad entidad = servidor.extraerCola();
            Salida salida = new Salida(entidad, getClock() + distribucionUniforme.getTiempo(ramdom.tirarRandom()), this.servidor);
            fel.insertar(salida);
            this.servidor.setBusy(true);

            //calculo el tipo de espera de la entidad que acaba de salir
            double espera = this.getClock() - entidad.getClockArribo(); //calculo el tiempo de espera
            estadisticaEspera.sumarAlTotalEspera(espera);

            //estadisticaEspera.setTotalEspera(estadisticaEspera.getTotalEspera()+espera);
            estadisticaEspera.aumentarArribos();
            //estadisticaEspera.setCantArribos(estadisticaEspera.getCantArribos()+1);
            if (espera < estadisticaEspera.getMinEspera() && espera != 0.0) {
                estadisticaEspera.setMinEspera(espera);
            } else if (estadisticaEspera.getMinEspera() == 0.0) {
                estadisticaEspera.setMinEspera(espera);
            }
            if (espera > estadisticaEspera.getMaxEspera()) {
                estadisticaEspera.setMaxEspera(espera);
            }

        }

        this.aplicarEfectoSecundario(ramdom);

        //calculo el tiempo en sistema
        double tiempoEnSistema = this.getClock() - this.getEntidad().getClockArribo();
        estadisticaEspera.setCantTotalSistema(estadisticaEspera.getCantTotalSistema() + tiempoEnSistema);
        if (tiempoEnSistema < estadisticaEspera.getCanMinSistemas() || estadisticaEspera.getCanMinSistemas() == 0) {
            estadisticaEspera.setCanMinSistemas(tiempoEnSistema);
        }
        if (tiempoEnSistema > estadisticaEspera.getCanMaxSistemas()) {
            estadisticaEspera.setCanMaxSistemas(tiempoEnSistema);
        }

        this.servidor.setClockSalida(this.getClock()); //guarda ultima salida
        politica.setEstadoServiodor(this.servidor);
        estadisticaEspera.setCantAterrizaje(estadisticaEspera.getCantAterrizaje() + 1);

    }

    @Override
    public void aplicarEfectoSecundario(RandomMath ramdom) {

        //Implementar convolucion con media y desviacion
        double mediaConvolucion = 5;
        double desviacionConvolucion = 1;

        ArrayList variables = new ArrayList<>();

        for (int i = 0; i < 20; i++) {
            variables.add(distribucionUniforme.getTiempo(ramdom.tirarRandom()));
        }
        
        Normal normal = new Normal(5, 1, distribucionUniforme);
        
        servidor.setDesgaste(normal.getTiempoConvolucion(variables, mediaConvolucion, desviacionConvolucion));

        // normal (desgaste)
        //servidor.setDesgaste();
    }

    //controlar servidor 
}
