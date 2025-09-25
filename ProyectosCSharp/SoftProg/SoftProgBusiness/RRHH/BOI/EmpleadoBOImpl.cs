using SoftProgBusiness.RRHH.BO;
using SoftProgModel.RRHH;
using SoftProgPersistance.RRHH.DAO;
using SoftProgPersistance.RRHH.Impl;
using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace SoftProgBusiness.RRHH.BOI
{
    public class EmpleadoBOImpl : IEmpleadoBO
    {
        private EmpleadoDAO daoEmpleado;

        public EmpleadoBOImpl()
        {
            daoEmpleado = new EmpleadoImpl();
        }
        public int eliminar(int idObjeto)
        {
            throw new NotImplementedException();
        }

        public int insertar(Empleado empleado)
        {
            validar(empleado);
            return daoEmpleado.insertar(empleado);
        }

        public BindingList<Empleado> listarTodos()
        {
            return daoEmpleado.listarTodos();
        }

        public int modificar(Empleado objeto)
        {
            throw new NotImplementedException();
        }

        public Empleado obtenerPorId(int idObjeto)
        {
            throw new NotImplementedException();
        }

        public void validar(Empleado objeto)
        {
            System.Console.WriteLine("validaciones...");
        }
    }
}
