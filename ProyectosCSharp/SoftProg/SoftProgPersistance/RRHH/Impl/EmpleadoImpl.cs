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
        private DbDataReader lector;
        public int eliminar(int idEmpleado)
        {
            DbParameter[] parametros = new DbParameter[1];
            parametros[0] = DBManager.Instance.CreateParam("_id_empleado", DbType.Int32, idEmpleado, ParameterDirection.Input);
            return DBManager.Instance.EjecutarProcedimiento("ELIMINAR_EMPLEADO", parametros); ;
        }

        public int insertar(Empleado empleado)
        {
            DbParameter[] parametros = new DbParameter[9];
            parametros[0] = DBManager.Instance.CreateParam("_id_empleado", DbType.Int32, null, ParameterDirection.Output);
            parametros[1] = DBManager.Instance.CreateParam("_fid_area", DbType.Int32, empleado.Area.IdArea, ParameterDirection.Input);
            parametros[2] = DBManager.Instance.CreateParam("_DNI", DbType.String, empleado.DNI, ParameterDirection.Input);
            parametros[3] = DBManager.Instance.CreateParam("_nombre", DbType.String, empleado.Nombre, ParameterDirection.Input);
            parametros[4] = DBManager.Instance.CreateParam("_apellido_paterno", DbType.String, empleado.ApellidoPaterno, ParameterDirection.Input);
            parametros[5] = DBManager.Instance.CreateParam("_sexo", DbType.String, empleado.Sexo, ParameterDirection.Input);
            parametros[6] = DBManager.Instance.CreateParam("_fecha_nacimiento", DbType.Date, empleado.FechaNacimiento, ParameterDirection.Input);
            parametros[7] = DBManager.Instance.CreateParam("_cargo", DbType.String, empleado.Cargo, ParameterDirection.Input);
            parametros[8] = DBManager.Instance.CreateParam("_sueldo", DbType.Double, empleado.Sueldo, ParameterDirection.Input);
            DBManager.Instance.EjecutarProcedimiento("INSERTAR_EMPLEADO", parametros);
            empleado.IdPersona = Convert.ToInt32(parametros[0].Value);
            return empleado.IdPersona;
        }

        public BindingList<Empleado> listarTodos()
        {
            BindingList<Empleado> empleados = null;
            lector = DBManager.Instance.EjecutarProcedimientoLectura("LISTAR_EMPLEADOS_TODOS", null);
            while (lector.Read())
            {
                if (empleados == null) empleados = new BindingList<Empleado>();
                Empleado empleado = new Empleado();
                if (!lector.IsDBNull(lector.GetOrdinal("id_empleado"))) empleado.IdPersona = lector.GetInt32(lector.GetOrdinal("id_empleado"));
                if (!lector.IsDBNull(lector.GetOrdinal("DNI"))) empleado.DNI = lector.GetString(lector.GetOrdinal("DNI"));
                if (!lector.IsDBNull(lector.GetOrdinal("nombre"))) empleado.Nombre = lector.GetString(lector.GetOrdinal("nombre"));
                if (!lector.IsDBNull(lector.GetOrdinal("apellido_paterno"))) empleado.ApellidoPaterno = lector.GetString(lector.GetOrdinal("apellido_paterno"));
                if (!lector.IsDBNull(lector.GetOrdinal("sexo"))) empleado.Sexo = lector.GetChar(lector.GetOrdinal("sexo"));
                if (!lector.IsDBNull(lector.GetOrdinal("fecha_nacimiento"))) empleado.FechaNacimiento = lector.GetDateTime(lector.GetOrdinal("fecha_nacimiento"));
                Area area = new Area();
                if (!lector.IsDBNull(lector.GetOrdinal("id_area"))) area.IdArea = lector.GetInt32(lector.GetOrdinal("id_area"));
                if (!lector.IsDBNull(lector.GetOrdinal("nombre_area"))) area.Nombre = lector.GetString(lector.GetOrdinal("nombre_area"));
                empleado.Area = area;
                if (!lector.IsDBNull(lector.GetOrdinal("cargo"))) empleado.Cargo = lector.GetString(lector.GetOrdinal("cargo"));
                if (!lector.IsDBNull(lector.GetOrdinal("sueldo"))) empleado.Sueldo = lector.GetDouble(lector.GetOrdinal("sueldo"));
                empleado.Activo = true;
                empleados.Add(empleado);
            }
            DBManager.Instance.CerrarConexion();
            return empleados;
        }

        public int modificar(Empleado empleado)
        {
            DbParameter[] parametros = new DbParameter[9];
            parametros[0] = DBManager.Instance.CreateParam("_id_empleado", DbType.Int32, empleado.IdPersona, ParameterDirection.Input);
            parametros[1] = DBManager.Instance.CreateParam("_fid_area", DbType.Int32, empleado.Area.IdArea, ParameterDirection.Input);
            parametros[2] = DBManager.Instance.CreateParam("_DNI", DbType.String, empleado.DNI, ParameterDirection.Input);
            parametros[3] = DBManager.Instance.CreateParam("_nombre", DbType.String, empleado.Nombre, ParameterDirection.Input);
            parametros[4] = DBManager.Instance.CreateParam("_apellido_paterno", DbType.String, empleado.ApellidoPaterno, ParameterDirection.Input);
            parametros[5] = DBManager.Instance.CreateParam("_sexo", DbType.String, empleado.Sexo, ParameterDirection.Input);
            parametros[6] = DBManager.Instance.CreateParam("_fecha_nacimiento", DbType.Date, empleado.FechaNacimiento, ParameterDirection.Input);
            parametros[7] = DBManager.Instance.CreateParam("_cargo", DbType.String, empleado.Cargo, ParameterDirection.Input);
            parametros[8] = DBManager.Instance.CreateParam("_sueldo", DbType.Double, empleado.Sueldo, ParameterDirection.Input);
            return DBManager.Instance.EjecutarProcedimiento("MODIFICAR_EMPLEADO", parametros);
        }

        public Empleado obtenerPorId(int idEmpleado)
        {
            Empleado empleado = null;
            DbParameter[] parametros = new DbParameter[1];
            parametros[0] = DBManager.Instance.CreateParam("_id_empleado", DbType.Int32, idEmpleado, ParameterDirection.Input);
            lector = DBManager.Instance.EjecutarProcedimientoLectura("OBTENER_EMPLEADO_X_ID", parametros);
            if (lector.Read())
            {
                if (empleado == null) empleado = new Empleado();
                if (!lector.IsDBNull(lector.GetOrdinal("id_empleado"))) empleado.IdPersona = lector.GetInt32(lector.GetOrdinal("id_empleado"));
                if (!lector.IsDBNull(lector.GetOrdinal("DNI"))) empleado.DNI = lector.GetString(lector.GetOrdinal("DNI"));
                if (!lector.IsDBNull(lector.GetOrdinal("nombre"))) empleado.Nombre = lector.GetString(lector.GetOrdinal("nombre"));
                if (!lector.IsDBNull(lector.GetOrdinal("apellido_paterno"))) empleado.ApellidoPaterno = lector.GetString(lector.GetOrdinal("apellido_paterno"));
                if (!lector.IsDBNull(lector.GetOrdinal("sexo"))) empleado.Sexo = lector.GetChar(lector.GetOrdinal("sexo"));
                if (!lector.IsDBNull(lector.GetOrdinal("fecha_nacimiento"))) empleado.FechaNacimiento = lector.GetDateTime(lector.GetOrdinal("fecha_nacimiento"));
                Area area = new Area();
                if (!lector.IsDBNull(lector.GetOrdinal("id_area"))) area.IdArea = lector.GetInt32(lector.GetOrdinal("id_area"));
                if (!lector.IsDBNull(lector.GetOrdinal("nombre_area"))) area.Nombre = lector.GetString(lector.GetOrdinal("nombre_area"));
                empleado.Area = area;
                if (!lector.IsDBNull(lector.GetOrdinal("cargo"))) empleado.Cargo = lector.GetString(lector.GetOrdinal("cargo"));
                if (!lector.IsDBNull(lector.GetOrdinal("sueldo"))) empleado.Sueldo = lector.GetDouble(lector.GetOrdinal("sueldo"));
                empleado.Activo = true;
            }
            DBManager.Instance.CerrarConexion();
            return empleado;
        }
    }
}
