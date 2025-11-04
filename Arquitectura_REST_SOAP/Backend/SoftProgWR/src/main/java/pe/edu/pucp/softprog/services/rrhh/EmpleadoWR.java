package pe.edu.pucp.softprog.services.rrhh;

import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.DELETE;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.PUT;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import java.util.ArrayList;
import pe.edu.pucp.softprog.rrhh.bo.EmpleadoBOImpl;
import pe.edu.pucp.softprog.rrhh.boi.IEmpleadoBO;
import pe.edu.pucp.softprog.rrhh.model.Empleado;

@Path("EmpleadoWR")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class EmpleadoWR {
    
    private IEmpleadoBO boEmpleado;
    
    @GET
    @Path("listarTodos")
    public ArrayList<Empleado> listarTodos(){
        ArrayList<Empleado> empleados = null;
        try{
            boEmpleado = new EmpleadoBOImpl();
            empleados = boEmpleado.listarTodos();
        }catch(Exception ex){
            System.out.println(ex.getMessage());
        }
        return empleados;
    }
    
    @GET
    @Path("obtenerPorId/{idEmpleado}")
    public Empleado obtenerPorId(@PathParam("idEmpleado") int id){
        Empleado empleado = null;
        try{
            boEmpleado = new EmpleadoBOImpl();
            empleado = boEmpleado.obtenerPorId(id);
        }catch(Exception ex){
            System.out.println(ex.getMessage());
        }
        return empleado;
    }
    
    @POST
    @Path("insertar")
    public int insertar(Empleado empleado){
        int resultado = 0;
        try{
            boEmpleado = new EmpleadoBOImpl();
            resultado = boEmpleado.insertar(empleado);
        }catch(Exception ex){
            System.out.println(ex.getMessage());
        }
        return resultado;
    }
    
    @PUT
    @Path("modificar")
    public int modificar(Empleado empleado){
        int resultado = 0;
        try{
            boEmpleado = new EmpleadoBOImpl();
            resultado = boEmpleado.modificar(empleado);
        }catch(Exception ex){
            System.out.println(ex.getMessage());
        }
        return resultado;
    }
    
    @DELETE
    @Path("eliminar/{idEmpleado}")
    public int eliminar(@PathParam("idEmpleado") int idEmpleado){
        int resultado = 0;
        try{
            boEmpleado = new EmpleadoBOImpl();
            return boEmpleado.eliminar(idEmpleado);
        }catch(Exception ex){
            System.out.println(ex.getMessage());
        }
        return resultado;
    }
}
