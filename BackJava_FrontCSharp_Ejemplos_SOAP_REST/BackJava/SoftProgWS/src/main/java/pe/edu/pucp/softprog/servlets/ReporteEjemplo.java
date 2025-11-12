package pe.edu.pucp.softprog.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.awt.Image;
import java.net.URL;
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

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try{
            Connection con = DBManager.getInstance()
                    .getConnection();
            JasperReport jr
            = (JasperReport)
                JRLoader.loadObject(getClass().
                    getResourceAsStream
        ("/pe/edu/pucp/softprog/reports/"
                + "ReporteEjemplo.jasper"));
            
            
            URL rutaImagen
            = getClass().getResource
        ("/pe/edu/pucp/softprog/images/pikachu.png");
            
            Image imagen =
            (new ImageIcon(rutaImagen)).getImage();
            
            HashMap hm = new HashMap();
            hm.put("nombre", "FREDDY");
            hm.put("logo", imagen);
            
            JasperPrint jp
            = JasperFillManager.fillReport(jr,hm,
                    con);
            JasperExportManager.exportReportToPdfStream(jp,
                    response.getOutputStream());
        }catch(IOException | JRException ex){
            System.out.println("ERROR GENERANDO EL REPORTE:" +
                    ex.getMessage());
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
