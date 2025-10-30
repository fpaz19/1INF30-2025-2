package pe.edu.pucp.softprog.rrhh.bo;

import java.util.ArrayList;
import pe.edu.pucp.softprog.rrhh.boi.ICuentaUsuarioBO;
import pe.edu.pucp.softprog.rrhh.dao.CuentaUsuarioDAO;
import pe.edu.pucp.softprog.rrhh.model.CuentaUsuario;
import pe.edu.pucp.softprog.rrhh.mysql.CuentaUsuarioImpl;

public class CuentaUsuarioBOImpl implements ICuentaUsuarioBO{

    private CuentaUsuarioDAO daoCuentaUsuario;
    
    public CuentaUsuarioBOImpl(){
        daoCuentaUsuario = new CuentaUsuarioImpl();
    }
    
    @Override
    public int verificar(CuentaUsuario cuentaUsuario) {
        return daoCuentaUsuario.verificar(cuentaUsuario);
    }

    @Override
    public int insertar(CuentaUsuario objeto) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public int modificar(CuentaUsuario objeto) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public int eliminar(int idObjeto) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public CuentaUsuario obtenerPorId(int idObjeto) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public ArrayList<CuentaUsuario> listarTodos() throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void validar(CuentaUsuario objeto) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
}
