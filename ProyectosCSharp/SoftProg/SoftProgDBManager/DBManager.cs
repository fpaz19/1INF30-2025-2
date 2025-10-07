using MySql.Data.MySqlClient;
using System;
using System.Collections.Generic;
using System.Configuration;
using System.Data;
using System.Data.Common;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace SoftProgDBManager
{
    public class DBManager
    {
        private static DBManager dbManager;
        private DbConnection con;
        private DbCommand cmd;

        private string tipoBD;
        private string server;
        private string port;
        private string user;
        private string password;
        private string passwordEncriptado;
        private string llave;
        private string database;

        private string cadena;

        private DbProviderFactory Factory => DbProviderFactories.GetFactory(tipoBD);

        public bool esSqlServer => tipoBD == "System.Data.SqlClient";
        public bool esMySql => tipoBD == "MySql.Data.MySqlClient";

        private DBManager()
        {
            server = ConfigurationManager.AppSettings["db.hostname"];
            tipoBD = ConfigurationManager.AppSettings["db.provider"];
            user = ConfigurationManager.AppSettings["db.username"];
            //password = ConfigurationManager.AppSettings["db.password"];
            port = ConfigurationManager.AppSettings["db.port"];
            database = ConfigurationManager.AppSettings["db.database"];
            passwordEncriptado = ConfigurationManager.AppSettings["db.passwordEncriptado"];
            llave = ConfigurationManager.AppSettings["db.key"];
            password = Encriptamiento.Desencriptar(passwordEncriptado, llave); ;
            if (esMySql)
                cadena = $"Server={server};Database={database};User Id={user};Password={password};Port={port};";
            else if (esSqlServer)
                cadena = $"Server={server},{port};Database={database};User Id={user};Password={password};";
        }

        public static DBManager Instance
        {
            get { 
                if (dbManager == null)
                    dbManager = new DBManager();
                return dbManager;
            }
        }

        public DbConnection AbrirConexion()
        {
            try
            {
                con = Factory.CreateConnection();
                con.ConnectionString = cadena;
                if (con.State != ConnectionState.Open)
                    con.Open();
            }catch(Exception ex)
            {
                System.Console.WriteLine("Error al conectar con la BD: " + ex.Message);
            }
            return con;
        }

        public void CerrarConexion()
        {
            if (con == null) return;
            if (con.State != ConnectionState.Closed) con.Close();
            con.Dispose();
        }

        //Métodos para llamadas a Procedimientos Almacenados
        public DbParameter CreateParam(string nombreLogico, DbType tipo, object valor, ParameterDirection direccion)
        {
            DbParameter p = Factory.CreateParameter();
            p.ParameterName = nombreLogico;
            p.DbType = tipo;
            p.Direction = direccion;
            p.Value = valor ?? DBNull.Value;
            return p;
        }

        public string P(string nombreLogico)
        {
            return esSqlServer ? "@" + nombreLogico : nombreLogico;
        }

        public DbCommand CrearCommand(string storedProcedure)
        {
            cmd = con.CreateCommand();
            cmd.CommandType = CommandType.StoredProcedure;
            cmd.CommandText = storedProcedure;
            return cmd;
        }

        public int EjecutarProcedimiento(string nombreSP, IList<DbParameter> parametros)
        {
            int resultado = 0;
            AbrirConexion();
            cmd = CrearCommand(nombreSP);
            if (parametros != null && parametros.Count > 0)
                foreach (DbParameter p in parametros)
                {
                    p.ParameterName = P(p.ParameterName);
                    cmd.Parameters.Add(p);
                }
            resultado = cmd.ExecuteNonQuery();
            CerrarConexion();
            return resultado;
        }

        public DbDataReader EjecutarProcedimientoLectura(string nombreSP, IList<DbParameter> parametros)
        {
            AbrirConexion();
            try
            {
                cmd = CrearCommand(nombreSP);
                if (parametros != null && parametros.Count > 0)
                    foreach (DbParameter p in parametros)
                    {
                        p.ParameterName = P(p.ParameterName);
                        cmd.Parameters.Add(p);
                    }
                return cmd.ExecuteReader(CommandBehavior.CloseConnection);
            }
            catch (Exception ex)
            {
                throw new Exception(ex.Message);
            }
        }

        public int EjecutarProcedimientoTransaccion(string nombreSP, IList<DbParameter> parametros, DbTransaction transaccion)
        {
            int resultado = 0;
            cmd = CrearCommand(nombreSP);
            transaccion = con.BeginTransaction();
            cmd.Transaction = transaccion;
            if (parametros != null && parametros.Count > 0)
                foreach (DbParameter p in parametros)
                {
                    p.ParameterName = P(p.ParameterName);
                    cmd.Parameters.Add(p);
                }
            resultado = cmd.ExecuteNonQuery();
            return resultado;
        }

    }
}
