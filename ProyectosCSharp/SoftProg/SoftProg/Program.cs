using MySql.Data.MySqlClient;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace SoftProg
{
    internal class Program
    {
        static void Main(string[] args)
        {
            String cadena
                = "server=database-prog3-0681.czyu42uq2yue.us-east-1." +
                "rds.amazonaws.com;" +
                "port=3306;" +
                "user=admin;" +
                "password=1inf300681prog3;" +
                "database=prog3;";

            MySqlConnection con = new 
                MySqlConnection(cadena);

            con.Open();

            

            System.Console.WriteLine("Se ha conectado");

        }
    }
}
