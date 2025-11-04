package pe.edu.pucp.softprog.services.rrhh;

import jakarta.jws.WebService;
import jakarta.jws.WebMethod;
import jakarta.jws.WebParam;
import java.io.IOException;
import pe.edu.pucp.softprog.rrhh.model.CuentaUsuario;
import pe.edu.pucp.softprog.services.base.HttpJsonClient;

@WebService(serviceName = "CuentaUsuarioWS", targetNamespace = "pe.edu.pucp.softprog.services")
public class CuentaUsuarioWS {

    private static final String BASE_URL = "http://localhost:8080/SoftProgWR/webresources/CuentaUsuarioWR";
    
    @WebMethod(operationName = "verificarCuentaUsuario")
    public int verificarCuentaUsuario(@WebParam(name = "cuentaUsuario") CuentaUsuario cuentaUsuario) {
        int resultado = 0;
        try{
            resultado = HttpJsonClient.post(BASE_URL + "/verificar", cuentaUsuario);
        }catch(IOException | InterruptedException ex){
            System.out.println("Error al insertar area: " + ex.getMessage());
        }
        return resultado;
    }
}
