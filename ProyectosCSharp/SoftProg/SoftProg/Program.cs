using MySql.Data.MySqlClient;
using SoftProgBusiness.RRHH.BO;
using SoftProgBusiness.RRHH.BOI;
using SoftProgModel.RRHH;
using SoftProgDBManager;
using SoftProgPersistance.RRHH.DAO;
using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace SoftProg
{
    public class Program
    {
        public static void Main(string[] args)
        {
            //Area a = new Area("AREA C#");
            IAreaBO boArea = new AreaBOImpl();
            //boArea.insertar(a);

            Area b = new Area();
            b.IdArea = 2;

            Empleado emp = new Empleado("27651112","MARIA","FERNANDEZ",'F',new DateTime(1990, 10, 1),b, "JEFE DE VENTAS",1900.00);

            IEmpleadoBO boEmpleado = new EmpleadoBOImpl();
            boEmpleado.insertar(emp);

            BindingList<Empleado>
                empleados = boEmpleado.listarTodos();

            BindingList<Area>
                areas = boArea.listarTodos();
            foreach (Area area in areas)
            {
                System.Console.WriteLine(
                    area.IdArea + ". " +
                    area.Nombre);
            }

            areas[0].Nombre = "AREA MODIFICADA";
            boArea.modificar(areas[0]);

            Encriptamiento enc = new Encriptamiento();
            String llave = "jGwZUx4lOJZj8wXav7Sknw==";
            String passwordEncriptado = "7meZVWpeJjyQU9N/8juZ7Q==";
            System.Console.WriteLine(Encriptamiento.Desencriptar(passwordEncriptado, llave)) ;
        }
    }
}
