package pe.edu.pucp.softprog.rrhh.mysql;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import pe.edu.pucp.softprog.config.DBManager;
import pe.edu.pucp.softprog.rrhh.dao.AreaDAO;
import pe.edu.pucp.softprog.rrhh.model.Area;

public class AreaImpl implements AreaDAO{

    private Connection con;
    private Statement st;
    private DBManager obj;
    private ResultSet rs;
    
    @Override
    public int insertar(Area area) {
        int resultado = 0;
        try{
            con = DBManager.getInstance().getConnection();
            st = con.createStatement();
            String sql = 
                    "INSERT INTO area(nombre,activa)"
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
        Area area = new Area();
        try{
            con = DBManager.getInstance().getConnection();
            st = con.createStatement();
            String sql = 
                    "SELECT id_area, nombre, activa FROM "
                    + "area WHERE id_area =" + idArea;
            rs = st.executeQuery(sql);
            if(rs.next()){
                area.setIdArea(rs.getInt("id_area"));
                area.setNombre(rs.getString("nombre"));
                area.setActivo(rs.getBoolean("activa"));
            }
        }catch(SQLException ex){
            System.out.println("Error al insertar: "
            + ex.getMessage());
        }finally{
            DBManager.getInstance().cerrarConexion();
        }
        return area;
    }

    @Override
    public ArrayList<Area> listarTodos() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
}
