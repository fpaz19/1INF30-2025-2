package pe.edu.pucp.softprog.rrhh.mysql;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import pe.edu.pucp.softprog.config.DBManager;
import pe.edu.pucp.softprog.rrhh.dao.EmpleadoDAO;
import pe.edu.pucp.softprog.rrhh.model.Empleado;

public class EmpleadoImpl implements EmpleadoDAO{

    private Connection con;
    private Statement st;
    private PreparedStatement pst;
    private ResultSet rs;
    
    @Override
    public ArrayList<Empleado> buscarPorDNI(String DNI) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public int insertar(Empleado empleado) {
        int resultado = 0;
        try{
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            con = DBManager.getInstance().getConnection();
            
            String sql = 
                    "INSERT INTO persona(DNI,"
                    + "nombre,apellido_paterno,"
                    + "sexo,fecha_nacimiento) "
                    + "VALUES(?,?,?,?,?)";
            pst = con.prepareStatement(sql);
            pst.setString(1,empleado.getDni());
            pst.setString(2, empleado.getNombre());
            pst.setString(3, empleado.getApellidoPaterno());
            pst.setString(4, String.valueOf(empleado.getSexo()));
            pst.setDate(5, new Date(empleado.getFechaNacimiento().getTime()));
 
            pst.executeUpdate();
            
            //st = con.createStatement();
            /*String sql = 
                    "INSERT INTO persona(DNI,"
                    + "nombre,apellido_paterno,"
                    + "sexo,fecha_nacimiento) "
                    + "VALUES('" + empleado.getDni() +" ',"
                    + "'" + empleado.getNombre() +"',"
                    + "'" + empleado.getApellidoPaterno() + 
                    "','" + empleado.getSexo() + "','" + 
                    sdf.format(empleado.getFechaNacimiento())
                    +"')";
            */
            //st.executeUpdate(sql);
            
            sql = "SELECT @@last_insert_id AS id_generado";
            
            pst = con.prepareStatement(sql);
            rs = pst.executeQuery();
            //rs = st.executeQuery(sql);
            rs.next();
            empleado.setIdPersona(rs.getInt("id_generado"));
            
            /*    sql = "INSERT INTO empleado(id_empleado,cargo,sueldo,activo) "
                        + "VALUES("+ empleado.getIdPersona()+","
                        + "'" + empleado.getCargo()+ "'"
                        + "," + empleado.getSueldo()+ ","
                        + "1)";
            */
            
            sql = "INSERT INTO empleado(id_empleado,"
                    + "cargo,sueldo,activo) "
                        + "VALUES(?,?,?,1)";
            pst = con.prepareStatement(sql);
            pst.setInt(1, empleado.getIdPersona());
            pst.setString(2, empleado.getCargo());
            pst.setDouble(3, empleado.getSueldo());
            
            pst.executeUpdate();
            //st.executeUpdate(sql);
            System.out.println("Empleado registrado con exito");
            resultado = 1;
        }catch(SQLException ex){
            System.out.println("Error al insertar: "
            + ex.getMessage());
        }finally{
            DBManager.getInstance().cerrarConexion();
        }
        return resultado;
    }

    @Override
    public int modificar(Empleado objeto) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public int eliminar(int idObjeto) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public Empleado obtenerPorId(int idObjeto) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public ArrayList<Empleado> listarTodos() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
}
