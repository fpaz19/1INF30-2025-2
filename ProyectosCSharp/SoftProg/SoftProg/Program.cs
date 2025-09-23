using MySql.Data.MySqlClient;
using SoftProgBusiness.RRHH.BO;
using SoftProgBusiness.RRHH.BOI;
using SoftProgModel.RRHH;
using SoftProgPersistance.RRHH.DAO;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace SoftProg
{
    internal class Program
    {
        static void Main(string[] args)
        {
            Area a = new
                Area("AREA C#");
            IAreaBO boArea = new AreaBOImpl();
            boArea.insertar(a);

            Area b = new Area();
            b.IdArea = 2;

            Empleado
                emp
                = new Empleado("27651112",
                "MARIA",
                "FERNANDEZ", 'F',
                new DateTime(1990, 10, 1),
                b, "JEFE DE VENTAS",
                1900.00);

            IEmpleadoBO boEmpleado
                = new EmpleadoBOImpl();
            boEmpleado.insertar(emp);

        }
    }
}
