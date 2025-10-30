package pe.edu.pucp.softprog.services;

import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import java.util.ArrayList;
import pe.edu.pucp.softprog.rrhh.model.Area;

@Path("ServicioRS")
public class ServicioRS {
    
    private static ArrayList<Area> areas
            = new ArrayList<>(
            
            );
    static{
        Area a1 = new Area();
        a1.setNombre("FINANZAS");
        a1.setIdArea(1);
        a1.setActivo(true);
        Area a2 = new Area();
        a2.setNombre("RECURSOS HUMANOS");
        a2.setIdArea(2);
        a2.setActivo(true);
        areas.add(a1);
        areas.add(a2);
    }
    
    public ServicioRS(){
        
    }
    
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("obtenerArea")
    public Area obtenerArea(){
        Area area = new Area();
        area.setNombre("CONTABILIDAD");
        area.setIdArea(1);
        return area;
    }
    
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("listarTodasAreas")
    public ArrayList<Area> listarTodasAreas(){
        return areas;
    }
    
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Path("insertarArea")
    public int insertar(Area area){
        areas.add(area);
        return 1;
    }
}
