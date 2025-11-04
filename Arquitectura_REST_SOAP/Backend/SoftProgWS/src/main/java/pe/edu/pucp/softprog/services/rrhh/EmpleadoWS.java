package pe.edu.pucp.softprog.services.rrhh;

import com.fasterxml.jackson.core.type.TypeReference;
import jakarta.jws.WebService;
import jakarta.jws.WebMethod;
import jakarta.jws.WebParam;
import java.io.IOException;
import java.util.ArrayList;
import pe.edu.pucp.softprog.rrhh.model.Empleado;
import pe.edu.pucp.softprog.services.base.HttpJsonClient;

@WebService(serviceName = "EmpleadoWS", targetNamespace = "pe.edu.pucp.softprog.services")
public class EmpleadoWS {

    private static final String BASE_URL = "http://localhost:8080/SoftProgWR/webresources/EmpleadoWR";
    
    @WebMethod(operationName = "listarEmpleadosTodos")
    public ArrayList<Empleado> listarEmpleadosTodos(){
        ArrayList<Empleado> areas = null;
        try{
            areas = HttpJsonClient.get(BASE_URL + "/listarTodos", new TypeReference<ArrayList<Empleado>>(){});
        }catch(IOException | InterruptedException ex){
            System.out.println("Error al listar todos los empleados: " + ex.getMessage());
        }
        return areas;
    }
    
    @WebMethod(operationName = "obtenerEmpleadoPorId")
    public Empleado obtenerEmpleadoPorId(@WebParam(name = "idEmpleado") int idEmpleado){
        Empleado empleado = null;
        try{
            empleado = HttpJsonClient.get(BASE_URL + "/obtenerPorId/" + idEmpleado, Empleado.class);
        }catch(IOException | InterruptedException ex){
            System.out.println("Error al obtener un empleado por id: " + ex.getMessage());
        }
        return empleado;
    }
    
    @WebMethod(operationName = "insertarEmpleado")
    public int insertarEmpleado(Empleado empleado) {
        int resultado = 0;
        try{
            resultado = HttpJsonClient.post(BASE_URL + "/insertar", empleado);
        }catch(IOException | InterruptedException ex){
            System.out.println("Error al insertar empleado: " + ex.getMessage());
        }
        return resultado;
    }
    
    @WebMethod(operationName = "modificarEmpleado")
    public int modificarEmpleado(Empleado empleado) {
        int resultado = 0;
        try{
            resultado = HttpJsonClient.put(BASE_URL + "/modificar", empleado);
        }catch(IOException | InterruptedException ex){
            System.out.println("Error al modificar empleado: " + ex.getMessage());
        }
        return resultado;
    }
    
    @WebMethod(operationName = "eliminarEmpleado")
    public int eliminarEmpleado(int idEmpleado) {
        int resultado = 0;
        try{
            resultado = HttpJsonClient.delete(BASE_URL + "/eliminar/" + idEmpleado);
        }catch(IOException | InterruptedException ex){
            System.out.println("Error al eliminar empleado: " + ex.getMessage());
        }
        return resultado;
    }
}
