package labspanish.distributions;

import labspanish.utilidades.Distribucion;

public class Exponecial extends Distribucion{
    
    public double lambda;
    
    public Exponecial(double mu) {
        
        super();
        this.mediaDistribucion = mu;
        this.lambda = 1/mu;
        this.desviacionDistribucion = 1/Math.pow(1/mu, 2);
    }

    @Override
    public double getProbabilidad(double tiempo) {
        return 1 - Math.exp(-lambda*tiempo);
    }

    @Override
    public double getTiempo(double probabilidad) {
        return (-1/lambda)*(Math.log(1-probabilidad));
    }

    public void comprobarHora(double clockactual){

        double clock =clockactual/60;
        while(clock>24){
            clock=clock-24;
        }
        if((clock>=9 && clock<=13 )||(clock>=20 && clock<23))
        lambda= 1/9;
        else{
            lambda=1/15;
        }
    }
    
}