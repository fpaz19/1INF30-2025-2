
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
    public partial class ListarEmpleados : System.Web.UI.Page
    {
        private EmpleadoWSClient boEmpleado;
        private BindingList<empleado> empleados;
        protected void Page_Load(object sender, EventArgs e)
        {
            boEmpleado = new EmpleadoWSClient();
            empleados = new BindingList<empleado>(boEmpleado.listarEmpleadosTodos());
            dgvEmpleados.DataSource = empleados;
            dgvEmpleados.DataBind();
        }

        protected void lbBuscar_Click(object sender, EventArgs e)
        {

        }

        protected void lbRegistrar_Click(object sender, EventArgs e)
        {
            Response.Redirect("RegistrarEmpleado.aspx");
        }

        protected void dgvEmpleados_RowDataBound(object sender, GridViewRowEventArgs e)
        {
            if (e.Row.RowType == DataControlRowType.DataRow)
            {
                e.Row.Cells[0].Text = DataBinder.Eval(e.Row.DataItem, "dni").ToString();
                e.Row.Cells[1].Text = DataBinder.Eval(e.Row.DataItem, "nombre").ToString() + " " + DataBinder.Eval(e.Row.DataItem, "apellidoPaterno").ToString();
                e.Row.Cells[2].Text = ((area)DataBinder.Eval(e.Row.DataItem, "area")).nombre.ToString();
            }
        }

        protected void dgvEmpleados_PageIndexChanging(object sender, GridViewPageEventArgs e)
        {
            dgvEmpleados.PageIndex = e.NewPageIndex;
            dgvEmpleados.DataBind();
        }

        protected void btnModificar_Click(object sender, EventArgs e)
        {
            int idEmpleado = Int32.Parse(((LinkButton)sender).CommandArgument);
            empleado empleadoSeleccionado = empleados.Single(x => x.idPersona == idEmpleado);
            Session["empleado"] = empleadoSeleccionado;
            Response.Redirect("RegistrarEmpleado.aspx?accion=modificar");
        }

        protected void btnEliminar_Click(object sender, EventArgs e)
        {
            int idEmpleado = Int32.Parse(((LinkButton)sender).CommandArgument);
            boEmpleado.eliminarEmpleado(idEmpleado);
            Response.Redirect("ListarEmpleados.aspx");
        }

        protected void btnVisualizar_Click(object sender, EventArgs e)
        {
            int idEmpleado = Int32.Parse(((LinkButton)sender).CommandArgument);
            empleado empleadoSeleccionado = empleados.Single(x => x.idPersona == idEmpleado);
            Session["empleado"] = empleadoSeleccionado;
            Response.Redirect("RegistrarEmpleado.aspx?accion=ver");
        }
    }
}