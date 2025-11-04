package pe.edu.pucp.softprog.rrhh.boi;

import pe.edu.pucp.softprog.bo.IBaseBO;
import pe.edu.pucp.softprog.rrhh.model.CuentaUsuario;

public interface ICuentaUsuarioBO extends IBaseBO<CuentaUsuario>{
    int verificar(CuentaUsuario cuentaUsuario);
}
