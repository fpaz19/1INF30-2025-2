using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace SoftProgModel.RRHH
{
    public class Area
    {
        private int idArea;
        private String nombre;
        private bool activa;

        public Area() { }
        public Area(string nombre)
        {
            this.nombre = nombre;
        }

        public int IdArea { get => idArea; set => idArea = value; }
        public string Nombre { get => nombre; set => nombre = value; }
        public bool Activa { get => activa; set => activa = value; }

        public override string ToString()
        {
            return "Area: " + nombre;
        }
    }
}
