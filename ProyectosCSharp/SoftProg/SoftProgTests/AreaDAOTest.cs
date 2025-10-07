using Microsoft.VisualStudio.TestTools.UnitTesting;
using SoftProgModel.RRHH;
using SoftProgPersistance.RRHH.DAO;
using SoftProgPersistance.RRHH.Impl;
using System;
using System.ComponentModel;
using static System.Net.Mime.MediaTypeNames;

namespace SoftProgTests
{
    [TestClass]
    public class AreaDAOTest
    {
        private static AreaDAO daoArea;
        private static BindingList<Area> areas;

        [ClassInitialize]
        public static void ClassInitialize(TestContext context)
        {
            daoArea = new AreaImpl();
        }

        [TestMethod]
        public void Prueba1_verificarRegistro()
        {
            Area area = new Area("FINANZAS");
            int resultado = daoArea.insertar(area);
            Assert.IsTrue(resultado != 0);
        }

        [TestMethod]
        public void Prueba2_verificarObtenerPorId()
        {
            Area area = daoArea.obtenerPorId(1);
            Assert.IsNotNull(area);
        }

        [TestMethod]
        public void Prueba3_verificarListarTodas()
        {
            areas = daoArea.listarTodos();
            foreach (Area a in areas) System.Console.WriteLine(a);
            Assert.IsNotNull(areas);
        }
        
        [TestMethod]
        public void Prueba4_verificarModificacion()
        {
            areas[areas.Count - 1].Nombre = "RECURSOS INFORMATICOS"; ;
            int resultado = daoArea.modificar(areas[areas.Count - 1]);
            Assert.IsTrue(resultado != 0);
        }

        [TestMethod]
        public void Prueba5_verificarEliminacion()
        {
            int resultado = daoArea.eliminar(areas[areas.Count - 1].IdArea);
            Assert.IsTrue(resultado != 0);
        }
    }
}
