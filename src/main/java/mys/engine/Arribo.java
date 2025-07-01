package mys.engine;


import mys.distribuciones.DistribucionPriority;
import mys.estadisticas.EstadisticaEspera;
import mys.estadisticas.EstadisticaOcio;
import mys.mypolitics.Politica;
import mys.numerosaleatorios.RandomMath;
import mys.utilidades.Distribucion;

public class Arribo extends Evento{
   private Distribucion distrucionSalida;
   private DistribucionPriority distribucionPriority;


    public Arribo(Entida entidad, double clock, Distribucion distribucion, Distribucion distribucionSalida) {
        super(entidad, clock, 1.0, distribucion);
        this.distrucionSalida=distribucionSalida;
        this.distribucionPriority = new DistribucionPriority(); // Inicializo la distribucion de prioridad
    }

       //set estado de servidor lo utilizamos para actualizar la informacion del servidor ya que trabajamos con la copia
  @Override
    public boolean planificar(RandomMath ramdom, FutureEventList fel, Politica politica, EstadisticaEspera estadisticaEspera) {
        //double tiempodeServicio=0; 
       // double tiempoEntreArribos=0;
        Servidor servidor= politica.getServidor(); //Me devuelve un servidor desocupado segun la politica

        Entida entidad = this.getEntidad();
        entidad.setClockArribo(this.getClock());

        if(!servidor.isBusy()){ //Me devuelve un servidor desocupado
            servidor.setBusy(true);  
            Salida planDesalida = new Salida(entidad, distrucionSalida.getTiempo(ramdom.tirarRandom()) + this.getClock(), servidor, distrucionSalida);
            fel.insertar(planDesalida);

            // calcular ocio de este servidor
            EstadisticaOcio estadistica = servidor.getEstadisticaOcio();
            double ocio = this.getClock() - servidor.getClockSalida();
            estadistica.sumarAlTotalOcio(ocio); // Reemplazo el estadistica.setTotalOcio(estadistica.getTotalOcio()+ocio)

            //estadistica.setCantArribos(estadistica.getCantArribos()+1);
            estadistica.aumentarArribos();
            if(ocio < estadistica.getMinOcio() && ocio!=0.0){  //Modularizar a Estadistica
                estadistica.setMinOcio(ocio);
            }else if(estadistica.getMinOcio()==0.0){
                
                estadistica.setMinOcio(ocio);
            }
            if(ocio > estadistica.getMaxOcio()){
                estadistica.setMaxOcio(ocio);
            }
            servidor.setEstadisticaOcio(estadistica);
            //actualizo el tiempo de salida del servidor


        }else{
            
            servidor.ponerEnCola(entidad);
        }
        politica.setEstadoServiodor(servidor); //servidor es una copia, no una refersncia
        //Planifico el siguiente arrivo
        
        Distribucion distribucionArribo = getDistribucion().comprobarHora(this.getClock()); //this.clock esta en horas
        setDistribucion(distribucionArribo);
        Entida evento = new Entida(this.getEntidad().getIdentificador() + 1, distribucionPriority.getTiempo(ramdom.tirarRandom()));
        
        Arribo arribo = new Arribo(evento, this.getClock()+getDistribucion().getTiempo(ramdom.tirarRandom()), getDistribucion(), distrucionSalida);
        fel.insertar(arribo);
        
        return true;
    }

    @Override
    public void aplicarEfectoSecundario(RandomMath ramdom) {
        //no se aplica ningun efecto secundario, ya que es el arribo
    }
    
}
