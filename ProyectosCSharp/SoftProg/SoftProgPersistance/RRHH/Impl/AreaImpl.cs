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
using System.Runtime.Remoting.Messaging;
using System.Text;
using System.Threading.Tasks;

namespace SoftProgPersistance.RRHH.Impl
{
    public class AreaImpl : AreaDAO
    {
        private DbDataReader lector;
        public int eliminar(int idArea)
        {
            DbParameter[] parametros = new DbParameter[1];
            parametros[0] = DBManager.Instance.CreateParam("_id_area", DbType.Int32, idArea, ParameterDirection.Input);
            return DBManager.Instance.EjecutarProcedimiento("ELIMINAR_AREA", parametros);
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
            BindingList<Area> areas = null;
            lector = DBManager.Instance.EjecutarProcedimientoLectura("LISTAR_AREAS_TODAS", null);
            while (lector.Read())
            {
                if (areas == null) areas = new BindingList<Area>();
                Area area = new Area();
                if (!lector.IsDBNull(lector.GetOrdinal("id_area"))) area.IdArea = lector.GetInt32(lector.GetOrdinal("id_area"));
                if (!lector.IsDBNull(lector.GetOrdinal("nombre"))) area.Nombre = lector.GetString(lector.GetOrdinal("nombre"));
                area.Activa = true;
                areas.Add(area);
            }
            DBManager.Instance.CerrarConexion();
            return areas;
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
            Area area = null;
            DbParameter[] parametros = new DbParameter[1];
            parametros[0] = DBManager.Instance.CreateParam("_id_area", DbType.Int32, idArea, ParameterDirection.Input);
            lector = DBManager.Instance.EjecutarProcedimientoLectura("OBTENER_AREA_X_ID", parametros);
            if (lector.Read())
            {
                if (area == null) area = new Area();
                if (!lector.IsDBNull(lector.GetOrdinal("id_area"))) area.IdArea = lector.GetInt32(lector.GetOrdinal("id_area"));
                if (!lector.IsDBNull(lector.GetOrdinal("nombre"))) area.Nombre = lector.GetString(lector.GetOrdinal("nombre"));
                area.Activa = true;
            }
            DBManager.Instance.CerrarConexion();
            return area;
        }
    }
}
