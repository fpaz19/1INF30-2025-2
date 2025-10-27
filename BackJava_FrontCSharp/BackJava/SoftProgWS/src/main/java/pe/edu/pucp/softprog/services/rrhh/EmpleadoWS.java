package pe.edu.pucp.softprog.services.rrhh;

import jakarta.jws.WebService;
import jakarta.jws.WebMethod;
import jakarta.jws.WebParam;
import java.util.ArrayList;
import pe.edu.pucp.softprog.rrhh.bo.EmpleadoBOImpl;
import pe.edu.pucp.softprog.rrhh.boi.IEmpleadoBO;
import pe.edu.pucp.softprog.rrhh.model.Empleado;

@WebService(serviceName = "EmpleadoWS")
public class EmpleadoWS {

    private IEmpleadoBO boEmpleado;
    
    @WebMethod(operationName = "listarEmpleadosTodos")
    public ArrayList<Empleado> listarEmpleadosTodos() {
        ArrayList<Empleado> empleados = null;
        try{
            boEmpleado = new EmpleadoBOImpl();
            empleados = boEmpleado.listarTodos();
        }catch(Exception ex){
            System.out.println(ex.getMessage());
        }
        return empleados;
    }
    
    @WebMethod(operationName = "insertarEmpleado")
    public int insertarEmpleado(@WebParam(name = "empleado") Empleado empleado){
        int resultado = 0;
        try{
            boEmpleado = new EmpleadoBOImpl();
            resultado = boEmpleado.insertar(empleado);
        }catch(Exception ex){
            System.out.println(ex.getMessage());
        }
        return resultado;
    }
    
    @WebMethod(operationName = "modificarEmpleado")
    public int modificarEmpleado(@WebParam(name = "empleado") Empleado empleado){
        int resultado = 0;
        try{
            boEmpleado = new EmpleadoBOImpl();
            resultado = boEmpleado.modificar(empleado);
        }catch(Exception ex){
            System.out.println(ex.getMessage());
        }
        return resultado;
    }
    
    @WebMethod(operationName = "eliminarEmpleado")
    public int eliminarEmpleado(@WebParam(name = "idEmpleado") int idEmpleado){
        int resultado = 0;
        try{
            boEmpleado = new EmpleadoBOImpl();
            resultado = boEmpleado.eliminar(idEmpleado);
        }catch(Exception ex){
            System.out.println(ex.getMessage());
        }
        return resultado;
    }
    
    @WebMethod(operationName = "obtenerEmpleadoPorId")
    public Empleado obtenerEmpleadoPorId(@WebParam(name = "idEmpleado") int idEmpleado){
        Empleado empleado = null;
        try{
            boEmpleado = new EmpleadoBOImpl();
            empleado = boEmpleado.obtenerPorId(idEmpleado);
        }catch(Exception ex){
            System.out.println(ex.getMessage());
        }
        return empleado;
    }
}
