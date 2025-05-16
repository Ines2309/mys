package labspanish.distributions;

import java.util.List;

import labspanish.utilidades.Distribucion;

public class Normal extends Distribucion {

    private double mediaY;
    private double desviacionY;
    private Uniforme varUniforme; //porque ya conocemos su mediax y desviacionx

    public Normal(double media, double desviacion, double a, double b) {
        this.mediaY = media;
        this.desviacionY = desviacion;
        this.varUniforme = new Uniforme(a, b);
    }
    
    public Normal(double media, double desviacion, Uniforme uniforme) {
        this.mediaY = media;
        this.desviacionY = desviacion;
        this.varUniforme = uniforme;
    }

    @Override
    public double getProbabilidad(double Evento) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public double getTiempo(double acumulativo) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public double getTiempoConvolucion(List<Double> variables, double mediaX, double desviacionX) {
        double mediaZ = variables.size() * mediaX;
        double desviacionZ = variables.size() * Math.pow(desviacionX, 2);

        double suma = 0.0;
        for (double valor : variables) {
            suma += valor;
        }
        double normalEstandar = (suma - mediaZ) / Math.sqrt(desviacionZ);

        return (normalEstandar * Math.sqrt(desviacionY)) + mediaY; 
    }

    public double getMediaY() {
        return mediaY;
    }

    public void setMediaY(double mediaY) {
        this.mediaY = mediaY;
    }

    public double getdesviacionY() {
        return desviacionY;
    }

    public void setdesviacionY(double desviacionY) {
        this.desviacionY = desviacionY;
    }

    public Uniforme getVarUniforme() {
        return varUniforme;
    }

    public void setVarUniforme(Uniforme varUniforme) {
        this.varUniforme = varUniforme;
    }

}
