package mys.mypolitics;

import java.util.ArrayList;
import java.util.List;

import mys.engine.Servidor;
import mys.estadisticas.EstadisticaOcio;
import mys.utilidades.Politic;

public class Politica implements Politic {
      private List<Servidor> servidores; // Lista de servidores 

    public Politica(List<Servidor> servidores) {
        this.servidores = servidores;
    }

    @Override
    public Servidor getServidor(){
        Servidor servidor= servidores.get(0); //por defecto el primero
        for (Servidor s : servidores) {
            if (!s.isBusy()) {    
                 servidor=s;   
                 break;
            }
        }
        /*if(servidor==null){
            servidor = servidores.get(0); //por defecto el primero
            for(Servidor s : servidores){
               if(s.getFila().size() < servidor.getFila().size() ){
                servidor= s;
               }
            }
        }*/

        return servidor;    
    }
    //funcion a revisar//
    
    public void setEstadoServiodor(Servidor servidor) {
        for (int i = 0; i < servidores.size(); i++) {
            if (servidor.getId() == servidores.get(i).getId()) {
                
                servidores.remove(i);
                servidores.add(servidor);
            }
        }
    }

    public List<Servidor> getServidores() {
        return servidores;
    }

    public void setServidores(List<Servidor> servidores) {
        this.servidores = servidores;
    }

    /*public String inforServidor(){  //nos devuelve de todos los servidores el menor 
        int maximo=0;
        int minimo=0;
     
        for( int i=0; i<servidores.size(); i++) {
         if((servidores.get(i).getFila().getCantMin()<minimo)||(minimo==0)){
            minimo= servidores.get(i).getFila().getCantMin();


         }else if(servidores.get(i).getFila().getCantMax() > maximo){
            maximo=servidores.get(i).getFila().getCantMax();
            
         }

     }


        return("+Largo maximo de fila de espera: " + maximo +"\n+Largo minimo de fila de espera: " + minimo + "\n"); 

    }

    public int getMaxFilaEspera() {
        int maximo=0;
        for(Servidor servidor : servidores) {
            if(servidor.getFila().getCantMax() > maximo){
                maximo=servidor.getFila().getCantMax();
            }
        }
        return maximo;
    }

    public int getMinFilaEspera() {
        int minimo=0;
        for(Servidor servidor : servidores) {
            if((servidor.getFila().getCantMin()<minimo)||(minimo==0)){
                minimo=servidor.getFila().getCantMin();
            }
        }
        return minimo;
    } */
    
    public List<EstadisticaOcio> getEstadisticasOcio() {
        List<EstadisticaOcio> estadisticas = new ArrayList<>();
        for (Servidor servidor : servidores) {
            estadisticas.add(servidor.getEstadisticaOcio());
        }
        return estadisticas;
    }

    public List<Double> getListaDesgaste() {
        List<Double> listaDesgaste = new ArrayList<>();
        for (Servidor servidor : servidores) {
            listaDesgaste.add((double) servidor.getDesgaste());
        }
        return listaDesgaste;
    }

    
}
