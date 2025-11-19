package pe.edu.pucp.softprog.monitores;
public class Principal {
    public static void main(String[] args){
        Recurso recurso = new Recurso();
        
        Productor productor1 = new Productor(recurso);
        Productor productor2 = new Productor(recurso);
        Productor productor3 = new Productor(recurso);
        Productor productor4 = new Productor(recurso);
        Productor productor5 = new Productor(recurso);
        Productor productor6 = new Productor(recurso);
        
        Consumidor consumidor1 = new Consumidor(recurso);
        Consumidor consumidor2 = new Consumidor(recurso);
        Consumidor consumidor3 = new Consumidor(recurso);
        Consumidor consumidor4 = new Consumidor(recurso);
        Consumidor consumidor5 = new Consumidor(recurso);
        Consumidor consumidor6 = new Consumidor(recurso);
        
        productor1.start();
        productor2.start();
        productor3.start();
        productor4.start();
        productor5.start();
        productor6.start();
        
        
        consumidor1.start();
        consumidor2.start();
        consumidor3.start();
        consumidor4.start();
        consumidor5.start();
        consumidor6.start();
    }
}
