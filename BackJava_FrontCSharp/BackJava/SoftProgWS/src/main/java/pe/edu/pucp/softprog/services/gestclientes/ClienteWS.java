package pe.edu.pucp.softprog.services.gestclientes;

import jakarta.jws.WebService;
import jakarta.jws.WebMethod;
import jakarta.jws.WebParam;
import java.util.ArrayList;
import pe.edu.pucp.softprog.gestclientes.bo.ClienteBOImpl;
import pe.edu.pucp.softprog.gestclientes.boi.IClienteBO;
import pe.edu.pucp.softprog.gestclientes.model.Cliente;

@WebService(serviceName = "ClienteWS",
        targetNamespace = "pe.edu.pucp.softprog.services")
public class ClienteWS {

    private IClienteBO boCliente;
       
    @WebMethod(operationName = "listarClientesPorDNIoNombre")
    public ArrayList<Cliente> listarClientesPorDNIoNombre(@WebParam(name = "DNIoNombre") String DNIoNombre) {
        ArrayList<Cliente> clientes = null;
        try{
           boCliente = new ClienteBOImpl();
           clientes = boCliente.listarPorDNIoNombre(DNIoNombre);
        }catch(Exception ex){
            System.out.println(ex.getMessage());
        }
        return clientes;
    }
}
