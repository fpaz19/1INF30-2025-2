package pe.edu.pucp.softprog.ventas.mysql;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import pe.edu.pucp.softprog.almacen.model.Producto;
import pe.edu.pucp.softprog.config.DBManager;
import pe.edu.pucp.softprog.ventas.dao.LineaOrdenVentaDAO;
import pe.edu.pucp.softprog.ventas.model.LineaOrdenVenta;

public class LineaOrdenVentaImpl implements LineaOrdenVentaDAO{

    private ResultSet rs;
    
    @Override
    public ArrayList<LineaOrdenVenta> listarPorIdOrdenVenta(int idOrdenVenta) {
        ArrayList<LineaOrdenVenta> lineasOrdenVenta = null;
        Map<Integer, Object> parametrosEntrada = new HashMap<>();
        parametrosEntrada.put(1, idOrdenVenta);
        rs = DBManager.getInstance().ejecutarProcedimientoLectura("LISTAR_LINEAS_ORDEN_VENTA_X_ID_ORDEN_VENTA", parametrosEntrada);
        System.out.println("Lectura de lineas de orden de venta por id orden de venta...");
        try{
            while(rs.next()){
                if(lineasOrdenVenta == null) lineasOrdenVenta = new ArrayList<>();
                LineaOrdenVenta lov = new LineaOrdenVenta();
                lov.setIdLineaOrdenVenta(rs.getInt("id_linea_orden_venta"));
                Producto producto = new Producto();
                producto.setIdProducto(rs.getInt("id_producto"));
                producto.setNombre(rs.getString("nombre"));
                producto.setPrecio(rs.getDouble("precio"));
                producto.setUnidadMedida(rs.getString("unidad_medida"));
                lov.setCantidad(rs.getInt("cantidad"));
                lov.setSubtotal(rs.getDouble("subtotal"));
                lov.setProducto(producto);
                lineasOrdenVenta.add(lov);
            }
        }catch(SQLException ex){
            System.out.println(ex.getMessage());
        }finally{
            DBManager.getInstance().cerrarConexion();
        }
        return lineasOrdenVenta;
    }

}