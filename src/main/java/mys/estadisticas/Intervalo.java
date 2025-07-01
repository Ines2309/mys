package mys.estadisticas;

public class Intervalo {
    
     private double inicio;
    private double fin;
    
    public Intervalo(double inicio, double fin) {
        this.inicio = inicio;
        this.fin = fin;
    }
    
    public double getInicio() {
        return inicio;
    }
    
    public double getFin() {
        return fin;
    }
    
    public boolean contiene(double valor) {
        return valor >= inicio && valor <= fin;
    }
    public String mediaIntervalo() {
        return ("Media:" + String.format("%.2f",((inicio + fin) / 2 )) + "\n");
    }
    
    @Override
    public String toString() {
        return "[" + String.format("%.2f", inicio) + " , " + String.format("%.2f", fin) + "]";
    }

}
