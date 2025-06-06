package labspanish.utilidades;

import java.util.List;

import labspanish.motorlab.Servidor;

public class Politica implements Politic {

    // Atributos
    private List<Servidor> servidores; // Lista de servidores 

    public Politica(List<Servidor> servidores) {
        this.servidores = servidores;
    }

    @Override
    public Servidor getServidor() { 
        Servidor servidor= null; //por defecto el primero
        for (Servidor s : servidores) {
            if (!s.isBusy()) {    
                 servidor=s;   
                 break;
            }
        }
        if(servidor==null){
            servidor = servidores.get(0);
            for(Servidor s : servidores){
               if(s.getFila().size() < servidor.getFila().size() ){
                servidor= s;
               }
            }
        }

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

    public String inforServidor(){  //nos devuelve de todos los servidores el menor 
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
}
