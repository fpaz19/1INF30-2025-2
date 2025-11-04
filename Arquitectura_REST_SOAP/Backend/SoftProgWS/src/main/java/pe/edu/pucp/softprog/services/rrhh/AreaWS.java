package pe.edu.pucp.softprog.services.rrhh;

import com.fasterxml.jackson.core.type.TypeReference;
import jakarta.jws.WebService;
import jakarta.jws.WebMethod;
import jakarta.jws.WebParam;
import java.io.IOException;
import java.util.ArrayList;
import pe.edu.pucp.softprog.rrhh.model.Area;
import pe.edu.pucp.softprog.services.base.HttpJsonClient;

@WebService(serviceName = "AreaWS", targetNamespace = "pe.edu.pucp.softprog.services")
public class AreaWS {

    private static final String BASE_URL = "http://localhost:8080/SoftProgWR/webresources/AreaWR";
    
    @WebMethod(operationName = "listarAreasTodas")
    public ArrayList<Area> listarAreasTodas(){
        ArrayList<Area> areas = null;
        try{
            areas = HttpJsonClient.get(BASE_URL + "/listarTodas", new TypeReference<ArrayList<Area>>(){});
        }catch(IOException | InterruptedException ex){
            System.out.println("Error al listar todas las areas: " + ex.getMessage());
        }
        return areas;
    }
    
    @WebMethod(operationName = "obtenerAreaPorId")
    public Area obtenerAreaPorId(@WebParam(name = "idArea") int idArea){
        Area area = null;
        try{
            area = HttpJsonClient.get(BASE_URL + "/obtenerPorId/" + idArea, Area.class);
        }catch(IOException | InterruptedException ex){
            System.out.println("Error al obtener un area por id: " + ex.getMessage());
        }
        return area;
    }
    
    @WebMethod(operationName = "insertarArea")
    public int insertarArea(Area area) {
        int resultado = 0;
        try{
            resultado = HttpJsonClient.post(BASE_URL + "/insertar", area);
        }catch(IOException | InterruptedException ex){
            System.out.println("Error al insertar area: " + ex.getMessage());
        }
        return resultado;
    }
    
    @WebMethod(operationName = "modificarArea")
    public int modificarArea(Area area) {
        int resultado = 0;
        try{
            resultado = HttpJsonClient.put(BASE_URL + "/modificar", area);
        }catch(IOException | InterruptedException ex){
            System.out.println("Error al modificar area: " + ex.getMessage());
        }
        return resultado;
    }
    
    @WebMethod(operationName = "eliminarArea")
    public int eliminarArea(int idArea) {
        int resultado = 0;
        try{
            resultado = HttpJsonClient.delete(BASE_URL + "/eliminar/" + idArea);
        }catch(IOException | InterruptedException ex){
            System.out.println("Error al eliminar area: " + ex.getMessage());
        }
        return resultado;
    }
}
