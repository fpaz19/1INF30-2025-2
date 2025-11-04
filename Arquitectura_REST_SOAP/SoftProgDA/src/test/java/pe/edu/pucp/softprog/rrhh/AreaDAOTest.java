package pe.edu.pucp.softprog.rrhh;

import java.util.ArrayList;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.TestMethodOrder;
import pe.edu.pucp.softprog.rrhh.dao.AreaDAO;
import pe.edu.pucp.softprog.rrhh.model.Area;
import pe.edu.pucp.softprog.rrhh.mysql.AreaImpl;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class AreaDAOTest {
    
    private static AreaDAO daoArea;
    private static ArrayList<Area> areas;
    
    public AreaDAOTest() {
    }

    @org.junit.jupiter.api.BeforeAll
    public static void setUpClass() throws Exception {
        daoArea = new AreaImpl();
    }

    @org.junit.jupiter.api.AfterAll
    public static void tearDownClass() throws Exception {
    }

    @org.junit.jupiter.api.BeforeEach
    public void setUp() throws Exception {
        
    }

    @org.junit.jupiter.api.AfterEach
    public void tearDown() throws Exception {
    }
    
    @Test
    @Order(2)
    public void verificarRegistro(){
        Area area = new Area("TECNOLOGIAS DE INFORMACION");
        int resultado = daoArea.insertar(area);
        assertTrue(resultado!=0);
    }
    
    @Test
    @Order(1)
    public void verificarObtenerPorId(){
        Area area = daoArea.obtenerPorId(1);
        assertNotNull(area);
    }
    
    @Test
    @Order(3)
    public void verificarListarTodas(){
        areas = daoArea.listarTodos();
        for(Area a : areas) System.out.println(a);
        assertNotNull(areas);
    }
    
    @Test
    @Order(4)
    public void verificarModificacion(){
        areas.get(areas.size()-1).setNombre("RECURSOS INFORMATICOS");
        int resultado = daoArea.modificar(areas.get(areas.size()-1));
        assertTrue(resultado!=0);
    }
    
    @Test
    @Order(5)
    public void verificarEliminacion(){
        int resultado = daoArea.eliminar(areas.get(areas.size()-1).getIdArea());
        assertTrue(resultado!=0);
    }
}
