package pe.edu.pucp.softprog.main;

public class Cuadrado extends Thread{
    private int numero;
    public Cuadrado(int numero){
        this.numero = numero;
    }
    
    @Override
    public void run(){
        for(int i=1;i<=numero;i++){
            System.out.println("El cuadrado de " + i +
                    " es: " + i + " * " + i + " = " + 
                    i*i);
        }
    }
}
