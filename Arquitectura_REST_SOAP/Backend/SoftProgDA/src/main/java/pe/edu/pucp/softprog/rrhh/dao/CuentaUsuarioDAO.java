package pe.edu.pucp.softprog.rrhh.dao;

import pe.edu.pucp.softprog.dao.IDAO;
import pe.edu.pucp.softprog.rrhh.model.CuentaUsuario;

public interface CuentaUsuarioDAO extends IDAO<CuentaUsuario>{
    int verificar(CuentaUsuario cuentaUsuario);
}
