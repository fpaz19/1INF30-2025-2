package pe.edu.pucp.softprog.ventas.bo;

import java.util.ArrayList;
import pe.edu.pucp.softprog.ventas.boi.IOrdenVentaBO;
import pe.edu.pucp.softprog.ventas.dao.OrdenVentaDAO;
import pe.edu.pucp.softprog.ventas.model.OrdenVenta;
import pe.edu.pucp.softprog.ventas.mysql.OrdenVentaImpl;

public class OrdenVentaBOImpl implements IOrdenVentaBO{

    private OrdenVentaDAO daoOrdenVenta;
    
    public OrdenVentaBOImpl(){
        daoOrdenVenta = new OrdenVentaImpl();
    }
    
    @Override
    public int insertar(OrdenVenta ordenVenta) throws Exception {
        return daoOrdenVenta.insertar(ordenVenta);
    }

    @Override
    public int modificar(OrdenVenta objeto) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public int eliminar(int idObjeto) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public OrdenVenta obtenerPorId(int idObjeto) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public ArrayList<OrdenVenta> listarTodos() throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void validar(OrdenVenta objeto) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
}
