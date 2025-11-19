using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace EjemploConcurrencia
{
    public class Triangulo
    {
        public void run()
        {
            for(int i=1; i<50; i++) {
                for (int j = 0; j < i; j++)
                {
                    System.Console.Write("*");
                }
                System.Console.WriteLine();
            }
        }
    }
}
