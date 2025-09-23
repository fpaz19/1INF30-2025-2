using MySql.Data.MySqlClient;
using SoftProgDBManager;
using SoftProgModel.RRHH;
using SoftProgPersistance.RRHH.DAO;
using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace SoftProgPersistance.RRHH.Impl
{
    public class AreaImpl : AreaDAO
    {
        private MySqlConnection con;
        private MySqlCommand cmd;
        public int eliminar(int idArea)
        {
            throw new NotImplementedException();
        }

        public int insertar(Area area)
        {
            int resultado = 0;
            con = DBManager.Instance.AbrirConexion();
            cmd = new MySqlCommand();
            cmd.Connection = con;
            cmd.CommandType = CommandType.StoredProcedure;
            cmd.CommandText = "INSERTAR_AREA";
            cmd.Parameters.Add("_id_area", MySqlDbType.Int32).Direction = ParameterDirection.Output;
            cmd.Parameters.AddWithValue("_nombre", area.Nombre);
            resultado = cmd.ExecuteNonQuery();
            DBManager.Instance.CerrarConexion();
            return resultado;
        }

        public BindingList<Area> listarTodos()
        {
            throw new NotImplementedException();
        }

        public int modificar(Area area)
        {
            throw new NotImplementedException();
        }

        public Area obtenerPorId(int idArea)
        {
            throw new NotImplementedException();
        }
    }
}
