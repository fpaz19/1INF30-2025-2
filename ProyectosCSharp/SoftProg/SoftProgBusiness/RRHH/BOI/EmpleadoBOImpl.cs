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
        public int eliminar(int idEmpleado)
        {
            return daoEmpleado.eliminar(idEmpleado);
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

        public int modificar(Empleado empleado)
        {
            validar(empleado);
            return daoEmpleado.modificar(empleado);
        }

        public Empleado obtenerPorId(int idEmpleado)
        {
            return daoEmpleado.obtenerPorId(idEmpleado);
        }

        public void validar(Empleado empleado)
        {
            if (empleado.DNI.Trim().Length == 0)
                throw new Exception("El DNI del empleado no puedes estar vacío.");
            if (empleado.DNI.Trim().Length != 8)
                throw new Exception("El DNI del empleado debe ser de 8 dígitos.");
            if (empleado.Nombre.Trim().Length == 0)
                throw new Exception("El nombre del empleado no puede estar vacío.");
            if (empleado.ApellidoPaterno.Trim().Length == 0)
                throw new Exception("El apellido del empleado no puede estar vacío.");
            if (empleado.Cargo.Trim().Length == 0)
                throw new Exception("El cargo del empleado no puede estar vacío.");
            if (empleado.Sueldo <= 0)
                throw new Exception("El sueldo no puede ser un 0 ni un número negativo.");
        }
    }
}
