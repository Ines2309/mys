package labspanish.utilidades;

import java.util.ArrayList;
import java.util.List;

public class ReplicacionDeEjecuciones {
    private List<Ejecucion> ejecuciones;
    
    public ReplicacionDeEjecuciones(List<Ejecucion> ejecuciones) {
        this.ejecuciones = ejecuciones;
    }

    public static Intervalo estimarIntervalos(List<Double> ejecuciones) {

        double media = mediaDeMedias(ejecuciones);
        double s = 0; //preguntar si es varianza o desviacion

        for (double xi : ejecuciones) {
            s += Math.pow(xi - media, 2) /(ejecuciones.size() - 1);
          
        }

        s = Math.sqrt(s);  
         
        return intervaloDeConfianza(media, s, ejecuciones.size());

    }
    
    private static Intervalo intervaloDeConfianza(double media, double s, int n) {  
        double z = 1.96; // valor de z para un nivel de confianza del 95%    
        double error = (z * s) / Math.sqrt(n);
        return new Intervalo(media - error, media + error);
    }

    private static double mediaDeMedias(List<Double> ejecuciones) {
        double suma = 0;
        for (Double ejecucion : ejecuciones) {
            suma += ejecucion;
        }
        return suma / ejecuciones.size();
    }

    private Intervalo estadisticaEsperaMedia() {

     List <Double> resultados= new ArrayList<>(); 
     EstadisticaEspera espera;
     

    /*  for (Ejecucion ejecucion : ejecuciones){
        espera = ejecucion.getEstadisticaTotal().getEspera();
        resultados.add(espera.calcularMedia(espera.getTotalEspera(),espera.getCantArribos()));

     }
     return a;
        
    }
     */


}