package labspanish.motorlab;

public class Entidad {

    private int identificador; 
    private Servidor servidor; 

    public Servidor getServidor() {
        return servidor;
    }

    public void setServidor(Servidor servidor) {
        this.servidor = servidor;
    }

    public Entidad(int identificador, Servidor servidor) {
        this.identificador = identificador;
        this.servidor= servidor;
    }

    public int getIdentificador() {
        return identificador;
    }

    public void setIdentificador(int identificador) {
        this.identificador = identificador;
    }
    
    
}
