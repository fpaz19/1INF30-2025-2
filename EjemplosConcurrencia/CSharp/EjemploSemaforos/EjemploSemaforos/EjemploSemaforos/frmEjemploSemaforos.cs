using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Threading;
using System.Threading.Tasks;
using System.Windows.Forms;

namespace EjemploSemaforos
{
    public partial class frmEjemploSemaforos : Form
    {
        public static Semaphore semaforo1;
        public static Semaphore semaforo2;
        public static Semaphore semaforo3;
        public frmEjemploSemaforos()
        {
            InitializeComponent();
            semaforo1 = new Semaphore(0, 3);
            semaforo2 = new Semaphore(3, 3);
            semaforo3 = new Semaphore(1, 1);
        }

        private void frmEjemploSemaforos_FormClosed(object sender, FormClosedEventArgs e)
        {
            Application.Exit();
        }

        private void frmEjemploSemaforos_Load(object sender, EventArgs e)
        {
            Productor productor = new Productor(lbProductor);
            Consumidor consumidor1 = new Consumidor(lbProductor, lbConsumidor1);
            Consumidor consumidor2 = new Consumidor(lbProductor, lbConsumidor2);
            Thread hiloProductor = new Thread(productor.run);
            Thread hiloConsumidor1 = new Thread(consumidor1.run);
            Thread hiloConsumidor2 = new Thread(consumidor2.run);
            hiloProductor.IsBackground = true;
            hiloConsumidor1.IsBackground = true;
            hiloConsumidor2.IsBackground = true;
            hiloProductor.Start();
            hiloConsumidor1.Start();
            hiloConsumidor2.Start();
        }
    }
}
