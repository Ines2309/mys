package labspanish.utilidades;
import java.util.List;
import labspanish.motorlab.Servidor; 

public class Politica implements Politic{
    // Atributos
    private List <Servidor> servidores; // Lista de servidores 

    public Politica(List<Servidor> servidores){
        this.servidores = servidores;
    }
    
    public Servidor getServidor() { 
        for (Servidor s: servidores) {
            if(!s.isBusy()) {
                return s;
            }
        }

        return null;
    }

    public void setEstadoServiodor(Servidor servidor){
        for(int i=0; i<servidores.size();i++){
            if(servidor.getId() == servidores.get(i).getId()){
                servidores.add(i, servidor);
            }
        }
            
    }

    public List<Servidor> getServidores() {
        return servidores;
    }
    public void setServidores(List<Servidor> servidores) {
        this.servidores = servidores;
    }
}
