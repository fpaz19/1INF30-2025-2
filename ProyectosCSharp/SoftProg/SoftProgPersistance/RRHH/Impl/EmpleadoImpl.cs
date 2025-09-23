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
    public class EmpleadoImpl : EmpleadoDAO
    {
        private MySqlConnection con;
        private MySqlCommand cmd;

        public int eliminar(int idObjeto)
        {
            throw new NotImplementedException();
        }

        public int insertar(Empleado empleado)
        {
            int resultado = 0;
            con = DBManager.Instance.AbrirConexion();
            cmd = new MySqlCommand();
            cmd.Connection = con;
            cmd.CommandType = CommandType.StoredProcedure;
            cmd.CommandText = "INSERTAR_EMPLEADO";
            cmd.Parameters.Add("_id_empleado", MySqlDbType.Int32)
                .Direction = ParameterDirection.Output;
            cmd.Parameters.AddWithValue("_fid_area",
                empleado.Area.IdArea);
            cmd.Parameters.AddWithValue("_DNI",
                empleado.DNI);
            cmd.Parameters.AddWithValue("_nombre",
                empleado.Nombre);
            cmd.Parameters.AddWithValue("_apellido_paterno",
                empleado.ApellidoPaterno);
            cmd.Parameters.AddWithValue("_sexo",
                empleado.Sexo);
            cmd.Parameters.AddWithValue("_fecha_nacimiento",
                empleado.FechaNacimiento); 
            cmd.Parameters.AddWithValue("_cargo",
                empleado.Cargo);
            cmd.Parameters.AddWithValue("_sueldo",
                empleado.Sueldo);
            resultado = cmd.ExecuteNonQuery();
            DBManager.Instance.CerrarConexion();
            return resultado;
        }

        public BindingList<Empleado> listarTodos()
        {
            throw new NotImplementedException();
        }

        public int modificar(Empleado objeto)
        {
            throw new NotImplementedException();
        }

        public Empleado obtenerPorId(int idObjeto)
        {
            throw new NotImplementedException();
        }
    }
}
