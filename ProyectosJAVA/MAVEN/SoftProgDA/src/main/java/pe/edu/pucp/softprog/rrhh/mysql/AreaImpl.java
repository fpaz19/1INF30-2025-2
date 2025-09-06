package pe.edu.pucp.softprog.rrhh.mysql;

import java.sql.Connection;
import java.sql.Statement;
import java.util.ArrayList;
import pe.edu.pucp.softprog.config.DBManager;
import pe.edu.pucp.softprog.rrhh.dao.AreaDAO;
import pe.edu.pucp.softprog.rrhh.model.Area;

public class AreaImpl implements AreaDAO{

    private Connection con;
    private Statement st;
    private DBManager obj;
    
    @Override
    public int insertar(Area area) {
        int resultado = 0;
        try{
            obj = new DBManager();
            con = obj.getConnection();
            st = con.createStatement();
            String sql = 
                    "INSERT INTOarea(nombre,activa)"
                    + "VALUES('" + area.getNombre() 
                    + "',1)";
            st.executeUpdate(sql);
            resultado = 1;
        }catch(Exception ex){
            System.out.println("Error al insertar: "
            + ex.getMessage());
        }finally{
            obj.cerrarConexion();
        }
        return resultado;
    }

    @Override
    public int modificar(Area area) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public int eliminar(int idArea) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public Area obtenerPorId(int idArea) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public ArrayList<Area> listarTodos() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
}
