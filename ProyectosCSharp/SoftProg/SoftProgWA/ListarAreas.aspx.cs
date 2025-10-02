using SoftProgBusiness.RRHH.BOI;
using SoftProgModel.RRHH;
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
        private AreaBOImpl boArea;
        private BindingList<Area> areas;
        protected void Page_Load(object sender, EventArgs e)
        {
            boArea = new AreaBOImpl();
            areas = boArea.listarTodos();
            gvAreas.DataSource = areas;


            gvAreas.DataBind();
        }

        protected void lkRegistrar_Click(object sender, EventArgs e)
        {
            Response.Redirect("RegistrarArea.aspx");
        }

        protected void lkModificar_Click(object sender, EventArgs e)
        {
            int idArea = Int32.Parse(
                ((LinkButton)sender).CommandArgument);
            Area
                areaSeleccionada =
                areas.Single(x =>
                x.IdArea == idArea);
            Session["area"] = areaSeleccionada;
            Response.Redirect("RegistrarArea.aspx" +
                "?accion=modificar");
        }
    }
}