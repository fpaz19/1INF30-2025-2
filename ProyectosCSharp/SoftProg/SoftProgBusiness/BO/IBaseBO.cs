using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace SoftProgBusiness.BO
{
    public interface IBaseBO <T>
    {
        int insertar(T objeto);
        int modificar(T objeto);
        int eliminar(int idObjeto);
        T obtenerPorId(int idObjeto);
        BindingList<T> listarTodos();
        void validar(T objeto);
    }
}
