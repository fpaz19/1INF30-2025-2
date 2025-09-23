using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace SoftProgModel.RRHH
{
    public class Empleado : Persona
    {
        private Area area;
        private string cargo;
        private double sueldo;
        private bool activo;

        public Empleado() { }
        public Empleado(String dni, String nombre, String apellidoPaterno, char sexo, DateTime fechaNacimiento, Area area, string cargo, double sueldo) : base(dni, nombre, apellidoPaterno, sexo, fechaNacimiento)
        {
            this.area = area;
            this.cargo = cargo;
            this.sueldo = sueldo;
        }

        public string Cargo { get => cargo; set => cargo = value; }
        public double Sueldo { get => sueldo; set => sueldo = value; }
        public bool Activo { get => activo; set => activo = value; }
        public Area Area { get => area; set => area = value; }
    }
}
