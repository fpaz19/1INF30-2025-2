package pe.edu.pucp.softprog.softprogclientrest;

import com.fasterxml.jackson.core.type.TypeReference;
import java.net.http.HttpClient;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.IOException;
import java.net.URI;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.ArrayList;
import pe.edu.pucp.softprog.rrhh.model.Area;

public class SoftProgClientREST {

    private static HttpClient client = HttpClient.newHttpClient();
    private static ObjectMapper mapper = createDefaultMapper();
    
    public static void main(String[] args) {
        ArrayList<Area> areas = null;
        try{
            HttpRequest request = HttpRequest.newBuilder().uri(URI.create("http://127.0.0.1:8080/SoftProgRS/webresources/AreaRS/listarTodas")).GET().build();
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
            areas = mapper.readValue(response.body(), new TypeReference<ArrayList<Area>>(){});
        }catch(IOException | InterruptedException ex){
            System.out.println(ex.getMessage());
        }
        for(Area a : areas){
           System.out.println(a.getIdArea() + ". " + a.getNombre());
        }
    }
    
    public static ObjectMapper createDefaultMapper(){
        ObjectMapper mapper = new ObjectMapper();
        return mapper;
    }
}
