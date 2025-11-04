package pe.edu.pucp.softprog.rrhh.model;

import jakarta.json.bind.adapter.JsonbAdapter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateAdapter implements JsonbAdapter<Date, String>{
    private static final String[] formatos = {
        "dd-MM-yyyy",
        "dd-MM-yyyy HH:mm:ss",
        "yyyy-MM-dd'T'HH:mm:ss.SSSX" //formato original
    };

    @Override
    public String adaptToJson(Date orgnl) throws Exception {
        return new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSSX").format(orgnl);
    }

    @Override
    public Date adaptFromJson(String adptd) throws Exception {
        try{
            long millis = Long.parseLong(adptd);
            Date fecha = new Date(millis);
            return fecha;
        }catch(NumberFormatException ex){
            System.out.println(ex.getMessage());
        }
        //En caso no sea posible realizar la conversion
        for(String format : formatos){
            try{
                return new SimpleDateFormat(format).parse(adptd);
            }catch(ParseException e){
                //intenta con el siguiente formato
            }
        }
        throw new RuntimeException("Formato de fecha invalido: " + adptd);
    }
}
