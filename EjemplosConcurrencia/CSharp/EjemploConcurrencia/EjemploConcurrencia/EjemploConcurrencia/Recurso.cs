using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading;
using System.Threading.Tasks;

namespace EjemploConcurrencia
{
    public class Recurso
    {
        private int contador = 0;
        public void aumentar()
        {
            lock (this)
            {
                if(contador == 3)
                    Monitor.Wait(this);
                int aux = contador;
                aux++;
                contador = aux;

                Monitor.Pulse(this);
            }
        }

        public void disminuir()
        {
            int aux = contador;
            aux--;
            contador = aux;
        }
    }
}
