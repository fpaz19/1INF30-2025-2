package pe.edu.pucp.softprog.services.rrhh;

import jakarta.jws.WebService;
import jakarta.jws.WebMethod;
import jakarta.jws.WebParam;
import pe.edu.pucp.softprog.rrhh.bo.CuentaUsuarioBOImpl;
import pe.edu.pucp.softprog.rrhh.boi.ICuentaUsuarioBO;
import pe.edu.pucp.softprog.rrhh.model.CuentaUsuario;

@WebService(serviceName = "CuentaUsuarioWS", 
        targetNamespace = "pe.edu.pucp.softprog.services")
public class CuentaUsuarioWS {

    private ICuentaUsuarioBO boCuentaUsuario;
    
    @WebMethod(operationName = "verificarCuentaUsuario")
    public int verificarCuentaUsuario(@WebParam(name = "cuentaUsuario") CuentaUsuario cuentaUsuario) {
        int resultado = 0;
        try{
            boCuentaUsuario = new CuentaUsuarioBOImpl();
            resultado = boCuentaUsuario.verificar(cuentaUsuario);
        }catch(Exception ex){
            System.out.println(ex.getMessage());
        }
        return resultado;
    }
}
