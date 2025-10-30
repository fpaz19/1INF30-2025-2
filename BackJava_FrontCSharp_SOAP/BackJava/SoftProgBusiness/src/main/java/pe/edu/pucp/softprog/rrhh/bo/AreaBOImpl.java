package pe.edu.pucp.softprog.rrhh.bo;


import java.util.ArrayList;
import pe.edu.pucp.softprog.rrhh.dao.AreaDAO;
import pe.edu.pucp.softprog.rrhh.model.Area;
import pe.edu.pucp.softprog.rrhh.mysql.AreaImpl;
import pe.edu.pucp.softprog.rrhh.boi.IAreaBO;

public class AreaBOImpl implements IAreaBO{
    
    private final AreaDAO daoArea;
    
    public AreaBOImpl(){
        daoArea = new AreaImpl();
    }
    
    @Override
    public int insertar(Area area) throws Exception{
        validar(area);
        return daoArea.insertar(area);
    }
    
    @Override
    public int modificar(Area area) throws Exception{
        validar(area);
        return daoArea.modificar(area);
    }
    
    @Override
    public Area obtenerPorId(int idArea) throws Exception{
        return daoArea.obtenerPorId(idArea);
    }
    
    @Override
    public ArrayList<Area> listarTodos() throws Exception{
        return daoArea.listarTodos();
    }
    
    @Override
    public void validar(Area area) throws Exception{
        if(area.getNombre().trim().isEmpty())
            throw new RuntimeException("El nombre del area a registrar esta vacio.");
        if(area.getNombre().trim().length()>75)
            throw new RuntimeException("El nombre a registrar excede los 75 caracteres.");
    }

    @Override
    public int eliminar(int idArea) throws Exception {
        return daoArea.eliminar(idArea);
    }
 
}