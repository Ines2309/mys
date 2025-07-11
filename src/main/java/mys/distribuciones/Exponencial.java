package mys.distribuciones;

import mys.utilidades.Distribucion;

public class Exponencial extends Distribucion {
    public double lambda;
    
    public Exponencial(double mu) { 
        super();
        this.mediaDistribucion = mu;
        this.lambda = 1/mu;
        this.desviacionDistribucion = mu;
    }

    @Override
    public double getProbabilidad(double tiempo) {
        return 1 - Math.exp(-lambda*tiempo);
        
    }

    @Override
    public double getTiempo(double probabilidad) {
        return (-1/lambda)*(Math.log(1-probabilidad));
    }
     
    
     public Distribucion comprobarHora(double clockactual){

        double clock =clockactual;
        while(clock>=1440){
            clock=clock-1440;
        }
        if((clock>=540 && clock<=780 )||(clock>=1200 && clock<=1380)){
            lambda=1.0/9;
        }else{
            lambda=1.0/15;
        }
        return this;
    }
      

    
}
