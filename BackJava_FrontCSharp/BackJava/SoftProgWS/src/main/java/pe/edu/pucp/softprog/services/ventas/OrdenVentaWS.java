package pe.edu.pucp.softprog.services.ventas;

import jakarta.jws.WebService;
import jakarta.jws.WebMethod;
import jakarta.jws.WebParam;
import pe.edu.pucp.softprog.ventas.bo.OrdenVentaBOImpl;
import pe.edu.pucp.softprog.ventas.boi.IOrdenVentaBO;
import pe.edu.pucp.softprog.ventas.model.OrdenVenta;

@WebService(serviceName = "OrdenVentaWS",
        targetNamespace = "pe.edu.pucp.softprog.services")
public class OrdenVentaWS {

    private IOrdenVentaBO boOrdenVenta;
    
    @WebMethod(operationName = "insertarOrdenVenta")
    public int insertarOrdenVenta(@WebParam(name = "ordenVenta") OrdenVenta ordenVenta) {
        int resultado = 0;
        try{
            boOrdenVenta = new OrdenVentaBOImpl();
            resultado = boOrdenVenta.insertar(ordenVenta);
        }catch(Exception ex){
            System.out.println(ex.getMessage());
        }
        return resultado;
    }
}
