package pe.edu.pucp.softprog.rrhh.mysql;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Types;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import pe.edu.pucp.softprog.config.DBManager;
import pe.edu.pucp.softprog.rrhh.dao.EmpleadoDAO;
import pe.edu.pucp.softprog.rrhh.model.Area;
import pe.edu.pucp.softprog.rrhh.model.Empleado;

public class EmpleadoImpl implements EmpleadoDAO{

    private ResultSet rs;
    
    @Override
    public ArrayList<Empleado> buscarPorDNI(String DNI) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public int insertar(Empleado empleado) {
        Map<Integer,Object> parametrosSalida = new HashMap<>();   
        Map<Integer,Object> parametrosEntrada = new HashMap<>();
        parametrosSalida.put(1, Types.INTEGER);
        parametrosEntrada.put(2, empleado.getArea().getIdArea());
        parametrosEntrada.put(3, empleado.getDni());
        parametrosEntrada.put(4, empleado.getNombre());
        parametrosEntrada.put(5, empleado.getApellidoPaterno());
        parametrosEntrada.put(6, String.valueOf(empleado.getSexo()));
        parametrosEntrada.put(7, new Date(empleado.getFechaNacimiento().getTime()));
        parametrosEntrada.put(8, empleado.getCargo());
        parametrosEntrada.put(9, empleado.getSueldo());
        DBManager.getInstance().ejecutarProcedimiento("INSERTAR_EMPLEADO", parametrosEntrada, parametrosSalida);
        empleado.setIdPersona((int) parametrosSalida.get(1));
        System.out.println("Se ha realizado el registro del empleado");
        return empleado.getIdPersona();
    }

    @Override
    public int modificar(Empleado empleado) {
        Map<Integer,Object> parametrosEntrada = new HashMap<>();
        parametrosEntrada.put(1,empleado.getIdPersona());
        parametrosEntrada.put(2, empleado.getArea().getIdArea());
        parametrosEntrada.put(3, empleado.getDni());
        parametrosEntrada.put(4, empleado.getNombre());
        parametrosEntrada.put(5, empleado.getApellidoPaterno());
        parametrosEntrada.put(6, String.valueOf(empleado.getSexo()));
        parametrosEntrada.put(7, new Date(empleado.getFechaNacimiento().getTime()));
        parametrosEntrada.put(8, empleado.getCargo());
        parametrosEntrada.put(9, empleado.getSueldo());
        int resultado = DBManager.getInstance().ejecutarProcedimiento("MODIFICAR_EMPLEADO", parametrosEntrada, null);
        System.out.println("Se ha realizado la modificacion del empleado");
        return resultado;
    }

    @Override
    public int eliminar(int idEmpleado) {
        Map<Integer,Object> parametrosEntrada = new HashMap<>();
        parametrosEntrada.put(1, idEmpleado);
        int resultado = DBManager.getInstance().ejecutarProcedimiento("ELIMINAR_EMPLEADO", parametrosEntrada, null);
        System.out.println("Se ha realizado la eliminacion del empleado");
        return resultado;
    }

    @Override
    public Empleado obtenerPorId(int idEmpleado) {
        Empleado empleado = null;
        Map<Integer, Object> parametrosEntrada = new HashMap<>();
        parametrosEntrada.put(1, idEmpleado);
        rs = DBManager.getInstance().ejecutarProcedimientoLectura("OBTENER_EMPLEADO_X_ID", parametrosEntrada);
        System.out.println("Lectura de empleado...");
        try{
            while(rs.next()){
                if(empleado == null) empleado = new Empleado();
                empleado.setIdPersona(rs.getInt("id_empleado"));
                empleado.setDni(rs.getString("DNI"));
                empleado.setNombre(rs.getString("nombre"));
                empleado.setApellidoPaterno(rs.getString("apellido_paterno"));
                empleado.setSexo(rs.getString("sexo").charAt(0));
                empleado.setFechaNacimiento(rs.getDate("fecha_nacimiento"));
                empleado.setCargo(rs.getString("cargo"));
                empleado.setSueldo(rs.getDouble("sueldo"));
                
                Area area = new Area();
                area.setIdArea(rs.getInt("id_area"));
                area.setNombre(rs.getString("nombre_area"));
                
                empleado.setArea(area);
            }
        }catch(SQLException ex){
            System.out.println(ex.getMessage());
        }finally{
            DBManager.getInstance().cerrarConexion();
        }
        return empleado;
    }

    @Override
    public ArrayList<Empleado> listarTodos() {
        ArrayList<Empleado> empleados = null;
        rs = DBManager.getInstance().ejecutarProcedimientoLectura("LISTAR_EMPLEADOS_TODOS", null);
        System.out.println("Lectura de empleados...");
        try{
            while(rs.next()){
                if(empleados == null) empleados = new ArrayList<>();
                Empleado e = new Empleado();
                e.setIdPersona(rs.getInt("id_empleado"));
                e.setDni(rs.getString("DNI"));
                e.setNombre(rs.getString("nombre"));
                e.setApellidoPaterno(rs.getString("apellido_paterno"));
                e.setSexo(rs.getString("sexo").charAt(0));
                e.setFechaNacimiento(rs.getDate("fecha_nacimiento"));
                e.setCargo(rs.getString("cargo"));
                e.setSueldo(rs.getDouble("sueldo"));
                
                Area area = new Area();
                area.setIdArea(rs.getInt("id_area"));
                area.setNombre(rs.getString("nombre_area"));
                
                e.setArea(area);
                empleados.add(e);
            }
        }catch(SQLException ex){
            System.out.println(ex.getMessage());
        }finally{
            DBManager.getInstance().cerrarConexion();
        }
        return empleados;
    }
    
}
