package labspanish.utilidades;

public class DistribucionSalida implements Distribucion{

    @Override
    public double getProbabilidad(double event) {
        if(event == 10){
            return 0.38;
        }
        else if(event == 15){
            return 0.32;
        }
        else if(event == 17){
            return 0.1;
        }
        else if(event == 20){
            return 0.2;
        }
        else{
            throw new RuntimeException("cod incorrecto");
        }
    }

    @Override
    public double getEvento(double acumulativo) {
        if(acumulativo < 0.38){
            return 10;
        }
        else if(acumulativo < 0.7){
            return 15;
        }
        else if(acumulativo < 0.8) {
            return 17;
        }
        else{
            return 20;
        }
    }

}
