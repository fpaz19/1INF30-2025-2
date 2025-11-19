using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading;
using System.Threading.Tasks;
using System.Windows.Forms;

namespace EjemploSemaforos
{
    public class Productor
    {
        private ListBox modeloProductor;
        private delegate void AgregarItem();
        public Productor(ListBox modeloProductor)
        {
            this.modeloProductor = modeloProductor;
        }
        public void run()
        {
            try
            {
                while (true)
                {
                    frmEjemploSemaforos.semaforo2.WaitOne();
                    producir();
                    frmEjemploSemaforos.semaforo1.Release();
                    Thread.Sleep(1000);
                }
            }catch(Exception ex)
            {
                MessageBox.Show("Ha ocurrido una excepción: " + ex.Message);
            }
        }

        public void producir()
        {
            Elemento e = new Elemento();
            modeloProductor.Invoke(new AgregarItem(()=> modeloProductor.Items.Add(e)));
        }
    }
}
