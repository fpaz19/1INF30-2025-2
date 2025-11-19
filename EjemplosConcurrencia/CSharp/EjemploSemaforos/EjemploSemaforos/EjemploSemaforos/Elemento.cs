using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace EjemploSemaforos
{
    public class Elemento
    {
        private static int contador = 1;
        private int numero;

        public Elemento()
        {
            this.numero = contador;
            contador++;
        }

        public override string ToString()
        {
            return "Elemento " + numero;
        }
    }
}
