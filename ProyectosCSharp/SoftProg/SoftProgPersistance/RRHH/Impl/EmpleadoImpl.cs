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
            throw new NotImplementedException();
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
