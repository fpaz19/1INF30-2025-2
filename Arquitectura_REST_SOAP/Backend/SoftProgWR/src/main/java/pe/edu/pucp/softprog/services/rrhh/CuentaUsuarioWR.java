package pe.edu.pucp.softprog.services.rrhh;

import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import pe.edu.pucp.softprog.rrhh.bo.CuentaUsuarioBOImpl;
import pe.edu.pucp.softprog.rrhh.boi.ICuentaUsuarioBO;
import pe.edu.pucp.softprog.rrhh.model.CuentaUsuario;

@Path("CuentaUsuarioWR")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class CuentaUsuarioWR {
    
    private ICuentaUsuarioBO boCuentaUsuario;
    
    @POST
    @Path("verificar")
    public int verificar(CuentaUsuario cuentaUsuario){
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
