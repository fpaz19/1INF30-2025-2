using SoftProgBusiness.Almacen.BO;
using SoftProgModel.Almacen;
using SoftProgPersistance.Almacen.DAO;
using SoftProgPersistance.Almacen.Impl;
using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace SoftProgBusiness.Almacen.BOI
{
    public class ProductoBOImpl : IProductoBO
    {
        private ProductoDAO daoProducto;
        public ProductoBOImpl()
        {
            daoProducto = new ProductoImpl();
        }
        public int eliminar(int idProducto)
        {
            throw new NotImplementedException();
        }

        public int insertar(Producto producto)
        {
            throw new NotImplementedException();
        }

        public BindingList<Producto> listarPorNombre(string nombre)
        {
            return daoProducto.listarPorNombre(nombre);
        }

        public BindingList<Producto> listarTodos()
        {
            throw new NotImplementedException();
        }

        public int modificar(Producto objeto)
        {
            throw new NotImplementedException();
        }

        public Producto obtenerPorId(int idObjeto)
        {
            throw new NotImplementedException();
        }

        public void validar(Producto objeto)
        {
            throw new NotImplementedException();
        }
    }
}
