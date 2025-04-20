package labspanish.utilidades;

public abstract class Estadistica {
    private int cantArribos;
    private int cantAterrizaje;
    private double tiempoDeSimulacion;

    public Estadistica(){
        cantArribos = 0;
        cantAterrizaje = 0;     
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
        return (100*total)/tiempoDeSimulacion;
    }

    public void aumentarArribos(){
        this.cantArribos += 1;
    }

    public void aumentarAterrizajes() {
        this.cantAterrizaje += 1;
    }



}
