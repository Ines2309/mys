package mys.distribuciones;

import mys.utilidades.Distribucion;

public class Uniforme extends Distribucion {
    public double a;
    public double b;

    public Uniforme(double a, double b) {
        super();
        this.a = a;
        this.b = b;
        this.mediaDistribucion = (a+b)/2;
        this.desviacionDistribucion = Math.pow(b-a, 2)/12;
    }
    
    

    @Override
    public double getProbabilidad(double tiempo) {
        if(tiempo<a){
        return 0;
        }else 
            if(tiempo>=a && tiempo<b){
            return (tiempo-a)/(b-a);
        }else 
            return 1;
    }

    @Override
    public double getTiempo(double probabilidad) {
            return a+((b-a)*probabilidad);
      
    }



    @Override
    public Distribucion comprobarHora(double clock) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'comprobarHora'");
    }

    
}