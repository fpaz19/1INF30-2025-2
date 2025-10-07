using SoftProgBusiness.Ventas.BO;
using SoftProgModel.Ventas;
using SoftProgPersistance.Ventas.DAO;
using SoftProgPersistance.Ventas.Impl;
using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace SoftProgBusiness.Ventas.BOI
{
    public class OrdenVentaBOImpl : IOrdenVentaBO
    {
        private OrdenVentaDAO daoOrdenVenta;
        public OrdenVentaBOImpl()
        {
            daoOrdenVenta = new OrdenVentaImpl();
        }
        public int eliminar(int idObjeto)
        {
            throw new NotImplementedException();
        }

        public int insertar(OrdenVenta ordenVenta)
        {
            return daoOrdenVenta.insertar(ordenVenta);
        }

        public BindingList<OrdenVenta> listarTodos()
        {
            throw new NotImplementedException();
        }

        public int modificar(OrdenVenta objeto)
        {
            throw new NotImplementedException();
        }

        public OrdenVenta obtenerPorId(int idObjeto)
        {
            throw new NotImplementedException();
        }

        public void validar(OrdenVenta objeto)
        {
            throw new NotImplementedException();
        }
    }
}
