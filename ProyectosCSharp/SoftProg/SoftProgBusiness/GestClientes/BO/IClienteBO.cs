using SoftProgBusiness.BO;
using SoftProgModel.GestClientes;
using SoftProgModel.RRHH;
using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace SoftProgBusiness.GestClientes.BO
{
    public interface IClienteBO : IBaseBO<Cliente>
    {
        BindingList<Cliente> listarPorDNIoNombre(String DNIoNombre);
    }
}
