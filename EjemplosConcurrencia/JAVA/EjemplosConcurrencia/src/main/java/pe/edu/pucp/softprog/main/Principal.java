package pe.edu.pucp.softprog.main;
public class Principal {
    public static void main(String[] args) throws Exception{
        Triangulo t = new Triangulo(100);
        Cuadrado c = new Cuadrado(100);
        Thread hiloT = new Thread(t);
        hiloT.setName("Hilo de Triangulo");
        hiloT.start();
        hiloT.join();
        c.start();

        for (int i = 1; i <= 10; i++) {
            System.out.println(i);
            Thread.sleep(1000);

        }
    }
}
