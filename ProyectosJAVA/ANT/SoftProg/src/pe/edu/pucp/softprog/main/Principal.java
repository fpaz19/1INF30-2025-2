package pe.edu.pucp.softprog.main;

import com.mysql.cj.admin.ServerController;
import pe.edu.pucp.softprog.rrhh.model.Persona;

public class Principal {
    public static void main(String[] args){
        matematicas.Sumatoria objSum
                = new matematicas.Sumatoria();
        objSum.imprimir(10, 20);
        
        Persona p = new Persona();
        p.setNombre("PEDRO");
        p.edad = 10;
        
        ServerController obj;
        
    }
}
