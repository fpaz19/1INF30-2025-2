using MySql.Data.MySqlClient;
using SoftProgDBManager;
using SoftProgModel.RRHH;
using SoftProgPersistance.RRHH.DAO;
using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Data.Common;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace SoftProgPersistance.RRHH.Impl
{
    public class AreaImpl : AreaDAO
    {

        public int eliminar(int idArea)
        {
            throw new NotImplementedException();
        }

        public int insertar(Area area)
        {
            DbParameter[] parametros = new DbParameter[2];
            parametros[0] = DBManager.Instance.CreateParam("_id_area",DbType.Int32,null,ParameterDirection.Output);
            parametros[1] = DBManager.Instance.CreateParam("_nombre", DbType.String, area.Nombre, ParameterDirection.Input);
            DBManager.Instance.EjecutarProcedimiento("INSERTAR_AREA", parametros);
            area.IdArea = Convert.ToInt32(parametros[0].Value);
            return area.IdArea;
        }

        public BindingList<Area> listarTodos()
        {
            throw new NotImplementedException();
        }

        public int modificar(Area area)
        {
            DbParameter[] parametros = new DbParameter[2];
            parametros[0] = DBManager.Instance.CreateParam("_id_area", DbType.Int32, area.IdArea, ParameterDirection.Input);
            parametros[1] = DBManager.Instance.CreateParam("_nombre", DbType.String, area.Nombre, ParameterDirection.Input);
            return DBManager.Instance.EjecutarProcedimiento("MODIFICAR_AREA", parametros);
        }

        public Area obtenerPorId(int idArea)
        {
            throw new NotImplementedException();
        }
    }
}
