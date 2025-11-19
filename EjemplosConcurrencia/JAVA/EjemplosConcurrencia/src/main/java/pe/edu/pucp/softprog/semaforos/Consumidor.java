package pe.edu.pucp.softprog.semaforos;

import javax.swing.DefaultListModel;

public class Consumidor extends Thread{
    private DefaultListModel modeloProductor;
    private DefaultListModel modeloConsumidor;
    
    public Consumidor(DefaultListModel modeloProductor, DefaultListModel modeloConsumidor){
        this.modeloProductor = modeloProductor;
        this.modeloConsumidor = modeloConsumidor;
    }
    
    @Override
    public void run(){
        try{
            while(true){
                Thread.sleep(1500);
                frmEjemplo.semaforo1.acquire();
                frmEjemplo.semaforo3.acquire();
                consumir();
                frmEjemplo.semaforo3.release();
                frmEjemplo.semaforo2.release();
            }
        }catch(Exception ex){
            System.out.println("ERROR AL CONSUMIR: "
            + ex.getMessage());
        }
    }
    
    public void consumir() throws Exception{
        Elemento e = (Elemento) modeloProductor.getElementAt(0);
        modeloProductor.removeElement(e);
        modeloConsumidor.addElement(e);
    }
}
