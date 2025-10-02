using SoftProgBusiness.RRHH.BOI;
using SoftProgModel.RRHH;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.UI;
using System.Web.UI.WebControls;

namespace SoftProgWA
{
    public partial class RegistrarArea : System.Web.UI.Page
    {
        private AreaBOImpl boArea;
        private Area area;

        protected void Page_Load(object sender, EventArgs e)
        {
            String accion
                = Request.QueryString["accion"];
            if (accion == null)
            {
                //Registro
                lblTitulo.Text = "Registrar Area";
            }
            else if(accion == "modificar")
            {
                //Modificacion
                lblTitulo.Text = "Modificar Area";
                Area area = (Area)Session["area"];
                txtNombre.Text = area.Nombre;
                txtIDArea.Text = area.IdArea.ToString();
            }
        }

        protected void lbGuardar_Click(object sender, EventArgs e)
        {
            boArea = new AreaBOImpl();
            
            area = new Area();
            area.Nombre = txtNombre.Text;

            boArea.insertar(area);

            Response.Redirect("ListarAreas.aspx");
        }
    }
}