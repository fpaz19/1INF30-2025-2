using MySql.Data.MySqlClient;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace SoftProgDBManager
{
    public class DBManager
    {
        private static DBManager dbManager;
        private MySqlConnection con;
        private string cadena 
                = "server=database-prog3-0681.czyu42uq2yue.us-east-1." +
                "rds.amazonaws.com;" +
                "port=3306;" +
                "user=admin;" +
                "password=1inf300681prog3;" +
                "database=prog3;";

        private DBManager()
        {
            //leer los datos de conexion
        }

        public static DBManager Instance
        {
            get { 
                if (dbManager == null)
                    dbManager = new DBManager();
                return dbManager;
            }
        }

        public MySqlConnection AbrirConexion()
        {
            try
            {
                con = new MySqlConnection(cadena);
                con.Open();
            }catch(Exception ex)
            {
                System.Console.WriteLine("Error al conectar con la BD: " + ex.Message);
            }
            return con;
        }

        public void CerrarConexion()
        {
            con.Close();
        }
    }
}
