package pe.edu.pucp.softprog.services.reportes;

import jakarta.jws.WebService;
import jakarta.jws.WebMethod;
import jakarta.jws.WebParam;
import java.awt.Image;
import java.io.UnsupportedEncodingException;
import java.net.URL;
import java.net.URLDecoder;
import java.sql.Connection;
import java.util.HashMap;
import javax.swing.ImageIcon;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.util.JRLoader;
import pe.edu.pucp.softprog.config.DBManager;

@WebService(serviceName = "ReporteWS",
        targetNamespace = "pe.edu.pucp.softprog.services")
public class ReporteWS {

    public ReporteWS(){
        System.setProperty("user.language", "es");
        System.setProperty("user.country", "PE");
        System.setProperty("user.timezone", "GMT-5");
    }
    
    @WebMethod(operationName = "generarReporte")
    public byte[] generarReporte(@WebParam(name = "nombre") String nombre) {
        byte[] reporte = null;
        try{
            //Referenciamos el archivo Jasper
            JasperReport jr = (JasperReport) JRLoader.loadObject(getClass().getResourceAsStream("/pe/edu/pucp/softprog/reports/ReporteEjemplo.jasper"));
            
            //Referenciamos la imagen del logo y los subreportes
            URL rutaURLImagen = getClass().getResource("/pe/edu/pucp/softprog/images/pikachu.png");
            URL rutaURLSubreporteEmpleados = getClass().getResource("/pe/edu/pucp/softprog/reports/SubReporteEmpleados.jasper");
            URL rutaURLSubreporteGrafico = getClass().getResource("/pe/edu/pucp/softprog/reports/SubReporteGrafico.jasper");
            
            //Generamos los objetos necesarios en el reporte
            String rutaSubReporteGrafico = URLDecoder.decode(rutaURLSubreporteGrafico.getPath(), "UTF-8");
            String rutaSubReporteEmpleados = URLDecoder.decode(rutaURLSubreporteEmpleados.getPath(), "UTF-8");
            String rutaImagen = URLDecoder.decode(rutaURLImagen.getPath(), "UTF-8");
            Image imagen = (new ImageIcon(rutaImagen)).getImage();
            
            //Establecemos los parametros que necesita el reporte
            HashMap hm = new HashMap();
            hm.put("nombre", nombre);
            hm.put("logo", imagen);
            hm.put("rutaSubreporteEmpleados", rutaSubReporteEmpleados);
            hm.put("rutaSubreporteGrafico",rutaSubReporteGrafico);
            
            //Establecemos la conexión
            Connection con = DBManager.getInstance().getConnection();
            
            //Poblamos el reporte
            JasperPrint jp = JasperFillManager.fillReport(jr,hm,con);
            
            //Convertirmos el reporte a un arreglo de byte
            reporte = JasperExportManager.exportReportToPdf(jp);
        }catch(UnsupportedEncodingException | JRException ex){
            System.out.println("ERROR AL GENERAR EL REPORTE:" + ex.getMessage());
        }finally{
            DBManager.getInstance().cerrarConexion();
        }
        return reporte;
    }
}
