using SoftProgModel.Almacen;
using SoftProgModel.RRHH;
using SoftProgPersistance.DAO;
using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace SoftProgPersistance.Almacen.DAO
{
    public interface ProductoDAO : IDAO<Producto>
    {
        BindingList<Producto> listarPorNombre(string nombre);
    }
}
