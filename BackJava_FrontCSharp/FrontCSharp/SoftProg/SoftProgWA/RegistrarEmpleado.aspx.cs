
using SoftProgWA.SoftProgServices;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Linq.Expressions;
using System.Web;
using System.Web.UI;
using System.Web.UI.WebControls;

namespace SoftProgWA
{
    public partial class RegistrarEmpleado : System.Web.UI.Page
    {
        private AreaWSClient boArea;
        private EmpleadoWSClient boEmpleado;
        private empleado empleado;
        private Estado estado;
        protected void Page_Load(object sender, EventArgs e)
        {
            if (!IsPostBack)
            {
                boArea = new AreaWSClient();
                ddlAreas.DataSource = boArea.listarAreasTodas();
                ddlAreas.DataTextField = "nombre";
                ddlAreas.DataValueField = "idArea";
                ddlAreas.DataBind();
            }

            String accion = Request.QueryString["accion"];
            if (accion == null)
            {
                empleado = new empleado();
                lblTitulo.Text = "Registrar Empleado";
                estado = Estado.Nuevo;
            }
            else if (accion == "modificar")
            {
                lblTitulo.Text = "Modificar Empleado";
                estado = Estado.Modificar;
                empleado = (empleado)Session["empleado"];
                if (!IsPostBack)
                    AsignarValores();
            }
            else if (accion == "ver")
            {
                lblTitulo.Text = "Ver Empleado";
                empleado = (empleado)Session["empleado"];
                AsignarValores();
                txtDNIEmpleado.Enabled = false;
                txtNombre.Enabled = false;
                txtApellidoPaterno.Enabled = false;
                txtCargo.Enabled = false;
                txtSueldo.Enabled = false;
                ddlAreas.Enabled = false;
                rbMasculino.Disabled = true;
                rbFemenino.Disabled = true;
                btnGuardar.Visible = false;
                dtpFechaNacimiento.Disabled = true;
            }
        }

        public void AsignarValores()
        {
            txtDNIEmpleado.Text = empleado.dni;
            txtNombre.Text = empleado.nombre;
            txtApellidoPaterno.Text = empleado.apellidoPaterno;
            ddlAreas.SelectedValue = empleado.area.idArea.ToString();
            if (empleado.sexo.Equals('M')) rbMasculino.Checked = true;
            else rbFemenino.Checked = true;
            dtpFechaNacimiento.Value = empleado.fechaNacimiento.ToString("yyyy-MM-dd");
            txtCargo.Text = empleado.cargo;
            txtSueldo.Text = empleado.sueldo.ToString("F2");
        }

        protected void btnGuardar_Click(object sender, EventArgs e)
        {
            boEmpleado = new EmpleadoWSClient();

            empleado.dni = txtDNIEmpleado.Text;
            empleado.nombre = txtNombre.Text;
            empleado.apellidoPaterno = txtApellidoPaterno.Text;
            area area = new area();
            area.idArea = Int32.Parse(ddlAreas.SelectedValue);
            empleado.area = area;
            try
            {
                empleado.fechaNacimiento = DateTime.Parse(dtpFechaNacimiento.Value);
                empleado.fechaNacimientoSpecified = true;
            }
            catch (Exception ex)
            {
                mostrarMensajeError("Debe elegir una fecha de nacimiento.");
                return;
            }
            if(!rbMasculino.Checked && !rbFemenino.Checked)
            {
                mostrarMensajeError("Debe seleccionar un sexo.");
                return;
            }    
            if (rbMasculino.Checked) empleado.sexo = 'M';
            else if (rbFemenino.Checked) empleado.sexo = 'F';
            try
            {
                empleado.sueldo = Double.Parse(txtSueldo.Text);
            }
            catch
            {
                mostrarMensajeError("Debe colocar un valor apropiado para el sueldo.");
                return;
            }
            empleado.cargo = txtCargo.Text;
            try
            {
                if (estado == Estado.Nuevo)
                    boEmpleado.insertarEmpleado(empleado);
                else if (estado == Estado.Modificar)
                    boEmpleado.modificarEmpleado(empleado);
            }catch(Exception ex)
            {
                mostrarMensajeError(ex.Message);
                return;
            }
            Response.Redirect("ListarEmpleados.aspx");
        }

        protected void btnRegresar_Click(object sender, EventArgs e)
        {
            Response.Redirect("ListarEmpleados.aspx");
        }

        public void mostrarMensajeError(String mensaje)
        {
            lblMensajeError.Text = mensaje;
            string script = "mostrarModalError();";
            ScriptManager.RegisterStartupScript(this, GetType(), "modalError", script, true);
        }

    }
}