package pe.edu.pucp.softprog.services.gestclientes;

import com.fasterxml.jackson.core.type.TypeReference;
import jakarta.jws.WebService;
import jakarta.jws.WebMethod;
import jakarta.jws.WebParam;
import java.io.IOException;
import java.util.ArrayList;
import pe.edu.pucp.softprog.gestclientes.model.Cliente;
import pe.edu.pucp.softprog.services.base.HttpJsonClient;

@WebService(serviceName = "ClienteWS", targetNamespace = "pe.edu.pucp.softprog.services")
public class ClienteWS {

    private static final String BASE_URL = "http://localhost:8080/SoftProgWR/webresources/ClienteWR";
    
    @WebMethod(operationName = "listarClientesPorDNIoNombre")
    public ArrayList<Cliente> listarClientesPorDNIoNombre(@WebParam(name = "DNIoNombre") String DNIoNombre) {
        ArrayList<Cliente> clientes = null;
        try {
            if (DNIoNombre == null || DNIoNombre.trim().isEmpty()) {
                clientes = HttpJsonClient.get(BASE_URL + "/listarTodos", new TypeReference<ArrayList<Cliente>>() {
                });
            } else {
                clientes = HttpJsonClient.get(BASE_URL + "/listarPorDNIoNombre/" + DNIoNombre, new TypeReference<ArrayList<Cliente>>() {
                });
            }
        } catch (IOException | InterruptedException ex) {
            System.out.println("Error al obtener clientes por DNI Nombre: " + ex.getMessage());
        }
        return clientes;
    }
}
