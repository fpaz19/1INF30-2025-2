package pe.edu.pucp.softprog.services.rrhh;

import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import java.util.ArrayList;
import pe.edu.pucp.softprog.rrhh.bo.AreaBOImpl;
import pe.edu.pucp.softprog.rrhh.boi.IAreaBO;
import pe.edu.pucp.softprog.rrhh.model.Area;

@Path("AreaRS")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class AreaRS {
    
    private IAreaBO boArea;
    
    @GET
    @Path("listarTodas")
    public ArrayList<Area> listarTodas(){
        ArrayList<Area> areas = null;
        try{
            boArea = new AreaBOImpl();
            areas = boArea.listarTodos();
        }catch(Exception ex){
            System.out.println(ex.getMessage());
        }
        return areas;
    }
    
    @GET
    @Path("obtenerPorId/{id}/{nombre}")
    public Area obtenerPorId(@PathParam("id") int id,
            @PathParam("nombre") String nombre){
        Area area = null;
        try{
            boArea = new AreaBOImpl();
            area = boArea.obtenerPorId(id);
        }catch(Exception ex){
            System.out.println(ex.getMessage());
        }
        return area;
    }
    
    @POST
    @Path("insertarArea")
    public int insertar(Area area){
        int resultado = 0;
        try{
            boArea = new AreaBOImpl();
            resultado = boArea.insertar(area);
        }catch(Exception ex){
            System.out.println(ex.getMessage());
        }
        return resultado;
    }
}
