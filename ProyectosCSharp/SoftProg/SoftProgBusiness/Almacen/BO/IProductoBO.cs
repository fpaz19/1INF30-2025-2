using SoftProgBusiness.BO;
using SoftProgModel.Almacen;
using SoftProgModel.GestClientes;
using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace SoftProgBusiness.Almacen.BO
{
    public interface IProductoBO : IBaseBO<Producto>
    {
        BindingList<Producto> listarPorNombre(string nombre);
    }
}
