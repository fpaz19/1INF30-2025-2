using SoftProgWA.SoftProgServices;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.UI;
using System.Web.UI.WebControls;

namespace SoftProgWA
{
    public partial class VisualizarReporte : System.Web.UI.Page
    {
        private ReporteWSClient boReporte;
        protected void Page_Load(object sender, EventArgs e)
        {
            boReporte = new ReporteWSClient();
            empleado empleado = null;
            byte[] reporte = null;
            if (Session["empleadoLog"] != null)
            {
                empleado = (empleado)Session["empleadoLog"];
                reporte = boReporte.generarReporte(empleado.nombre + " " + empleado.apellidoPaterno);
            }
            else
            {
                reporte = boReporte.generarReporte("");
            }
                Response.Clear();
            Response.ContentType = "application/pdf";
            Response.AddHeader("Content-Disposition","inline;filename=ReporteAreasEmpleados.pdf");
            Response.BinaryWrite(reporte);
            Response.End();
        }
    }
}