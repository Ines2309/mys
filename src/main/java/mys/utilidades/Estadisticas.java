package mys.utilidades;

public abstract class Estadisticas {
    private int cantArribos;
    private int cantAterrizaje;
    private double tiempoDeSimulacion;

    public Estadisticas(double tiempoDeSimulacion){
        cantArribos = 0;
        cantAterrizaje = 0; 
        this.tiempoDeSimulacion = tiempoDeSimulacion;
        
    }

    public void setCantArribos(int cantArribos) {
        this.cantArribos = cantArribos;
    }
    public void setCantAterrizaje(int cantSalidas) {
        this.cantAterrizaje = cantSalidas;
    }
    public void setTiempoDeSimulacion(double tiempoDeSimulacion) {
        this.tiempoDeSimulacion = tiempoDeSimulacion;
    }
    public int getCantArribos() {
        return cantArribos;
    }
    public int getCantAterrizaje() {
        return cantAterrizaje;
    }
    public double getTiempoDeSimulacion() {
        return tiempoDeSimulacion;
    }

    public double calcularMedia (double total, int cant){
        return total/cant;
    }

    public double calcularPorcentaje (double total, double tiempoDeSimulacion){
        return (total)*100/tiempoDeSimulacion;
    }

    public void aumentarArribos(){
        this.cantArribos += 1;
    }

    public void aumentarAterrizajes() {
        this.cantAterrizaje += 1;
    }

}
