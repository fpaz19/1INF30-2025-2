package pe.edu.pucp.softprog.rrhh.mysql;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Types;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import pe.edu.pucp.softprog.config.DBManager;
import pe.edu.pucp.softprog.rrhh.dao.AreaDAO;
import pe.edu.pucp.softprog.rrhh.model.Area;

public class AreaImpl implements AreaDAO{

    private ResultSet rs;
    
    @Override
    public int insertar(Area area) {
        Map<Integer,Object> parametrosSalida = new HashMap<>();
        Map<Integer,Object> parametrosEntrada = new HashMap<>();
        parametrosSalida.put(1, Types.INTEGER);
        parametrosEntrada.put(2, area.getNombre());
        DBManager.getInstance().ejecutarProcedimiento("INSERTAR_AREA", parametrosEntrada, parametrosSalida);
        area.setIdArea((int) parametrosSalida.get(1));
        System.out.println("Se ha realizado el registro del area");
        return area.getIdArea();
    }

    @Override
    public int modificar(Area area) {
        Map<Integer, Object> parametrosEntrada = new HashMap<>();
        parametrosEntrada.put(1, area.getIdArea());
        parametrosEntrada.put(2, area.getNombre());
        int resultado = DBManager.getInstance().ejecutarProcedimiento("MODIFICAR_AREA", parametrosEntrada, null);
        System.out.println("Se ha realizado la modificacion del area");
        return resultado;
    }

    @Override
    public int eliminar(int idArea) {
        Map<Integer, Object> parametrosEntrada = new HashMap<>();
        parametrosEntrada.put(1, idArea);
        int resultado = DBManager.getInstance().ejecutarProcedimiento("ELIMINAR_AREA", parametrosEntrada, null);
        System.out.println("Se ha realizado la eliminacion del area");
        return resultado;
    }

    @Override
    public Area obtenerPorId(int idArea) {
        Area area = null;
        Map<Integer, Object> parametrosEntrada = new HashMap<>();
        parametrosEntrada.put(1, idArea);
        rs = DBManager.getInstance().ejecutarProcedimientoLectura("OBTENER_AREA_X_ID", parametrosEntrada);
        System.out.println("Lectura de area...");
        try{
            if(rs.next()){
                area = new Area();
                area.setIdArea(rs.getInt("id_area"));
                area.setNombre(rs.getString("nombre"));
                area.setActivo(true);
            }
        }catch(SQLException ex){
            System.out.println("ERROR: " + ex.getMessage());
        }finally{
            DBManager.getInstance().cerrarConexion();
        }
        return area;
    }

    @Override
    public ArrayList<Area> listarTodos() {
        ArrayList<Area> areas = null;
        rs = DBManager.getInstance().ejecutarProcedimientoLectura("LISTAR_AREAS_TODAS", null);
        System.out.println("Lectura de todas las areas...");
        try{
            while(rs.next()){
                if(areas == null) areas = new ArrayList<>();
                Area area = new Area();
                area.setIdArea(rs.getInt("id_area"));
                area.setNombre(rs.getString("nombre"));
                area.setActivo(true);
                areas.add(area);
            }
        }catch(SQLException ex){
            System.out.println("ERROR: " + ex.getMessage());
        }finally{
            DBManager.getInstance().cerrarConexion();
        }
        return areas;
    }
    
}