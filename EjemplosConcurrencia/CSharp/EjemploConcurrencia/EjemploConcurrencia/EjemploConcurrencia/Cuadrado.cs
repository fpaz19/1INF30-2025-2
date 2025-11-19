using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace EjemploConcurrencia
{
    public class Cuadrado
    {
        public void run()
        {
            for(int i = 1; i < 50; i++) {
                System.Console.WriteLine(i + " * " + i + " = "
                    + i*i);
            }
        }
    }
}
