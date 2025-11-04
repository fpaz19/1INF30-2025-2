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
    public int eliminar(int idEmpleado) throws Exception {
        return daoEmpleado.eliminar(idEmpleado);
    }
   
    @Override
    public ArrayList listarTodos() throws Exception {
        return daoEmpleado.listarTodos();
    }

    @Override
    public int insertar(Empleado empleado) throws Exception {
        return daoEmpleado.insertar(empleado);
    }

    @Override
    public int modificar(Empleado empleado) throws Exception {
        return daoEmpleado.modificar(empleado);
    }

    @Override
    public void validar(Empleado objeto) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public Empleado obtenerPorId(int idEmpleado) throws Exception {
        return daoEmpleado.obtenerPorId(idEmpleado);
    }
    
}
