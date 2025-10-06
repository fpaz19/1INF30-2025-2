using SoftProgModel.GestClientes;
using SoftProgModel.RRHH;
using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace SoftProgModel.Ventas
{
    public class OrdenVenta
    {
        private int idOrdenVenta;
        private Empleado empleado;
        private Cliente cliente;
        private BindingList<LineaOrdenVenta> lineasOrdenVenta;
        private double total;
        private DateTime fechaHora;
        private bool activa;

        public int IdOrdenVenta { get => idOrdenVenta; set => idOrdenVenta = value; }
        public Empleado Empleado { get => empleado; set => empleado = value; }
        public Cliente Cliente { get => cliente; set => cliente = value; }
        public BindingList<LineaOrdenVenta> LineasOrdenVenta { get => lineasOrdenVenta; set => lineasOrdenVenta = value; }
        public double Total { get => total; set => total = value; }
        public DateTime FechaHora { get => fechaHora; set => fechaHora = value; }
        public bool Activa { get => activa; set => activa = value; }
    }
}
