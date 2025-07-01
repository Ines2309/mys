package mys.distribuciones;

import mys.utilidades.Distribucion;

public class DistribucionArribo extends Distribucion {
       @Override
    public double getProbabilidad(double event) {
        if(event == 10){
            return 0.35;
        }
        else if(event == 15){
            return 0.45;
        }
        else if(event == 17){
            return 0.2;
        }else {
            throw new RuntimeException("cod incorrecto");
        }
    }


    @Override
    public double getTiempo(double acumulativo) {
        if(acumulativo < 0.35){
            return 10;
        }
        else if(acumulativo < 0.8){
            return 15;
        }
        else{
            return 17;
        }
    }


    @Override
    public Distribucion comprobarHora(double clock) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'comprobarHora'");
    }
    
    
}
