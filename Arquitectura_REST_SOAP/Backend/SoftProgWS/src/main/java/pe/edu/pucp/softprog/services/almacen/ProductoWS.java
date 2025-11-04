package pe.edu.pucp.softprog.services.almacen;

import com.fasterxml.jackson.core.type.TypeReference;
import jakarta.jws.WebService;
import jakarta.jws.WebMethod;
import jakarta.jws.WebParam;
import java.io.IOException;
import java.util.ArrayList;
import pe.edu.pucp.softprog.almacen.model.Producto;
import pe.edu.pucp.softprog.services.base.HttpJsonClient;

@WebService(serviceName = "ProductoWS", targetNamespace = "pe.edu.pucp.softprog.services")
public class ProductoWS {

    private static final String BASE_URL = "http://localhost:8080/SoftProgWR/webresources/ProductoWR";
    
    @WebMethod(operationName = "listarProductosPorNombre")
    public ArrayList<Producto> listarProductosPorNombre(@WebParam(name = "nombre") String nombre) {
        ArrayList<Producto> productos = null;
        try{
            if (nombre == null || nombre.trim().isEmpty())
                productos = HttpJsonClient.get(BASE_URL + "/listarTodos", new TypeReference<ArrayList<Producto>>(){});
            else
                productos = HttpJsonClient.get(BASE_URL + "/listarPorNombre/" + nombre, new TypeReference<ArrayList<Producto>>(){});
        }catch(IOException | InterruptedException ex){
            System.out.println("Error al obtener productos por nombre: " + ex.getMessage());
        }
        return productos;
    }
}
