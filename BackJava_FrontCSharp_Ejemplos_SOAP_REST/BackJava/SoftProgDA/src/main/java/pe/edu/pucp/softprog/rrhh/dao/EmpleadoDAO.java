package pe.edu.pucp.softprog.rrhh.dao;

import java.util.ArrayList;
import pe.edu.pucp.softprog.dao.IDAO;
import pe.edu.pucp.softprog.rrhh.model.Empleado;

public interface EmpleadoDAO extends IDAO<Empleado>{
    ArrayList<Empleado> buscarPorDNI(String DNI);
}
