package pe.edu.pucp.softprog.main;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import pe.edu.pucp.softprog.rrhh.dao.AreaDAO;
import pe.edu.pucp.softprog.rrhh.dao.EmpleadoDAO;
import pe.edu.pucp.softprog.rrhh.mysql.AreaImpl;
import pe.edu.pucp.softprog.rrhh.model.Area;
import pe.edu.pucp.softprog.rrhh.model.Empleado;
import pe.edu.pucp.softprog.rrhh.mysql.EmpleadoImpl;

public class Principal {
    public static void main(String[] args){
        //Area objArea = new Area("RECURSOS HUMANOS");
        AreaDAO objAreaDA = new AreaImpl();
        //objAreaDA.insertar(objArea);
        
        
        Area area = objAreaDA.obtenerPorId(1);
        
        System.out.println(area.getIdArea() + " " +
                area.getNombre() + " " +
                area.isActivo());
        
        Empleado emp = new Empleado();
        emp.setDni("28765552");
        emp.setNombre("DANIELA");
        emp.setApellidoPaterno("FLORES");
        emp.setSexo('F');
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        try{
        emp.setFechaNacimiento(sdf.parse("1989-10-23"));
        }catch(ParseException ex){
            System.out.println("ERROR DE CONVERSION DE FECHA");
        }
        emp.setCargo("ASISTENTE DE GERENCIA");
        emp.setSueldo(4000.00);
               
        EmpleadoDAO daoEmpleado = new EmpleadoImpl();
        daoEmpleado.insertar(emp);
    }
}
