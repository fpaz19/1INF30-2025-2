using SoftProgDBManager;
using SoftProgModel.Almacen;
using SoftProgModel.RRHH;
using SoftProgPersistance.Almacen.DAO;
using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Data.Common;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace SoftProgPersistance.Almacen.Impl
{
    public class ProductoImpl : ProductoDAO
    {
        private DbDataReader lector;
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
            BindingList<Producto> productos = null;
            DbParameter[] parametros = new DbParameter[1];
            parametros[0] = DBManager.Instance.CreateParam("_nombre", DbType.String, nombre, ParameterDirection.Input);
            lector = DBManager.Instance.EjecutarProcedimientoLectura("LISTAR_PRODUCTOS_X_NOMBRE", parametros);
            while (lector.Read())
            {
                if (productos == null) productos = new BindingList<Producto>();
                Producto producto = new Producto();
                if (!lector.IsDBNull(lector.GetOrdinal("id_producto"))) producto.IdProducto = lector.GetInt32(lector.GetOrdinal("id_producto"));
                if (!lector.IsDBNull(lector.GetOrdinal("nombre"))) producto.Nombre = lector.GetString(lector.GetOrdinal("nombre"));
                if (!lector.IsDBNull(lector.GetOrdinal("unidad_medida"))) producto.UnidadMedida = lector.GetString(lector.GetOrdinal("unidad_medida"));
                if (!lector.IsDBNull(lector.GetOrdinal("precio"))) producto.Precio = Convert.ToDouble(lector["precio"]);
                producto.Activo = true;
                productos.Add(producto);
            }
            DBManager.Instance.CerrarConexion();
            return productos;
        }

        public BindingList<Producto> listarTodos()
        {
            BindingList<Producto> productos = null;
            lector = DBManager.Instance.EjecutarProcedimientoLectura("LISTAR_PRODUCTOS_TODOS", null);
            while (lector.Read())
            {
                if (productos == null) productos = new BindingList<Producto>();
                Producto producto = new Producto();
                if (!lector.IsDBNull(lector.GetOrdinal("id_producto"))) producto.IdProducto = lector.GetInt32(lector.GetOrdinal("id_producto"));
                if (!lector.IsDBNull(lector.GetOrdinal("nombre"))) producto.Nombre = lector.GetString(lector.GetOrdinal("nombre"));
                if (!lector.IsDBNull(lector.GetOrdinal("unidad_medida"))) producto.UnidadMedida = lector.GetString(lector.GetOrdinal("unidad_medida"));
                if (!lector.IsDBNull(lector.GetOrdinal("precio"))) producto.Precio = Convert.ToDouble(lector["precio"]);
                producto.Activo = true;
                productos.Add(producto);
            }
            DBManager.Instance.CerrarConexion();
            return productos;
        }

        public int modificar(Producto producto)
        {
            throw new NotImplementedException();
        }

        public Producto obtenerPorId(int idProducto)
        {
            throw new NotImplementedException();
        }
    }
}
