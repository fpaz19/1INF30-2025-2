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
    public class AreaBOImpl : IAreaBO
    {
        private AreaDAO daoArea;
        public AreaBOImpl()
        {
            daoArea = new AreaImpl();
        }

        public int eliminar(int idArea)
        {
            return daoArea.eliminar(idArea);
        }

        public int insertar(Area area)
        {
            validar(area);
            return daoArea.insertar(area);
        }

        public BindingList<Area> listarTodos()
        {
            return daoArea.listarTodos();
        }

        public int modificar(Area area)
        {
            validar(area);
            return daoArea.modificar(area);
        }

        public Area obtenerPorId(int idObjeto)
        {
            throw new NotImplementedException();
        }

        public void validar(Area area)
        {
            if (area.Nombre.Trim().Length == 0)
                throw new Exception("El nombre del area a registrar esta vacio.");
            if (area.Nombre.Trim().Length > 75)
                throw new Exception("El nombre a registrar excede los 75 caracteres.");
        }
    }
}
