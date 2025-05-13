package labspanish.motorlab;



import labspanish.Entidad;
import labspanish.distributions.Exponecial;
import labspanish.distributions.Uniforme;
import labspanish.utilidades.EstadisticaEspera;
import labspanish.utilidades.EstadisticaOcio;
import labspanish.utilidades.Politica;
import labspanish.utilidades.RandomMath;

public class Arribo extends Evento {

    private Exponecial distribucion;  
    private Uniforme distribucionSalida;


    public Arribo(Entidad entidad, double clock) {
        super(entidad, clock, 1.0);
        distribucion = new Exponecial(15);
        distribucionSalida = new Uniforme(10, 25);
    }


  @Override
    public void planificar(RandomMath ramdom, FutureEventList fel, Politica politica, EstadisticaEspera estadisticaEspera) {
        //double tiempodeServicio=0; 
       // double tiempoEntreArribos=0;
        Servidor servidor= politica.getServidor(); //Me devuelve un servidor desocupado segun la politica

        Entidad entidad = this.getEntidad();
        entidad.setClockArribo(this.getClock());

        if(!servidor.isBusy()){ //Me devuelve un servidor desocupado
            servidor.setBusy(true);  
            Salida planDesalida = new Salida(entidad,this.getClock()+distribucionSalida.getTiempo(ramdom.tirarRandom()),servidor);
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
            
            politica.setEstadoServiodor(servidor);

        }else{
            
            servidor.ponerEnCola(entidad);
        }
        //Planifico el siguiente arrivo
        distribucion.comprobarHora(getClock());
        Entidad evento = new Entidad(this.getEntidad().getIdentificador()+1);
        Arribo arribo = new Arribo(evento, this.getClock()+distribucion.getTiempo(ramdom.tirarRandom()));
        fel.insertar(arribo);
        
    }

    @Override
    public void aplicarEfectoSecundario(RandomMath ramdom) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
      

    
    

    
    
}
