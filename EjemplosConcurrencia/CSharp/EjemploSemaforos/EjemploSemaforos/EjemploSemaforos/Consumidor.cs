using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading;
using System.Threading.Tasks;
using System.Windows.Forms;

namespace EjemploSemaforos
{
    public class Consumidor
    {
        private ListBox modeloProductor;
        private ListBox modeloConsumidor;

        private delegate void RemoverItem();
        private delegate void AgregarItem();

        public Consumidor(ListBox modeloProductor, ListBox modeloConsumidor)
        {
            this.modeloProductor = modeloProductor;
            this.modeloConsumidor = modeloConsumidor;
        }

        public void run()
        {
            try
            {
                while (true)
                {
                    Thread.Sleep(3000);
                    frmEjemploSemaforos.semaforo1.WaitOne();
                    frmEjemploSemaforos.semaforo3.WaitOne();
                    consumir();
                    frmEjemploSemaforos.semaforo3.Release();
                    frmEjemploSemaforos.semaforo2.Release();
                }
                
            }
            catch(Exception ex)
            {
                MessageBox.Show("Ha ocurrido una excepción: " + ex.Message);
            }
        }

        public void consumir()
        {
            Elemento e = (Elemento) modeloProductor.Items[0];
            modeloProductor.Invoke(new RemoverItem(()=> modeloProductor.Items.RemoveAt(0)));
            modeloConsumidor.Invoke(new AgregarItem(()=> modeloConsumidor.Items.Add(e)));
        }
    }
}
