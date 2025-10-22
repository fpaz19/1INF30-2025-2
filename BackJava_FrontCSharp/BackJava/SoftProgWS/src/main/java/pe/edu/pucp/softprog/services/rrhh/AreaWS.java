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
}
