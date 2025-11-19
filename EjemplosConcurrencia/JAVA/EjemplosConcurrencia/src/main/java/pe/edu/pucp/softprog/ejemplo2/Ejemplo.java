package pe.edu.pucp.softprog.ejemplo2;
public class Ejemplo implements Runnable {
    public static void main(String[] args) throws Exception{
        Runnable e = new Ejemplo();
        Thread t = new Thread(e, "Hilo 1");
        t.start();
        System.out.print(t.getName());
        System.out.println(", estado = " + t.isAlive());
    }   
    @Override
    public void run(){
        Thread t = Thread.currentThread();
        System.out.print(t.getName());
        System.out.println(", estado = " + t.isAlive());
    }
}
