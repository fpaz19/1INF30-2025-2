package pe.edu.pucp.softprog.monitores;
public class Consumidor extends Thread{
    
    private Recurso recurso;
    
    public Consumidor(Recurso recurso){
        this.recurso = recurso;
    }
    
    @Override
    public void run(){
        try{
            recurso.disminuir();
        }catch(Exception ex){
            System.out.println(ex.getMessage());
        }
    }
}
