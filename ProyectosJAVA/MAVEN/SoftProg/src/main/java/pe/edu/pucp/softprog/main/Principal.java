package pe.edu.pucp.softprog.main;


import java.util.ArrayList;
import pe.edu.pucp.softprog.almacen.dao.ProductoDAO;
import pe.edu.pucp.softprog.almacen.model.Producto;
import pe.edu.pucp.softprog.almacen.mysql.ProductoImpl;
import pe.edu.pucp.softprog.gestclientes.dao.ClienteDAO;
import pe.edu.pucp.softprog.gestclientes.model.Cliente;
import pe.edu.pucp.softprog.gestclientes.mysql.ClienteImpl;
import pe.edu.pucp.softprog.rrhh.bo.AreaBOImpl;
import pe.edu.pucp.softprog.rrhh.dao.AreaDAO;
import pe.edu.pucp.softprog.rrhh.dao.EmpleadoDAO;
import pe.edu.pucp.softprog.rrhh.mysql.AreaImpl;
import pe.edu.pucp.softprog.rrhh.model.Area;
import pe.edu.pucp.softprog.rrhh.model.Empleado;
import pe.edu.pucp.softprog.rrhh.mysql.EmpleadoImpl;
import pe.edu.pucp.softprog.ventas.dao.OrdenVentaDAO;
import pe.edu.pucp.softprog.ventas.model.LineaOrdenVenta;
import pe.edu.pucp.softprog.ventas.model.OrdenVenta;
import pe.edu.pucp.softprog.ventas.mysql.OrdenVentaImpl;
import pe.edu.pucp.softprog.rrhh.boi.IAreaBO;

public class Principal {
    public static void main(String[] args) throws Exception{
//        ProductoDAO daoProducto = new ProductoImpl();
//        ArrayList<Producto> productos = daoProducto.listarTodos();
//        
//        ClienteDAO daoCliente = new ClienteImpl();
//        Cliente cliente = daoCliente.obtenerPorId(8);
//        EmpleadoDAO daoEmpleado = new EmpleadoImpl();
//        Empleado empleado = daoEmpleado.obtenerPorId(4);
//       
//        LineaOrdenVenta lov1 = new LineaOrdenVenta();
//        lov1.setProducto(productos.get(0));
//        lov1.setCantidad(2);
//        lov1.calcularSubtotal();
//        
//        LineaOrdenVenta lov2 = new LineaOrdenVenta();
//        lov2.setProducto(productos.get(1));
//        lov2.setCantidad(3);
//        lov2.calcularSubtotal();
//        
//        OrdenVenta ov = new OrdenVenta();
//        ov.agregarLineaOrdenVenta(lov1);
//        ov.agregarLineaOrdenVenta(lov2);
//        ov.setEmpleado(empleado);
//        ov.setCliente(cliente);
//        
//        ov.calcularTotal();
//        
//        OrdenVentaDAO daoOrdenVenta 
//                = new OrdenVentaImpl();
//        int resultado 
//                = daoOrdenVenta.insertar(ov);
//        
//        if(resultado!=0)
//            System.out.println("Se ha registrado correctamente");
//        else
//            System.out.println("Ha ocurrido un error");
//        
//        OrdenVenta ovObj = daoOrdenVenta.obtenerPorId(1);
//        

          Area a = new Area("EJEMPLO");
          IAreaBO areaBO = new AreaBOImpl();
          areaBO.insertar(a);
    }
}
