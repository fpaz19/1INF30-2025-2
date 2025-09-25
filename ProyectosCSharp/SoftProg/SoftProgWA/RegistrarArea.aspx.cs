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
        private Area area;
        private AreaBOImpl boArea;
        protected void Page_Load(object sender, EventArgs e)
        {

        }

        protected void Unnamed2_Click(object sender, EventArgs e)
        {
            boArea = new AreaBOImpl();
            area = new Area();
            area.Nombre = txtNombre.Text;
            boArea.insertar(area);
        }
    }
}