package pe.edu.pucp.softprog.services.gestclientes;

import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import java.util.ArrayList;
import pe.edu.pucp.softprog.gestclientes.bo.ClienteBOImpl;
import pe.edu.pucp.softprog.gestclientes.boi.IClienteBO;
import pe.edu.pucp.softprog.gestclientes.model.Cliente;

@Path("ClienteWR")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class ClienteWR {
    
    private IClienteBO boCliente;
    
    @GET
    @Path("listarPorDNIoNombre/{DNInombre}")
    public ArrayList<Cliente> listarPorDNIoNombre(@PathParam("DNInombre") String DNInombre){
        ArrayList<Cliente> clientes = null;
        try{
            boCliente = new ClienteBOImpl();
            clientes = boCliente.listarPorDNIoNombre(DNInombre);
        }catch(Exception ex){
            System.out.println(ex.getMessage());
        }
        return clientes;
    }
    
    @GET
    @Path("listarTodos")
    public ArrayList<Cliente> listarTodos(){
        ArrayList<Cliente> clientes = null;
        try{
            boCliente = new ClienteBOImpl();
            clientes = boCliente.listarTodos();
        }catch(Exception ex){
            System.out.println(ex.getMessage());
        }
        return clientes;
    }
}
