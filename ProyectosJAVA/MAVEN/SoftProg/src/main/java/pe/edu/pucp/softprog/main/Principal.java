package pe.edu.pucp.softprog.main;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import pe.edu.pucp.softprog.gestclientes.dao.ClienteDAO;
import pe.edu.pucp.softprog.gestclientes.model.Categoria;
import pe.edu.pucp.softprog.gestclientes.model.Cliente;
import pe.edu.pucp.softprog.gestclientes.mysql.ClienteImpl;
import pe.edu.pucp.softprog.rrhh.dao.AreaDAO;
import pe.edu.pucp.softprog.rrhh.dao.EmpleadoDAO;
import pe.edu.pucp.softprog.rrhh.mysql.AreaImpl;
import pe.edu.pucp.softprog.rrhh.model.Area;
import pe.edu.pucp.softprog.rrhh.model.Empleado;
import pe.edu.pucp.softprog.rrhh.mysql.EmpleadoImpl;

public class Principal {
    public static void main(String[] args) throws Exception{
        Area area = new Area("FINANZAS");
        AreaDAO daoArea = new AreaImpl();
        int resultado = daoArea.insertar(area);
        if(resultado!=0)
            System.out.println("El area se ha registrado con exito");
        area = daoArea.obtenerPorId(resultado);
        System.out.println(area);
        area.setNombre("RECURSOS HUMANOS");
        resultado = daoArea.modificar(area);
        if(resultado!=0)
            System.out.println("El area se ha modificado con exito");
        resultado = daoArea.eliminar(area.getIdArea());
        if(resultado!=0)
            System.out.println("El area se ha eliminado con exito");
        ArrayList<Area> areas = daoArea.listarTodos();
        for(Area a : areas){
            System.out.println(a);
        }
        area = new Area("GERENCIA");
        daoArea.insertar(area);
        SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
        Empleado empleado = new Empleado("37610099", "CARMEN", "GUEVARA", 'F', sdf.parse("19-10-1993"), area, "GERENTE", 3500.00);
        EmpleadoDAO daoEmpleado = new EmpleadoImpl();
        resultado = daoEmpleado.insertar(empleado);
        if(resultado!=0)
            System.out.println("El empleado se ha registrado con exito");
        empleado = daoEmpleado.obtenerPorId(resultado);
        System.out.println(empleado);
        empleado.setNombre("KARINA");
        resultado = daoEmpleado.modificar(empleado);
        if(resultado!=0)
            System.out.println("El empleado se ha modificado con exito");
        resultado = daoEmpleado.eliminar(empleado.getIdPersona());
        if(resultado!=0)
            System.out.println("El empleado ha sido eliminado con exito");
        ArrayList<Empleado> empleados = daoEmpleado.listarTodos();
        for (Empleado emp : empleados)
            System.out.println(emp);
        Cliente cliente = new Cliente("78731124", "ANGELA", "GUTIERREZ", 'F', sdf.parse("01-01-1990"), 7540.50, Categoria.Platinum);
        ClienteDAO daoCliente = new ClienteImpl();
        resultado = daoCliente.insertar(cliente);
        if(resultado!=0)
            System.out.println("El cliente se ha registrado con exito");
    }
}
