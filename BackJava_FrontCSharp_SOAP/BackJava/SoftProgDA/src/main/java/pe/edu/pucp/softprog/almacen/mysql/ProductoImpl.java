package pe.edu.pucp.softprog.almacen.mysql;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import pe.edu.pucp.softprog.almacen.dao.ProductoDAO;
import pe.edu.pucp.softprog.almacen.model.Producto;
import pe.edu.pucp.softprog.config.DBManager;

public class ProductoImpl implements ProductoDAO{

    private ResultSet rs;
    
    @Override
    public int insertar(Producto objeto) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public int modificar(Producto objeto) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public int eliminar(int idObjeto) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public Producto obtenerPorId(int idObjeto) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public ArrayList<Producto> listarTodos() {
        ArrayList<Producto> productos = null;
        rs = DBManager.getInstance().ejecutarProcedimientoLectura("LISTAR_PRODUCTOS_TODOS", null);
        System.out.println("Lectura de todos los productos...");
        try{
            while(rs.next()){
                if(productos == null) productos = new ArrayList<>();
                Producto producto = new Producto();
                producto.setIdProducto(rs.getInt("id_producto"));
                producto.setNombre(rs.getString("nombre"));
                producto.setUnidadMedida(rs.getString("unidad_medida"));
                producto.setPrecio(rs.getDouble("precio"));
                producto.setActivo(true);
                productos.add(producto);
            }
        }catch(SQLException ex){
            System.out.println("ERROR: " + ex.getMessage());
        }finally{
            DBManager.getInstance().cerrarConexion();
        }
        return productos;
    }

    @Override
    public ArrayList<Producto> listarPorNombre(String nombre) {
        ArrayList<Producto> productos = null;
        Map<Integer, Object> parametrosEntrada = new HashMap<>();
        parametrosEntrada.put(1, nombre);
        rs = DBManager.getInstance().ejecutarProcedimientoLectura("LISTAR_PRODUCTOS_X_NOMBRE", parametrosEntrada);
        System.out.println("Lectura de todos los productos por nombre...");
        try{
            while(rs.next()){
                if(productos == null) productos = new ArrayList<>();
                Producto producto = new Producto();
                producto.setIdProducto(rs.getInt("id_producto"));
                producto.setNombre(rs.getString("nombre"));
                producto.setUnidadMedida(rs.getString("unidad_medida"));
                producto.setPrecio(rs.getDouble("precio"));
                producto.setActivo(true);
                productos.add(producto);
            }
        }catch(SQLException ex){
            System.out.println("ERROR: " + ex.getMessage());
        }finally{
            DBManager.getInstance().cerrarConexion();
        }
        return productos;
    }
    
}
