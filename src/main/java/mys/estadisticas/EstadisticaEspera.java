package mys.estadisticas;

import mys.utilidades.Estadisticas;

public class EstadisticaEspera extends Estadisticas {
    private double totalEspera;
    private double maxEspera;
    private double minEspera;
    private double canMaxSistemas, canMinSistemas, cantTotalSistema;

    public EstadisticaEspera(double tiempoDeSimulacion){
        super(tiempoDeSimulacion);
        totalEspera = 0.0;
        maxEspera = 0.0;
        minEspera = 0.0;
        canMaxSistemas = 0.0;
        canMinSistemas =0.0;
        cantTotalSistema =0.0;
    }

    public void setMaxEspera(double maxEspera) {
        this.maxEspera = maxEspera;
    }

    public void setMinEspera(double minEspera) {
        this.minEspera = minEspera;
    }

    public void setTotalEspera(double totalEspera) {
        this.totalEspera = totalEspera;
    }

    public double getMaxEspera() {
        return maxEspera;
    }

    public double getMinEspera() {
        return minEspera;
    }

    public double getTotalEspera() {
        return totalEspera;
    }

    public void setCanMaxSistemas(double canMaxSistemas) {
        this.canMaxSistemas = canMaxSistemas;
    }
    public void setCanMinSistemas(double canMinSistemas) {
        this.canMinSistemas = canMinSistemas;
    }
    public void setCantTotalSistema(double cantTotalSistema) {
        this.cantTotalSistema = cantTotalSistema;
    }
    public double getCanMaxSistemas() {
        return canMaxSistemas;
    }
    public double getCanMinSistemas() {
        return canMinSistemas;
    }
    public double getCantTotalSistema() {
        return cantTotalSistema;
    }
    
    public void sumarAlTotalEspera(double espera) {
        totalEspera += espera;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("+-+-+-+-+-+-+-+-+-++-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+\n");
        sb.append("+ Total de Aeronaves que arribaron: " + this.getCantArribos() + "\n");
        sb.append("+ Total de Aeronaves que aterrizaron: " + this.getCantAterrizaje() +  "\n");
        sb.append("+------+\n");
        sb.append("Media de tiempo en sistema: "+ String.format("%.2f", this.calcularMedia(cantTotalSistema, this.getCantArribos())) + "\n");
        sb.append("Maximo de tiempo en sistema: " + String.format("%.2f",canMaxSistemas) + "\n");
        sb.append("Minimo de tiempo en sistema: " + String.format("%.2f",canMinSistemas) + "\n");
        sb.append("+------+\n");
        sb.append("+ Tiempo de espera: \n+    Total: " + String.format("%.2f",totalEspera )+ "\n");
        sb.append("+    Media: " + String.format("%.2f",this.calcularMedia(totalEspera, this.getCantArribos())) + "\n");
        sb.append("+    Maximo: " + String.format("%.2f",maxEspera) + "\n");
        sb.append("+    Minimo: " + String.format("%.2f", minEspera) + "\n");
        sb.append("+    Porcentaje del total: " +String.format("%.2f", this.calcularPorcentaje(totalEspera,this.getTiempoDeSimulacion()) )+ "%\n");
        sb.append("+------+\n");
        return sb.toString();
    }

    
}
