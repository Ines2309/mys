package mys.distribuciones;

import mys.utilidades.Distribucion;

public class DistribucionSalida extends Distribucion {
    @Override
    public double getProbabilidad(double event) {
        if(event == 8){
            return 0.38;
        }
        else if(event == 10){
            return 0.32;
        }
        else if(event == 13){
            return 0.1;
        }
        else if(event == 15){
            return 0.2;
        }
        else{
            throw new RuntimeException("cod incorrecto");
        }
    }

    @Override
    public double getTiempo(double acumulativo) {
        if(acumulativo < 0.38){
            return 8;
        }
        else if(acumulativo < 0.7){
            return 10;
        }
        else if(acumulativo < 0.8) {
            return 13;
        }
        else{
            return 15;
        }
    }

    @Override
    public Distribucion comprobarHora(double clock) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'comprobarHora'");
    }
    
}
