package pe.edu.pucp.softprog.services.ventas;

import jakarta.jws.WebService;
import jakarta.jws.WebMethod;
import jakarta.jws.WebParam;
import java.io.IOException;
import pe.edu.pucp.softprog.services.base.HttpJsonClient;
import pe.edu.pucp.softprog.ventas.model.OrdenVenta;

@WebService(serviceName = "OrdenVentaWS", targetNamespace = "pe.edu.pucp.softprog.services")
public class OrdenVentaWS {

    private static final String BASE_URL = "http://localhost:8080/SoftProgWR/webresources/OrdenVentaWR";
    
    @WebMethod(operationName = "insertarOrdenVenta")
    public int insertarOrdenVenta(@WebParam(name = "ordenVenta") OrdenVenta ordenVenta) {
        int resultado = 0;
        try{
            resultado = HttpJsonClient.post(BASE_URL + "/insertar", ordenVenta);
        }catch(IOException | InterruptedException ex){
            System.out.println("Error al insertar orden de venta: " + ex.getMessage());
        }
        return resultado;
    }
}
