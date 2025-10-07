using SoftProgBusiness.GestClientes.BO;
using SoftProgModel.GestClientes;
using SoftProgPersistance.GestClientes.DAO;
using SoftProgPersistance.GestClientes.Impl;
using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace SoftProgBusiness.GestClientes.BOI
{
    public class ClienteBOImpl : IClienteBO
    {
        private ClienteDAO daoCliente;

        public ClienteBOImpl()
        {
            daoCliente = new ClienteImpl();
        }
        public int eliminar(int idObjeto)
        {
            throw new NotImplementedException();
        }

        public int insertar(Cliente objeto)
        {
            throw new NotImplementedException();
        }

        public BindingList<Cliente> listarPorDNIoNombre(string DNIoNombre)
        {
            return daoCliente.listarPorDNIoNombre(DNIoNombre);
        }

        public BindingList<Cliente> listarTodos()
        {
            throw new NotImplementedException();
        }

        public int modificar(Cliente objeto)
        {
            throw new NotImplementedException();
        }

        public Cliente obtenerPorId(int idObjeto)
        {
            throw new NotImplementedException();
        }

        public void validar(Cliente objeto)
        {
            throw new NotImplementedException();
        }
    }
}
