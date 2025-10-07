using SoftProgModel.GestClientes;
using SoftProgModel.RRHH;
using SoftProgPersistance.DAO;
using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace SoftProgPersistance.GestClientes.DAO
{
    public interface ClienteDAO : IDAO<Cliente>
    {
        BindingList<Cliente> listarPorDNIoNombre(String DNIoNombre);
     }
}
