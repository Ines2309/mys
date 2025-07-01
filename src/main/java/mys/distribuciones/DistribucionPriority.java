package mys.distribuciones;

import mys.utilidades.Distribucion;

public class DistribucionPriority extends Distribucion {
    
    public double getProbabilidad(double event) {
        if(event == 1){
            return 0.5; // Leve
        } else if(event == 2){
            return 0.4; // Normal
        } else if(event == 3){
            return 0.1; // Urgente
        } else {
            throw new RuntimeException("Prioridad incorrecta");
        }
    }

    @Override
    public double getTiempo(double acumulativo) {
        if(acumulativo < 0.5){
            return 1; // Leve
        } else if(acumulativo < 0.9){
            return 2; // Normal
        } else {
            return 3; // Urgente
        }
    }

    @Override
    public Distribucion comprobarHora(double clock) {
        // Este método no es aplicable para prioridades, se puede lanzar una excepción o retornar null.
        throw new UnsupportedOperationException("Unimplemented method 'comprobarHora'");
    }
    
}
