package pe.edu.pucp.softprog.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.awt.Image;
import java.net.URL;
import java.net.URLDecoder;
import java.sql.Connection;
import java.util.HashMap;
import javax.swing.ImageIcon;
import net.sf.jasperreports.engine.JREmptyDataSource;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.util.JRLoader;
import pe.edu.pucp.softprog.config.DBManager;

public class ReporteEjemplo extends HttpServlet {

    public ReporteEjemplo(){
        System.setProperty("user.language", "es");
        System.setProperty("user.country", "PE");
        System.setProperty("user.timezone", "GMT-5");
    }
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
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
            hm.put("nombre", "FREDDY");
            hm.put("logo", imagen);
            hm.put("rutaSubreporteEmpleados", rutaSubReporteEmpleados);
            hm.put("rutaSubreporteGrafico",rutaSubReporteGrafico);
            
            //Establecemos la conexión
            Connection con = DBManager.getInstance().getConnection();
            
            //Poblamos el reporte
            JasperPrint jp = JasperFillManager.fillReport(jr,hm,con);
            
            //Mostramos por pantalla
            JasperExportManager.exportReportToPdfStream(jp,response.getOutputStream());
        }catch(IOException | JRException ex){
            System.out.println("ERROR GENERANDO EL REPORTE:" + ex.getMessage());
        }finally{
            DBManager.getInstance().cerrarConexion();
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }

}
