
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
        //private ClienteBOImpl boCliente;
        //private ProductoBOImpl boProducto;
        //private OrdenVentaBOImpl boOrdenVenta;

        //private Cliente cliente;
        //private Producto producto;
        //private OrdenVenta ordenVenta;

        //private BindingList<Cliente> clientes;
        //private BindingList<Producto> productos;
        //private BindingList<LineaOrdenVenta> lineasOrdenVenta;

        protected void Page_Load(object sender, EventArgs e)
        {
            //boCliente = new ClienteBOImpl();
            //boProducto = new ProductoBOImpl();
            //boOrdenVenta = new OrdenVentaBOImpl();

            //ordenVenta = new OrdenVenta();

            //if (Session["cliente"] != null)
            //    cliente = (Cliente)Session["cliente"];

            //if (Session["producto"] != null)
            //    producto = (Producto)Session["producto"];

            //if (Session["lineasOrdenVenta"] == null)
            //    lineasOrdenVenta = new BindingList<LineaOrdenVenta>();
            //else
            //    lineasOrdenVenta = (BindingList<LineaOrdenVenta>)Session["lineasOrdenVenta"];
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
                //e.Row.Cells[0].Text = ((Producto)DataBinder.Eval(e.Row.DataItem, "producto")).Nombre + " " + ((Producto)DataBinder.Eval(e.Row.DataItem, "producto")).UnidadMedida;
                //e.Row.Cells[1].Text = ((Producto)DataBinder.Eval(e.Row.DataItem, "producto")).Precio.ToString("F2");
                //e.Row.Cells[2].Text = DataBinder.Eval(e.Row.DataItem, "cantidad").ToString();
                //e.Row.Cells[3].Text = ((double)DataBinder.Eval(e.Row.DataItem, "subtotal")).ToString("F2");
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
            //clientes = boCliente.listarPorDNIoNombre(txtDNINombreClienteModal.Text);
            //Session["clientes"] = clientes;
            //gvClientes.DataSource = clientes;
            //gvClientes.DataBind();
        }

        protected void lbBusquedaProductoModal_Click(object sender, EventArgs e)
        {
            //productos = boProducto.listarPorNombre(txtDNINombreClienteModal.Text);
            //Session["productos"] = productos;
            //gvProductos.DataSource = productos;
            //gvProductos.DataBind();
        }

        protected void lbSeleccionarCliente_Click(object sender, EventArgs e)
        {
            //int idCliente = Int32.Parse(((LinkButton)sender).CommandArgument);
            //cliente = ((BindingList<Cliente>)Session["clientes"]).Single(x => x.IdPersona == idCliente);
            //Session["cliente"] = cliente;
            //txtDNICliente.Text = cliente.DNI;
            //txtNombreCliente.Text = cliente.Nombre + " " + cliente.ApellidoPaterno;
            //upContenedor.Update();
            //string script = "cerrarModalCliente();";
            //ScriptManager.RegisterStartupScript(this, GetType(), "cerrarModalCliente", script, true);
        }

        protected void lbSeleccionarProducto_Click(object sender, EventArgs e)
        {
            //int idProducto = Int32.Parse(((LinkButton)sender).CommandArgument);
            //producto = ((BindingList<Producto>)Session["productos"]).Single(x => x.IdProducto == idProducto);
            //Session["producto"] = producto;
            //txtIDProducto.Text = producto.IdProducto.ToString();
            //txtNombreProducto.Text = producto.Nombre + " " + producto.UnidadMedida;
            //txtPrecioUnitProducto.Text = producto.Precio.ToString("F2");
            //upContenedor.Update();
            //string script = "cerrarModalProducto();";
            //ScriptManager.RegisterStartupScript(this, GetType(), "cerrarModalProducto", script, true);
        }

        protected void lbAgregarLOV_Click(object sender, EventArgs e)
        {
            //if (Session["producto"] == null)
            //{
            //    lblMensajeError.Text = "Debe seleccionar un producto.";
            //    string script = "mostrarModalFormError();";
            //    ScriptManager.RegisterStartupScript(this, GetType(), "ShowModalFormError", script, true);
            //    return;
            //}
            //if (txtCantidadUnidades.Text.Trim().Equals(""))
            //{
            //    lblMensajeError.Text = "Debe ingresar una cantidad de unidades.";
            //    string script = "mostrarModalFormError();";
            //    ScriptManager.RegisterStartupScript(this, GetType(), "ShowModalFormError", script, true);
            //    return;
            //}
            //LineaOrdenVenta lov = new LineaOrdenVenta();
            //int cantidad;
            //try
            //{
            //    cantidad = Int32.Parse(txtCantidadUnidades.Text);
            //}
            //catch (Exception ex)
            //{
            //    lblMensajeError.Text = "La cantidad ingresada no es un número.";
            //    string script = "mostrarModalFormError();";
            //    ScriptManager.RegisterStartupScript(this, GetType(), "ShowModalFormError", script, true);
            //    return;
            //}
            //if (cantidad <= 0)
            //{
            //    lblMensajeError.Text = "La cantidad ingresada no puede ser cero o negativo";
            //    string script = "mostrarModalFormError();";
            //    ScriptManager.RegisterStartupScript(this, GetType(), "ShowModalFormError", script, true);
            //    return;
            //}
            //lov.Cantidad = cantidad;
            //lov.Producto = producto;
            //lov.Subtotal = lov.Cantidad * lov.Producto.Precio;
            //lineasOrdenVenta.Add(lov);
            //Session["lineasOrdenVenta"] = lineasOrdenVenta;

            //gvLineasOrdenVenta.DataSource = lineasOrdenVenta;
            //gvLineasOrdenVenta.DataBind();

            //calcularTotal();
            //txtTotal.Text = ordenVenta.Total.ToString("F2");

            //txtIDProducto.Text = "";
            //txtNombreProducto.Text = "";
            //txtCantidadUnidades.Text = "";
            //txtPrecioUnitProducto.Text = "";

            //Session["producto"] = null;
        }

        public void calcularTotal()
        {
            //double total = 0;
            //foreach (LineaOrdenVenta lov in lineasOrdenVenta)
            //    total += lov.Subtotal;
            //ordenVenta.Total = total;
        }

        protected void lbBorrarLOV_Click(object sender, EventArgs e)
        {
            //int idProducto = Int32.Parse(((LinkButton)sender).CommandArgument);
            //LineaOrdenVenta lov = ((BindingList<LineaOrdenVenta>)Session["lineasOrdenVenta"]).Single(x => x.Producto.IdProducto == idProducto);
            //((BindingList<LineaOrdenVenta>)Session["lineasOrdenVenta"]).Remove(lov);
            //gvLineasOrdenVenta.DataSource = ((BindingList<LineaOrdenVenta>)Session["lineasOrdenVenta"]);
            //gvLineasOrdenVenta.DataBind();

            //calcularTotal();
            //txtTotal.Text = ordenVenta.Total.ToString("F2");
        }

        protected void btnGuardar_Click(object sender, EventArgs e)
        {
            //if (Session["cliente"] == null)
            //{
            //    lblMensajeError.Text = "Debe elegir un cliente.";
            //    string script = "showModalFormError();";
            //    ScriptManager.RegisterStartupScript(this, GetType(), "ShowModalFormError", script, true);
            //    return;
            //}

            //if (lineasOrdenVenta.Count == 0)
            //{
            //    lblMensajeError.Text = "Debe agregar por lo menos un producto.";
            //    string script = "showModalFormError();";
            //    ScriptManager.RegisterStartupScript(this, GetType(), "ShowModalFormError", script, true);
            //    return;
            //}

            //ordenVenta.Cliente = cliente;
            //ordenVenta.LineasOrdenVenta = lineasOrdenVenta;
            ////ordenVenta.Empleado = (Empleado)Session["Empleado"];
            //ordenVenta.Empleado = new Empleado();
            //ordenVenta.Empleado.IdPersona = 2;

            //calcularTotal();

            //int resultado = boOrdenVenta.insertar(ordenVenta);
            //if (resultado != 0)
            //    Response.Redirect("Home.aspx");
            //else
            //    Response.Write("Ocurrio un error con el registro");
        }
    }
}