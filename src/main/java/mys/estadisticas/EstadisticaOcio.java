package mys.estadisticas;

import mys.utilidades.Estadisticas;

public class EstadisticaOcio extends Estadisticas {
      private double totalOcio;
    private double maxOcio;
    private double minOcio;
    
    public EstadisticaOcio(double tiempoDeSimulacion){
        super(tiempoDeSimulacion);
        totalOcio = 0.0;
        maxOcio = 0.0;
        minOcio = 0.0;
    }

    public void setMaxOcio(double maxOcio) {
        this.maxOcio = maxOcio;
    }
    public void setMinOcio(double minOcio) {
        this.minOcio = minOcio;
    }
    public void setTotalOcio(double totalOcio) {
        this.totalOcio = totalOcio;
    }
    public double getMaxOcio() {
        return maxOcio;
    }
    public double getMinOcio() {
        return minOcio;
    }
    public double getTotalOcio() {
        return totalOcio;
    }

    public void sumarAlTotalOcio(double ocio) {
        this.totalOcio += ocio;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("+Tiempo de ocio: \n+    Total: " +String.format("%.2f", totalOcio )+ "\n");
        sb.append("+    Media: " + String.format("%.2f",this.calcularMedia(totalOcio, this.getCantArribos()) )+ "\n");
        sb.append("+    Maximo: " + String.format("%.2f", maxOcio) + "\n");
        sb.append("+    Minimo: " + String.format("%.2f",minOcio )+ "\n");
        sb.append("+    Porcentaje del total: " + String.format("%.2f",this.calcularPorcentaje(totalOcio,this.getTiempoDeSimulacion())) + "%\n");
        sb.append("+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+\n");
        return sb.toString();
    }
    
}
