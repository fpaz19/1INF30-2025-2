package pe.edu.pucp.softprog.semaforos;
import javax.swing.DefaultListModel;
public class Productor extends Thread{
    
    private DefaultListModel modelo;
    
    public Productor(DefaultListModel modelo){
        this.modelo = modelo;
    }
    
    @Override
    public void run(){
        try{
            while(true){
                frmEjemplo.semaforo2.acquire();
                producir();
                frmEjemplo.semaforo1.release();
                Thread.sleep(1000);
            }
        }catch(Exception ex){
            System.out.println("ERROR AL PRODUCIR: " +
                    ex.getMessage());
        }
    }
    
    public void producir() throws Exception{
        Elemento elemento = new Elemento();
        modelo.addElement(elemento);
    }
}
