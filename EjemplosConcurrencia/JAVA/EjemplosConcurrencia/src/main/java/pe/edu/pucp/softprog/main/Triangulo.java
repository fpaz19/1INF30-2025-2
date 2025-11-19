package pe.edu.pucp.softprog.main;
public class Triangulo extends Base implements Runnable{
    private int filas;
    
    private Triangulo(){}
    
    public Triangulo(int filas){
        this.filas = filas;
    }
    
    @Override
    public void run(){
        for(int i=1;i<filas;i++){
            for(int j=0;j<i;j++)
                System.out.print("*");
            System.out.println();
        }
    }
}
