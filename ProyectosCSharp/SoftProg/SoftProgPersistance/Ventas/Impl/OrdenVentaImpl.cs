using MySql.Data.MySqlClient;
using SoftProgDBManager;
using SoftProgModel.RRHH;
using SoftProgModel.Ventas;
using SoftProgPersistance.Ventas.DAO;
using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Data.Common;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace SoftProgPersistance.Ventas.Impl
{
    public class OrdenVentaImpl : OrdenVentaDAO
    {
        private DbTransaction transaccion;
        public int eliminar(int idObjeto)
        {
            throw new NotImplementedException();
        }

        public int insertar(OrdenVenta ordenVenta)
        {
            try
            {
                DbParameter[] parametros = new DbParameter[4];
                parametros[0] = DBManager.Instance.CreateParam("_id_orden_venta", DbType.Int32, null, ParameterDirection.Output);
                parametros[1] = DBManager.Instance.CreateParam("_fid_empleado", DbType.Int32, ordenVenta.Empleado.IdPersona, ParameterDirection.Input);
                parametros[2] = DBManager.Instance.CreateParam("_fid_cliente", DbType.Int32, ordenVenta.Cliente.IdPersona, ParameterDirection.Input);
                parametros[3] = DBManager.Instance.CreateParam("_total", DbType.Double, ordenVenta.Total, ParameterDirection.Input);
                DBManager.Instance.AbrirConexion();
                DBManager.Instance.EjecutarProcedimientoTransaccion("INSERTAR_ORDEN_VENTA", parametros,transaccion);
                ordenVenta.IdOrdenVenta = Int32.Parse(parametros[0].Value.ToString());
                foreach (LineaOrdenVenta lineaOrdenVenta in ordenVenta.LineasOrdenVenta)
                {
                    parametros = new DbParameter[4];
                    DBManager.Instance.EjecutarProcedimientoTransaccion("INSERTAR_LINEA_ORDEN_VENTA", parametros, transaccion);
                }
                transaccion.Commit();
            }
            catch(Exception ex){
                try { transaccion.Rollback(); } catch (Exception ex2) { throw new Exception(ex2.Message); }
            }
            finally
            {
                DBManager.Instance.CerrarConexion();
            }
            return ordenVenta.IdOrdenVenta;
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
    }
}
