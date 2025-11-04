package pe.edu.pucp.softprog.rrhh.mysql;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import pe.edu.pucp.softprog.config.DBManager;
import pe.edu.pucp.softprog.rrhh.dao.CuentaUsuarioDAO;
import pe.edu.pucp.softprog.rrhh.model.CuentaUsuario;

public class CuentaUsuarioImpl implements CuentaUsuarioDAO{

    private ResultSet rs;
    
    @Override
    public int verificar(CuentaUsuario cuentaUsuario) {
        int resultado = 0;
        Map<Integer,Object> parametrosEntrada = new HashMap<>();
        parametrosEntrada.put(1, cuentaUsuario.getUsername());
        parametrosEntrada.put(2, cuentaUsuario.getPassword());
        rs = DBManager.getInstance().ejecutarProcedimientoLectura("VERIFICAR_CUENTA_USUARIO", parametrosEntrada);
        try{
            if(rs.next()){
                resultado = rs.getInt("fid_empleado");
            }
        }catch(SQLException ex){
            System.out.println(ex.getMessage());
        }finally{
            DBManager.getInstance().cerrarConexion();
        }
        System.out.println("Se esta verificando la cuenta de usuario...");
        return resultado;
    }

    @Override
    public int insertar(CuentaUsuario objeto) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public int modificar(CuentaUsuario objeto) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public int eliminar(int idObjeto) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public CuentaUsuario obtenerPorId(int idObjeto) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public ArrayList<CuentaUsuario> listarTodos() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
}
