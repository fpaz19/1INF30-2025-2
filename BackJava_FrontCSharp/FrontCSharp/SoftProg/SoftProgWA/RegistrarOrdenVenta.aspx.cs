
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
    public partial class RegistrarOrdenVenta : System.Web.UI.Page
    {
        private ClienteWSClient boCliente;
        private ProductoWSClient boProducto;
        private OrdenVentaWSClient boOrdenVenta;

        private cliente cliente;
        private producto producto;
        private ordenVenta ordenVenta;

        private BindingList<cliente> clientes;
        private BindingList<producto> productos;
        private BindingList<lineaOrdenVenta> lineasOrdenVenta;

        protected void Page_Load(object sender, EventArgs e)
        {
            boCliente = new ClienteWSClient();
            boProducto = new ProductoWSClient();
            boOrdenVenta = new OrdenVentaWSClient();

            ordenVenta = new ordenVenta();

            if (Session["cliente"] != null)
                cliente = (cliente)Session["cliente"];

            if (Session["producto"] != null)
                producto = (producto)Session["producto"];

            if (Session["lineasOrdenVenta"] == null)
                lineasOrdenVenta = new BindingList<lineaOrdenVenta>();
            else
                lineasOrdenVenta = (BindingList<lineaOrdenVenta>)Session["lineasOrdenVenta"];
        }

        protected void lbBuscarCliente_Click(object sender, EventArgs e)
        {
            string script = "mostrarModalCliente();";
            ScriptManager.RegisterStartupScript(this, GetType(), "mostrarModalCliente", script, true);
        }

        protected void lbBuscarProducto_Click(object sender, EventArgs e)
        {
            string script = "mostrarModalProducto();";
            ScriptManager.RegisterStartupScript(this, GetType(), "mostrarModalProducto", script, true);
        }

        protected void gvClientes_RowDataBound(object sender, GridViewRowEventArgs e)
        {
            if (e.Row.RowType == DataControlRowType.DataRow)
            {
                e.Row.Cells[0].Text = DataBinder.Eval(e.Row.DataItem, "DNI").ToString();
                e.Row.Cells[1].Text = DataBinder.Eval(e.Row.DataItem, "Nombre").ToString() + " " + DataBinder.Eval(e.Row.DataItem, "ApellidoPaterno").ToString();
            }
        }

        protected void gvLineasOrdenVenta_RowDataBound(object sender, GridViewRowEventArgs e)
        {
            if (e.Row.RowType == DataControlRowType.DataRow)
            {
                e.Row.Cells[0].Text = ((producto)DataBinder.Eval(e.Row.DataItem, "producto")).nombre + " " + ((producto)DataBinder.Eval(e.Row.DataItem, "producto")).unidadMedida;
                e.Row.Cells[1].Text = ((producto)DataBinder.Eval(e.Row.DataItem, "producto")).precio.ToString("F2");
                e.Row.Cells[2].Text = DataBinder.Eval(e.Row.DataItem, "cantidad").ToString();
                e.Row.Cells[3].Text = ((double)DataBinder.Eval(e.Row.DataItem, "subtotal")).ToString("F2");
            }
        }
        protected void gvProductos_RowDataBound(object sender, GridViewRowEventArgs e)
        {
            if (e.Row.RowType == DataControlRowType.DataRow)
            {
                e.Row.Cells[0].Text = DataBinder.Eval(e.Row.DataItem, "Nombre") + " " + DataBinder.Eval(e.Row.DataItem, "UnidadMedida");
                e.Row.Cells[1].Text = ((double)DataBinder.Eval(e.Row.DataItem, "Precio")).ToString("F2");
            }
        }

        protected void lbBusquedaClienteModal_Click(object sender, EventArgs e)
        {
            clientes = new BindingList<cliente>(boCliente.listarClientesPorDNIoNombre(txtDNINombreClienteModal.Text));
            Session["clientes"] = clientes;
            gvClientes.DataSource = clientes;
            gvClientes.DataBind();
        }

        protected void lbBusquedaProductoModal_Click(object sender, EventArgs e)
        {
            productos = new BindingList<producto>(boProducto.listarProductosPorNombre(txtDNINombreClienteModal.Text));
            Session["productos"] = productos;
            gvProductos.DataSource = productos;
            gvProductos.DataBind();
        }

        protected void lbSeleccionarCliente_Click(object sender, EventArgs e)
        {
            int idCliente = Int32.Parse(((LinkButton)sender).CommandArgument);
            cliente = ((BindingList<cliente>)Session["clientes"]).Single(x => x.idPersona == idCliente);
            Session["cliente"] = cliente;
            txtDNICliente.Text = cliente.dni;
            txtNombreCliente.Text = cliente.nombre + " " + cliente.apellidoPaterno;
            upContenedor.Update();
            string script = "cerrarModalCliente();";
            ScriptManager.RegisterStartupScript(this, GetType(), "cerrarModalCliente", script, true);
        }

        protected void lbSeleccionarProducto_Click(object sender, EventArgs e)
        {
            int idProducto = Int32.Parse(((LinkButton)sender).CommandArgument);
            producto = ((BindingList<producto>)Session["productos"]).Single(x => x.idProducto == idProducto);
            Session["producto"] = producto;
            txtIDProducto.Text = producto.idProducto.ToString();
            txtNombreProducto.Text = producto.nombre + " " + producto.unidadMedida;
            txtPrecioUnitProducto.Text = producto.precio.ToString("F2");
            upContenedor.Update();
            string script = "cerrarModalProducto();";
            ScriptManager.RegisterStartupScript(this, GetType(), "cerrarModalProducto", script, true);
        }

        protected void lbAgregarLOV_Click(object sender, EventArgs e)
        {
            if (Session["producto"] == null)
            {
                lblMensajeError.Text = "Debe seleccionar un producto.";
                string script = "mostrarModalFormError();";
                ScriptManager.RegisterStartupScript(this, GetType(), "ShowModalFormError", script, true);
                return;
            }
            if (txtCantidadUnidades.Text.Trim().Equals(""))
            {
                lblMensajeError.Text = "Debe ingresar una cantidad de unidades.";
                string script = "mostrarModalFormError();";
                ScriptManager.RegisterStartupScript(this, GetType(), "ShowModalFormError", script, true);
                return;
            }
            lineaOrdenVenta lov = new lineaOrdenVenta();
            int cantidad;
            try
            {
                cantidad = Int32.Parse(txtCantidadUnidades.Text);
            }
            catch (Exception ex)
            {
                lblMensajeError.Text = "La cantidad ingresada no es un número.";
                string script = "mostrarModalFormError();";
                ScriptManager.RegisterStartupScript(this, GetType(), "ShowModalFormError", script, true);
                return;
            }
            if (cantidad <= 0)
            {
                lblMensajeError.Text = "La cantidad ingresada no puede ser cero o negativo";
                string script = "mostrarModalFormError();";
                ScriptManager.RegisterStartupScript(this, GetType(), "ShowModalFormError", script, true);
                return;
            }
            lov.cantidad = cantidad;
            lov.producto = producto;
            lov.subtotal = lov.cantidad * lov.producto.precio;
            lineasOrdenVenta.Add(lov);
            Session["lineasOrdenVenta"] = lineasOrdenVenta;

            gvLineasOrdenVenta.DataSource = lineasOrdenVenta;
            gvLineasOrdenVenta.DataBind();

            calcularTotal();
            txtTotal.Text = ordenVenta.total.ToString("F2");

            txtIDProducto.Text = "";
            txtNombreProducto.Text = "";
            txtCantidadUnidades.Text = "";
            txtPrecioUnitProducto.Text = "";

            Session["producto"] = null;
        }

        public void calcularTotal()
        {
            double total = 0;
            foreach (lineaOrdenVenta lov in lineasOrdenVenta)
                total += lov.subtotal;
            ordenVenta.total = total;
        }

        protected void lbBorrarLOV_Click(object sender, EventArgs e)
        {
            int idProducto = Int32.Parse(((LinkButton)sender).CommandArgument);
            lineaOrdenVenta lov = ((BindingList<lineaOrdenVenta>)Session["lineasOrdenVenta"]).Single(x => x.producto.idProducto == idProducto);
            ((BindingList<lineaOrdenVenta>)Session["lineasOrdenVenta"]).Remove(lov);
            gvLineasOrdenVenta.DataSource = ((BindingList<lineaOrdenVenta>)Session["lineasOrdenVenta"]);
            gvLineasOrdenVenta.DataBind();

            calcularTotal();
            txtTotal.Text = ordenVenta.total.ToString("F2");
        }

        protected void btnGuardar_Click(object sender, EventArgs e)
        {
            if (Session["cliente"] == null)
            {
                lblMensajeError.Text = "Debe elegir un cliente.";
                string script = "showModalFormError();";
                ScriptManager.RegisterStartupScript(this, GetType(), "ShowModalFormError", script, true);
                return;
            }

            if (lineasOrdenVenta.Count == 0)
            {
                lblMensajeError.Text = "Debe agregar por lo menos un producto.";
                string script = "showModalFormError();";
                ScriptManager.RegisterStartupScript(this, GetType(), "ShowModalFormError", script, true);
                return;
            }

            ordenVenta.cliente = cliente;
            ordenVenta.lineasOrdenVenta = lineasOrdenVenta.ToArray();
            ////ordenVenta.Empleado = (Empleado)Session["Empleado"];
            ordenVenta.empleado = new empleado();
            ordenVenta.empleado.idPersona = 2;

            calcularTotal();

            int resultado = boOrdenVenta.insertarOrdenVenta(ordenVenta);
            if (resultado != 0)
                Response.Redirect("Home.aspx");
            else
                Response.Write("Ocurrio un error con el registro");
        }
    }
}