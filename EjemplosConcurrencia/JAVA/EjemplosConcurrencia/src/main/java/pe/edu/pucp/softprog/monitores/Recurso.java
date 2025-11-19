package pe.edu.pucp.softprog.monitores;
public class Recurso {
    
    private final int MAX_BUFFER = 3;
    private int numero;
    
    public Recurso(){
        System.out.println("Inicializando el recurso compartido.");
        this.numero = 0;
        System.out.println("Valor del recurso: " + numero);
    }
    
    public synchronized void aumentar() throws Exception{
        while(numero == MAX_BUFFER)
            wait();
        System.out.println("Se esta aumentado el valor del recurso.");
        int temporal = numero;
        temporal = temporal + 1;
        numero = temporal;
        System.out.println("Valor del recurso: " + numero);
        notifyAll();
    }
    
    public synchronized void disminuir() throws Exception{
        while(numero == 0)
            wait();
        System.out.println("Se esta disminuyendo el valor del recurso.");
        int temporal = numero;
        temporal = temporal - 1;
        numero = temporal;
        System.out.println("Valor del recurso: " + numero);
        notifyAll();
    }
}
