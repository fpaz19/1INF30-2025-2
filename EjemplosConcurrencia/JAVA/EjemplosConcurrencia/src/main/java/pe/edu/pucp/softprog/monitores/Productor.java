package pe.edu.pucp.softprog.monitores;
public class Productor extends Thread{
    
    private Recurso recurso;
    
    public Productor(Recurso recurso){
        this.recurso = recurso;
    }
    
    @Override
    public void run(){
        try{
            recurso.aumentar();
        }catch(Exception ex){
            System.out.println(ex.getMessage());
        }
    }
    
}
