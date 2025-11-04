using SoftProgWA.SoftProgServices;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.Security;
using System.Web.UI;
using System.Web.UI.WebControls;

namespace SoftProgWA
{
    public partial class InicioSesion : System.Web.UI.Page
    {
        private CuentaUsuarioWSClient boCuentaUsuario;
        private EmpleadoWSClient boEmpleado;

        protected void Page_Load(object sender, EventArgs e)
        {

        }

        protected void btnLogin_Click(object sender, EventArgs e)
        {
            cuentaUsuario cu = new cuentaUsuario();

            cu.username = txtUsername.Text;
            cu.password = txtPassword.Text;

            boCuentaUsuario = new CuentaUsuarioWSClient();

            int resultado = 
                boCuentaUsuario.
                verificarCuentaUsuario
                (cu);

            txtUsername.Text = resultado.ToString();

            if (resultado != 0)
            {
                boEmpleado = new EmpleadoWSClient();
                empleado empleado = boEmpleado.obtenerEmpleadoPorId(resultado);
                Session["empleadoLogeado"] = empleado;
                FormsAuthenticationTicket tkt;
                string cookiestr;
                HttpCookie ck;
                tkt = new FormsAuthenticationTicket(1, cu.username, DateTime.Now,
                DateTime.Now.AddMinutes(30), true, "aqui van los roles");
                cookiestr = FormsAuthentication.Encrypt(tkt);
                ck = new HttpCookie(FormsAuthentication.FormsCookieName, cookiestr);
                ck.Expires = tkt.Expiration;
                ck.Path = FormsAuthentication.FormsCookiePath;
                Response.Cookies.Add(ck);

                string strRedirect;
                strRedirect = Request["ReturnUrl"];
                if (strRedirect == null)
                    strRedirect = "Home.aspx";
                Response.Redirect(strRedirect, true);

            }
            else
            {
                Response.Redirect("InicioSesion.aspx", true);
            }

        }
    }
}