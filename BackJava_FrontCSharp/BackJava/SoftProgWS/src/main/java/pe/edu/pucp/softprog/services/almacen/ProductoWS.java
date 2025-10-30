package pe.edu.pucp.softprog.services.almacen;

import jakarta.jws.WebService;
import jakarta.jws.WebMethod;
import jakarta.jws.WebParam;
import java.util.ArrayList;
import pe.edu.pucp.softprog.almacen.bo.ProductoBOImpl;
import pe.edu.pucp.softprog.almacen.boi.IProductoBO;
import pe.edu.pucp.softprog.almacen.model.Producto;

@WebService(serviceName = "ProductoWS",
        targetNamespace = "pe.edu.pucp.softprog.services")
public class ProductoWS {

    private IProductoBO boProducto;
    
    @WebMethod(operationName = "listarProductosPorNombre")
    public ArrayList<Producto> listarProductosPorNombre(@WebParam(name = "nombre") String nombre) {
        ArrayList<Producto> productos = null;
        try{
            boProducto = new ProductoBOImpl();
            productos = boProducto.listarPorNombre(nombre);
        }catch(Exception ex){
            System.out.println(ex.getMessage());
        }
        return productos;
    }
}
