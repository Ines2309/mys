package labspanish.utilidades;

public class Estadisticas {
    private double totalOcio;
    private double maxOcio;
    private double minOcio;
    private double totalEspera;
    private double maxEspera;
    private double minEspera;
    private int cantArribos;
    private int cantSalidas;
    private double tiempoDeSimulacion;

    public Estadisticas(){

    }

    public void setCantArribos(int cantArribos) {
        this.cantArribos = cantArribos;
    }

    public void setCantSalidas(int cantSalidas) {
        this.cantSalidas = cantSalidas;
    }

    public void setMaxEspera(double maxEspera) {
        this.maxEspera = maxEspera;
    }

    public void setMaxOcio(double maxOcio) {
        this.maxOcio = maxOcio;
    }

    public void setMinEspera(double minEspera) {
        this.minEspera = minEspera;
    }

    public void setMinOcio(double minOcio) {
        this.minOcio = minOcio;
    }

    public void setTotalEspera(double totalEspera) {
        this.totalEspera = totalEspera;
    }

    public void setTotalOcio(double totalOcio) {
        this.totalOcio = totalOcio;
    }

    public void setTiempoDeSimulacion(double tiempoDeSimulacion) {
        this.tiempoDeSimulacion = tiempoDeSimulacion;
    }

    public int getCantArribos() {
        return cantArribos;
    }

    public int getCantSalidas() {
        return cantSalidas;
    }

    public double getMaxEspera() {
        return maxEspera;
    }

    public double getMaxOcio() {
        return maxOcio;
    }

    public double getMinEspera() {
        return minEspera;
    }

    public double getMinOcio() {
        return minOcio;
    }

    public double getTotalEspera() {
        return totalEspera;
    }

    public double getTotalOcio() {
        return totalOcio;
    }

    public double getTiempoDeSimulacion() {
        return tiempoDeSimulacion;
    }

    public double calcularMedia (double total, int cant){
        return total/cant;
    }

    public double calcularPorcentaje (double total, double tiempoDeSimulacion){
        return (100*total)/tiempoDeSimulacion;
    }


    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("+-+-+-+-+-+-+-+-+-++-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+\n");
        sb.append("+ Total de Aeronaves que arrivaron: " + cantArribos + "\n");
        sb.append("+ Total de Aeronaves que aterrisaron: " + cantSalidas +  "\n");
        sb.append("+ Tiempo de espera: \n  Total: " + totalEspera + "\n");
        sb.append("+    Media: " + this.calcularMedia(totalEspera, cantArribos) + "\n");
        sb.append("+    Maximo: " + maxEspera + "\n");
        sb.append("+    Minimo: " + minEspera + "\n");
        sb.append("+    Porcentaje del total: " + this.calcularPorcentaje(totalEspera,tiempoDeSimulacion) + "%\n");
        sb.append("+Tiempo de ocio: \n  Total: " + totalOcio + "\n");
        sb.append("+    Media: " + this.calcularMedia(totalOcio, cantArribos) + "\n");
        sb.append("+    Maximo: " + maxOcio + "\n");
        sb.append("+    Minimo: " + minOcio + "\n");
        sb.append("+    Porcentaje del total: " + this.calcularPorcentaje(totalOcio,tiempoDeSimulacion) + "%\n");
        sb.append("+-+-+-+-+-+-+-+-+-++-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+\n");
        return sb.toString();
    }
}
