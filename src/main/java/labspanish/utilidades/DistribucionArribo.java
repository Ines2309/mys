/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package labspanish.utilidades;

/**
 *
 * @author santi
 */
public class DistribucionArribo implements Distribucion{

    @Override
    public double getProbabilidad(int event) {
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
    public int getEvento(double acumulativo) {
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
    
}
