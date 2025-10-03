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
        private Estado estado;

        protected void Page_Load(object sender, EventArgs e)
        {
            String accion = Request.QueryString["accion"];
            if (accion == null)
            {
                //Registro
                area = new Area();
                lblTitulo.Text = "Registrar Area";
                estado = Estado.Nuevo;
            }
            else if (accion == "modificar")
            {
                //Modificacion
                lblTitulo.Text = "Modificar Area";
                area = (Area)Session["area"];
                if (!IsPostBack)
                {
                    txtNombre.Text = area.Nombre;
                    txtIDArea.Text = area.IdArea.ToString();
                }
                estado = Estado.Modificar;
            }
        }

        protected void lbGuardar_Click(object sender, EventArgs e)
        {
            boArea = new AreaBOImpl();
            area.Nombre = txtNombre.Text;
            try
            {
                if (estado == Estado.Nuevo)
                    boArea.insertar(area);
                else if (estado == Estado.Modificar)
                    boArea.modificar(area);
            }catch(Exception ex)
            {
                lblMensajeError.Text = ex.Message;
                string script = "mostrarModalError();";
                ScriptManager.RegisterStartupScript(this,GetType(),"modalError",script,true);
                return;
            }
            Response.Redirect("ListarAreas.aspx");
        }

        protected void lbRegresar_Click(object sender, EventArgs e)
        {
            Response.Redirect("ListarAreas.aspx");
        }
    }
}