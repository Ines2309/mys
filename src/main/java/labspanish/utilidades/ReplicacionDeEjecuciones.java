package labspanish.utilidades;

import java.util.ArrayList;
import java.util.List;



public class ReplicacionDeEjecuciones {
    private List<Ejecucion> ejecuciones;
    
    public ReplicacionDeEjecuciones(List<Ejecucion> ejecuciones) {
        this.ejecuciones = ejecuciones;
    }

    public int getTamaño(){
         return ejecuciones.get(0).getTamañoList();
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
    
    public static Intervalo intervaloDeConfianza(double media, double s, int n) {  
        double z = 1.96; // valor de z para un nivel de confianza del 95%    
        double error = (z * s) / Math.sqrt(n);
        return new Intervalo(media - error, media + error);
    }

    public static double mediaDeMedias(List<Double> ejecuciones) {
        double suma = 0;
        for (Double ejecucion : ejecuciones) {
            suma += ejecucion;
        }
        return suma / ejecuciones.size();
    }

    public Intervalo estadisticaEsperaMedia() {  //aca lo que quiero hacer es guardar la media de cada ejecucion y luego calcular el intervalo de confianza
                                                    //para eso tengo que recorrer la lista de ejecuciones y guardar la media de cada una
                                                     //en una lista y luego calcular el intervalo de confianza
        List<Double> resultados = new ArrayList<>();
        EstadisticaEspera espera;

      for (Ejecucion ejecucion : ejecuciones){
        espera = ejecucion.getEstadisticaTotal().getEspera();
        resultados.add(espera.calcularMedia(espera.getTotalEspera(),espera.getCantArribos()));

     }
        return estimarIntervalos(resultados);
        
    }
    public Intervalo estadisticaOsciomedia (int i){
        List<Double> resultados = new ArrayList<>();
        EstadisticaOcio ocio;
    
      for (Ejecucion ejecucion : ejecuciones) {
         
            ocio = ejecucion.getEstadisticaTotal().getOcio().get(i);

            resultados.add(ocio.calcularMedia(ocio.getTotalOcio(), ocio.getCantArribos()));
        
        }
      return estimarIntervalos(resultados);
    }
     
    public Intervalo estadisticaDesgasteMedia(int i) {
        List<Double> resultados = new ArrayList<>();
        
        for (Ejecucion ejecucion : ejecuciones) {
            double desgaste = ejecucion.getEstadisticaTotal().getListaDesgaste().get(i);
            resultados.add(desgaste);
        }
        
        return estimarIntervalos(resultados);
    }

    public Intervalo estadisticaMaxFila() {
        List<Double> maxFilas = new ArrayList<>();
        
        for (Ejecucion ejecucion : ejecuciones) {
            maxFilas.add(ejecucion.getEstadisticaTotal().getMaxFila()*1.0);
        }
        
        return estimarIntervalos(maxFilas);
    }

    public Intervalo estadisticaMinFila() {
        List<Double> minFilas = new ArrayList<>();
        
        for (Ejecucion ejecucion : ejecuciones) {
            minFilas.add(ejecucion.getEstadisticaTotal().getMinFila()*1.0);
        }
        
        return estimarIntervalos(minFilas);
    }
    public Intervalo estadisticaEsperaMax(){
        List<Double> maxEspera = new ArrayList<>();
        
        for (Ejecucion ejecucion : ejecuciones) {
            maxEspera.add(ejecucion.getEstadisticaTotal().getEspera().getMaxEspera());
        }
        
        return estimarIntervalos(maxEspera);
    }

    public Intervalo estadisticaEsperaMin() {
        List<Double> minEspera = new ArrayList<>();
        
        for (Ejecucion ejecucion : ejecuciones) {
            minEspera.add(ejecucion.getEstadisticaTotal().getEspera().getMinEspera());
        }
        
        return estimarIntervalos(minEspera);
    }

    public Intervalo estadisticaOcioMax(int i) {
        List<Double> maxOcio = new ArrayList<>();
        
        for (Ejecucion ejecucion : ejecuciones) {
            maxOcio.add(ejecucion.getEstadisticaTotal().getOcio().get(i).getMaxOcio());
        }
        
        return estimarIntervalos(maxOcio);
    }

    public Intervalo estadisticaOcioMin(int i) {
        List<Double> minOcio = new ArrayList<>();
        
        for (Ejecucion ejecucion : ejecuciones) {
            minOcio.add(ejecucion.getEstadisticaTotal().getOcio().get(i).getMinOcio());
        }
        
        return estimarIntervalos(minOcio);
    }

    public Intervalo estadisticaOcioTotal(int i) {
        List<Double> totalOcio = new ArrayList<>();
        
        for (Ejecucion ejecucion : ejecuciones) {
            totalOcio.add(ejecucion.getEstadisticaTotal().getOcio().get(i).getTotalOcio());
        }
        
        return estimarIntervalos(totalOcio);
    }
     
    public Intervalo estadisticaEsperaTotal() {
        List<Double> totalEspera = new ArrayList<>();
        
        for (Ejecucion ejecucion : ejecuciones) {
            totalEspera.add(ejecucion.getEstadisticaTotal().getEspera().getTotalEspera());
        }
        
        return estimarIntervalos(totalEspera);
    }


}