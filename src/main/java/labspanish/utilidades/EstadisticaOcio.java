package labspanish.utilidades;

public class EstadisticaOcio extends Estadistica{
    private double totalOcio;
    private double maxOcio;
    private double minOcio;
    
    public EstadisticaOcio(double tiempodeSimulacion){
        super(tiempodeSimulacion);
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
        sb.append("+Tiempo de ocio: \n+    Total: " + totalOcio + "\n");
        sb.append("+    Media: " + this.calcularMedia(totalOcio, this.getCantArribos()) + "\n");
        sb.append("+    Maximo: " + maxOcio + "\n");
        sb.append("+    Minimo: " + minOcio + "\n");
        sb.append("+    Porcentaje del total: " + this.calcularPorcentaje(totalOcio,this.getTiempoDeSimulacion()) + "%\n");
        sb.append("+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+\n");
        return sb.toString();
    }
}
