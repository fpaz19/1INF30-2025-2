using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading;
using System.Threading.Tasks;

namespace EjemploConcurrencia
{
    public class Program
    {
        public static void Main(string[] args)
        {
            Cuadrado cuadrado = new Cuadrado();
            Triangulo triangulo = new Triangulo();
            Thread hiloCuadrado = 
                new Thread(cuadrado.run);
            Thread hiloTriangulo =
                new Thread(triangulo.run);
            hiloCuadrado.Start();
            hiloTriangulo.Start();

            System.Console.Read();
        }
    }
}
