

using SoftProgWA.SoftProgServices;
using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Linq;
using System.Web;
using System.Web.UI;
using System.Web.UI.WebControls;

namespace SoftProgWA
{
    public partial class ListarAreas : System.Web.UI.Page
    {
        private AreaWSClient boArea;
        private BindingList<area> areas;
        protected void Page_Load(object sender, EventArgs e)
        {
            boArea = new AreaWSClient();
            areas = new BindingList<area>(boArea.listarAreasTodas());
            gvAreas.DataSource = areas;
            gvAreas.DataBind();
        }

        protected void lkRegistrar_Click(object sender, EventArgs e)
        {
            Response.Redirect("RegistrarArea.aspx");
        }

        protected void lkModificar_Click(object sender, EventArgs e)
        {
            int idArea = Int32.Parse(((LinkButton)sender).CommandArgument);
            area areaSeleccionada = areas.Single(x => x.idArea == idArea);
            Session["area"] = areaSeleccionada;
            Response.Redirect("RegistrarArea.aspx?accion=modificar");
        }

        protected void lkEliminar_Click(object sender, EventArgs e)
        {
            int idArea = Int32.Parse(((LinkButton)sender).CommandArgument);
            boArea.eliminarArea(idArea);
            Response.Redirect("ListarAreas.aspx");
        }
    }
}