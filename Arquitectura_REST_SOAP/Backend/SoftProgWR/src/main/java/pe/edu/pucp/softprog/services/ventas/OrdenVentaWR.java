package pe.edu.pucp.softprog.services.ventas;

import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import pe.edu.pucp.softprog.ventas.bo.OrdenVentaBOImpl;
import pe.edu.pucp.softprog.ventas.boi.IOrdenVentaBO;
import pe.edu.pucp.softprog.ventas.model.OrdenVenta;

@Path("OrdenVentaWR")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class OrdenVentaWR {

    private IOrdenVentaBO boOrdenVenta;
    
    @POST
    @Path("insertar")
    public int insertar(OrdenVenta ordenVenta){
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
