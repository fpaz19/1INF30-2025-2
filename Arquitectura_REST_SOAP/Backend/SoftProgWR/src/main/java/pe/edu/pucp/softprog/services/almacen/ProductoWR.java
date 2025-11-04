package pe.edu.pucp.softprog.services.almacen;

import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import java.util.ArrayList;
import pe.edu.pucp.softprog.almacen.bo.ProductoBOImpl;
import pe.edu.pucp.softprog.almacen.boi.IProductoBO;
import pe.edu.pucp.softprog.almacen.model.Producto;

@Path("ProductoWR")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class ProductoWR {
    
    private IProductoBO boProducto;
    
    @GET
    @Path("listarPorNombre/{nombre}")
    public ArrayList<Producto> listarPorNombre(@PathParam("nombre") String nombre){
        ArrayList<Producto> productos = null;
        try{
            boProducto = new ProductoBOImpl();
            productos = boProducto.listarPorNombre(nombre);
        }catch(Exception ex){
            System.out.println(ex.getMessage());
        }
        return productos;
    }
    
    @GET
    @Path("listarTodos")
    public ArrayList<Producto> listarTodos(){
        ArrayList<Producto> productos = null;
        try{
            boProducto = new ProductoBOImpl();
            productos = boProducto.listarTodos();
        }catch(Exception ex){
            System.out.println(ex.getMessage());
        }
        return productos;
    }
    
}
