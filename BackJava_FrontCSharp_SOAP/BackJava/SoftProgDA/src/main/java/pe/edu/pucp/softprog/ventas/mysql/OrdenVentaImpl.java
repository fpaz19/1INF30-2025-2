package pe.edu.pucp.softprog.ventas.mysql;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import pe.edu.pucp.softprog.config.DBManager;
import pe.edu.pucp.softprog.gestclientes.model.Categoria;
import pe.edu.pucp.softprog.gestclientes.model.Cliente;
import pe.edu.pucp.softprog.rrhh.model.Area;
import pe.edu.pucp.softprog.rrhh.model.Empleado;
import pe.edu.pucp.softprog.ventas.dao.OrdenVentaDAO;
import pe.edu.pucp.softprog.ventas.model.LineaOrdenVenta;
import pe.edu.pucp.softprog.ventas.model.OrdenVenta;

public class OrdenVentaImpl implements OrdenVentaDAO{

    private ResultSet rs;
    
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
    public int modificar(OrdenVenta ordenVenta) {
        try{
            DBManager.getInstance().iniciarTransaccion();
            Map<Integer,Object> parametrosEntrada = new HashMap<>();
            parametrosEntrada.put(1, ordenVenta.getIdOrdenVenta());
            parametrosEntrada.put(2, ordenVenta.getEmpleado().getIdPersona());
            parametrosEntrada.put(3, ordenVenta.getCliente().getIdPersona());
            parametrosEntrada.put(4, ordenVenta.getTotal());
            DBManager.getInstance().ejecutarProcedimientoTransaccion("MODIFICAR_ORDEN_VENTA", parametrosEntrada, null);
            System.out.println("Se ha realizado el modificacion de la orden de venta");
            for(LineaOrdenVenta lov : ordenVenta.getLineasOrdenVenta()){
                Map<Integer,Object> parametrosSalida = new HashMap<>();
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
    public int eliminar(int idOrdenVenta) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public OrdenVenta obtenerPorId(int idOrdenVenta) {
        OrdenVenta ordenVenta = null;
        Map<Integer, Object> parametrosEntrada = new HashMap<>();
        parametrosEntrada.put(1, idOrdenVenta);
        rs = DBManager.getInstance().ejecutarProcedimientoLectura("OBTENER_ORDEN_VENTA_X_ID", parametrosEntrada);
        System.out.println("Lectura de orden de venta...");
        try{
            while(rs.next()){
                if(ordenVenta == null) ordenVenta = new OrdenVenta();
                ordenVenta.setIdOrdenVenta(rs.getInt("id_empleado"));
                ordenVenta.setTotal(rs.getDouble("total"));
                ordenVenta.setFechaHora(rs.getTimestamp("fecha_hora"));
                Area area = new Area();
                area.setIdArea(rs.getInt("id_area"));
                area.setNombre(rs.getString("nombre_area"));
                Empleado empleado = new Empleado();
                empleado.setArea(area);
                empleado.setIdPersona(rs.getInt("id_empleado"));
                empleado.setDni(rs.getString("dni_empleado"));
                empleado.setNombre(rs.getString("nombre_empleado"));
                empleado.setApellidoPaterno(rs.getString("apellido_paterno_empleado"));
                empleado.setSexo(rs.getString("sexo_empleado").charAt(0));
                empleado.setFechaNacimiento(rs.getDate("fecha_nacimiento_empleado"));
                empleado.setCargo(rs.getString("cargo_empleado"));
                empleado.setSueldo(rs.getDouble("sueldo_empleado"));
                Cliente cliente = new Cliente();
                cliente.setIdPersona(rs.getInt("id_cliente"));
                cliente.setDni(rs.getString("dni_cliente"));
                cliente.setNombre(rs.getString("nombre_cliente"));
                cliente.setApellidoPaterno(rs.getString("apellido_paterno_cliente"));
                cliente.setSexo(rs.getString("sexo_empleado").charAt(0));
                cliente.setFechaNacimiento(rs.getTimestamp("fecha_nacimiento_cliente"));
                cliente.setCategoria(Categoria.valueOf(rs.getString("categoria_cliente")));
                cliente.setLineaCredito(rs.getDouble("linea_credito_cliente"));
                ordenVenta.setEmpleado(empleado);
                ordenVenta.setCliente(cliente);
            }
        }catch(SQLException ex){
            System.out.println(ex.getMessage());
        }finally{
            DBManager.getInstance().cerrarConexion();
        }
        return ordenVenta;
    }

    @Override
    public ArrayList<OrdenVenta> listarTodos() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
}
