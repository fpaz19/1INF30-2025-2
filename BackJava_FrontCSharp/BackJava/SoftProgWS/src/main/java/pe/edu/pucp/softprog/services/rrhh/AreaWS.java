package pe.edu.pucp.softprog.services.rrhh;

import jakarta.jws.WebService;
import jakarta.jws.WebMethod;
import jakarta.jws.WebParam;
import java.util.ArrayList;
import pe.edu.pucp.softprog.rrhh.bo.AreaBOImpl;
import pe.edu.pucp.softprog.rrhh.model.Area;

@WebService(serviceName = "AreaWS")
public class AreaWS {

    private AreaBOImpl boArea;
    
    @WebMethod(operationName = "listarAreasTodas")
    public ArrayList<Area> listarAreasTodas() {
        ArrayList<Area> areas = null;
        try{
            boArea = new AreaBOImpl();
            areas = boArea.listarTodos();
        }catch(Exception ex){
            System.out.println(ex.getMessage());
        }
        return areas;
    }
    
    @WebMethod(operationName = "obtenerAreaPorId")
    public Area obtenerAreaPorId(@WebParam(name = "idArea") int idArea){
        Area area = null;
        try{
            boArea = new AreaBOImpl();
            area = boArea.obtenerPorId(idArea);
        }catch(Exception ex){
            System.out.println(ex.getMessage());
        }
        return area;
    }
    
    @WebMethod(operationName = "insertarArea")
    public int insertarArea(
            @WebParam(name = "area")
            Area area){
        int resultado = 0;
        try{
            boArea = new AreaBOImpl();
            resultado = boArea.insertar(area);
        }catch(Exception ex){
            System.out.println(ex.getMessage());
        }
        return resultado;
    }
    
    @WebMethod(operationName = "modificarArea")
    public int modificarArea(
            @WebParam(name = "area")
            Area area){
        int resultado = 0;
        try{
            boArea = new AreaBOImpl();
            resultado = boArea.modificar(area);
        }catch(Exception ex){
            System.out.println(ex.getMessage());
        }
        return resultado;
    }
    
    @WebMethod(operationName = "eliminarArea")
    public int eliminarArea(
            @WebParam(name = "idArea")
            int idArea){
        int resultado = 0;
        try{
            boArea = new AreaBOImpl();
            resultado = boArea.eliminar(idArea);
        }catch(Exception ex){
            System.out.println(ex.getMessage());
        }
        return resultado;
    }
}
