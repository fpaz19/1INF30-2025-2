package pe.edu.pucp.softprog.ventas.mysql;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Types;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import pe.edu.pucp.softprog.config.DBManager;
import pe.edu.pucp.softprog.ventas.dao.OrdenVentaDAO;
import pe.edu.pucp.softprog.ventas.model.LineaOrdenVenta;
import pe.edu.pucp.softprog.ventas.model.OrdenVenta;

public class OrdenVentaImpl implements OrdenVentaDAO{

    private Connection con;
    
    @Override
    public int insertar(OrdenVenta ordenVenta) {
        try{
            DBManager.getInstance().iniciarTransaccion();
            Map<Integer,Object> parametrosSalida = new HashMap<>();
            Map<Integer,Object> parametrosEntrada = new HashMap<>();
            parametrosSalida.put(1, Types.INTEGER);
            parametrosEntrada.put(2, ordenVenta.getEmpleado().getIdPersona());
            parametrosEntrada.put(3, ordenVenta.getCliente().getIdPersona());
            parametrosEntrada.put(4, ordenVenta.getTotal());
            DBManager.getInstance().ejecutarProcedimientoTransaccion("INSERTAR_ORDEN_VENTA", parametrosEntrada, parametrosSalida);
            ordenVenta.setIdOrdenVenta((int) parametrosSalida.get(1));
            System.out.println("Se ha realizado el registro de la orden de venta");
            for(LineaOrdenVenta lov : 
                ordenVenta.getLineasOrdenVenta()){
                parametrosSalida = new HashMap<>();
                parametrosEntrada = new HashMap<>();
                parametrosSalida.put(1, Types.INTEGER);
                parametrosEntrada.put(2, ordenVenta.getIdOrdenVenta());
                parametrosEntrada.put(3, lov.getProducto().getIdProducto());
                parametrosEntrada.put(4, lov.getCantidad());
                parametrosEntrada.put(5, lov.getSubtotal());
                DBManager.getInstance().ejecutarProcedimientoTransaccion("INSERTAR_LINEA_ORDEN_VENTA", parametrosEntrada, parametrosSalida);
                System.out.println("Se ha realizado el registro de la linea de orden de venta");
            }
            DBManager.getInstance().confirmarTransaccion();
        }catch(SQLException ex){
            DBManager.getInstance().cancelarTransaccion();
        }
        return ordenVenta.getIdOrdenVenta();
    }

    @Override
    public int modificar(OrdenVenta objeto) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public int eliminar(int idObjeto) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public OrdenVenta obtenerPorId(int idObjeto) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public ArrayList<OrdenVenta> listarTodos() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
}
