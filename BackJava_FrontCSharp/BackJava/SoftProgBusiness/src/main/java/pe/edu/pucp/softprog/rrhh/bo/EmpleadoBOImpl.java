package pe.edu.pucp.softprog.rrhh.bo;

import java.util.ArrayList;
import pe.edu.pucp.softprog.rrhh.dao.EmpleadoDAO;
import pe.edu.pucp.softprog.rrhh.model.Empleado;
import pe.edu.pucp.softprog.rrhh.mysql.EmpleadoImpl;
import pe.edu.pucp.softprog.rrhh.boi.IEmpleadoBO;

public class EmpleadoBOImpl implements IEmpleadoBO{

    private final EmpleadoDAO daoEmpleado;
    
    public EmpleadoBOImpl(){
        daoEmpleado = new EmpleadoImpl();
    }
    


    @Override
    public int eliminar(int idObjeto) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

   
    @Override
    public ArrayList listarTodos() throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }



    @Override
    public int insertar(Empleado objeto) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public int modificar(Empleado objeto) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void validar(Empleado objeto) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public Empleado obtenerPorId(int idEmpleado) throws Exception {
        Empleado e = daoEmpleado.obtenerPorId(idEmpleado);
//        Area area = daoArea.obtenerPorId(e.get);
//        e.setArea(area);
        return e;
    }
    
}
