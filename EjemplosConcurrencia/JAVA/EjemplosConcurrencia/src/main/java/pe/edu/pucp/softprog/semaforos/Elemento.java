package pe.edu.pucp.softprog.semaforos;
public class Elemento {
    private int id;
    private static int correlativo = 1;
    
    public Elemento(){
        this.id = correlativo;
        correlativo++;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Elemento " + id;
    }
    
    
}
