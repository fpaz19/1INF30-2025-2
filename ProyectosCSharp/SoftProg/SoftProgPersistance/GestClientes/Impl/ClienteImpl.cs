using SoftProgDBManager;
using SoftProgModel.Almacen;
using SoftProgModel.GestClientes;
using SoftProgModel.RRHH;
using SoftProgPersistance.GestClientes.DAO;
using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Data.Common;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace SoftProgPersistance.GestClientes.Impl
{
    public class ClienteImpl : ClienteDAO
    {
        private DbDataReader lector;
        public int eliminar(int idCliente)
        {
            throw new NotImplementedException();
        }

        public int insertar(Cliente cliente)
        {
            throw new NotImplementedException();
        }

        public BindingList<Cliente> listarPorDNIoNombre(string DNIoNombre)
        {
            BindingList<Cliente> clientes = null;
            DbParameter[] parametros = new DbParameter[1];
            parametros[0] = DBManager.Instance.CreateParam("_DNI_nombre", DbType.String, DNIoNombre, ParameterDirection.Input);
            lector = DBManager.Instance.EjecutarProcedimientoLectura("LISTAR_CLIENTES_X_DNI_NOMBRE", parametros);
            while (lector.Read())
            {
                if (clientes == null) clientes = new BindingList<Cliente>();
                Cliente cliente = new Cliente();
                if (!lector.IsDBNull(lector.GetOrdinal("id_cliente"))) cliente.IdPersona = lector.GetInt32(lector.GetOrdinal("id_cliente"));
                if (!lector.IsDBNull(lector.GetOrdinal("DNI"))) cliente.DNI = lector.GetString(lector.GetOrdinal("DNI"));
                if (!lector.IsDBNull(lector.GetOrdinal("nombre"))) cliente.Nombre = lector.GetString(lector.GetOrdinal("nombre"));
                if (!lector.IsDBNull(lector.GetOrdinal("apellido_paterno"))) cliente.ApellidoPaterno = lector.GetString(lector.GetOrdinal("apellido_paterno"));
                if (!lector.IsDBNull(lector.GetOrdinal("sexo"))) cliente.Sexo = lector.GetChar(lector.GetOrdinal("sexo"));
                if (!lector.IsDBNull(lector.GetOrdinal("fecha_nacimiento"))) cliente.FechaNacimiento = lector.GetDateTime(lector.GetOrdinal("fecha_nacimiento"));
                if (!lector.IsDBNull(lector.GetOrdinal("linea_credito"))) cliente.LineaCredito = Convert.ToDouble(lector.GetOrdinal("linea_credito"));
                if (!lector.IsDBNull(lector.GetOrdinal("categoria"))) cliente.Categoria = (Categoria)Enum.Parse(typeof(Categoria), lector.GetString(lector.GetOrdinal("categoria")));
                clientes.Add(cliente);
            }
            DBManager.Instance.CerrarConexion();
            return clientes;
        }

        public BindingList<Cliente> listarTodos()
        {
            BindingList<Cliente> clientes = null;
            lector = DBManager.Instance.EjecutarProcedimientoLectura("LISTAR_CLIENTES_TODOS", null);
            while (lector.Read())
            {
                if (clientes == null) clientes = new BindingList<Cliente>();
                Cliente cliente = new Cliente();
                if (!lector.IsDBNull(lector.GetOrdinal("id_cliente"))) cliente.IdPersona = lector.GetInt32(lector.GetOrdinal("id_cliente"));
                if (!lector.IsDBNull(lector.GetOrdinal("DNI"))) cliente.DNI = lector.GetString(lector.GetOrdinal("DNI"));
                if (!lector.IsDBNull(lector.GetOrdinal("nombre"))) cliente.Nombre = lector.GetString(lector.GetOrdinal("nombre"));
                if (!lector.IsDBNull(lector.GetOrdinal("apellido_paterno"))) cliente.ApellidoPaterno = lector.GetString(lector.GetOrdinal("apellido_paterno"));
                if (!lector.IsDBNull(lector.GetOrdinal("sexo"))) cliente.Sexo = lector.GetChar(lector.GetOrdinal("sexo"));
                if (!lector.IsDBNull(lector.GetOrdinal("fecha_nacimiento"))) cliente.FechaNacimiento = lector.GetDateTime(lector.GetOrdinal("fecha_nacimiento"));
                if (!lector.IsDBNull(lector.GetOrdinal("linea_credito"))) cliente.LineaCredito = Convert.ToDouble(lector.GetOrdinal("linea_credito"));
                if (!lector.IsDBNull(lector.GetOrdinal("categoria"))) cliente.Categoria = (Categoria) Enum.Parse(typeof(Categoria), lector.GetString(lector.GetOrdinal("categoria")));
                clientes.Add(cliente);
            }
            DBManager.Instance.CerrarConexion();
            return clientes;
        }

        public int modificar(Cliente cliente)
        {
            throw new NotImplementedException();
        }

        public Cliente obtenerPorId(int idCliente)
        {
            throw new NotImplementedException();
        }
    }
}
