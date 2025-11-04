package pe.edu.pucp.softprog.services;

import jakarta.jws.WebService;
import jakarta.jws.WebMethod;
import jakarta.jws.WebParam;

@WebService(serviceName = "ServiceWS", targetNamespace = "pe.edu.pucp.softprog.services")
public class ServiceWS {

    @WebMethod(operationName = "hello")
    public String hello(@WebParam(name = "name") 
            String name) {
        return "Hello " + name + " !";
    }
    
    @WebMethod(operationName = "sumar")
    public int sumar(@WebParam(name = "a") int a,
            @WebParam(name = "b") int b){
        return a + b;
    }
    
    @WebMethod(operationName = "restar")
    public int restar(@WebParam(name = "a") int a,
            @WebParam(name = "b") int b){
        return a - b;
    }
}
