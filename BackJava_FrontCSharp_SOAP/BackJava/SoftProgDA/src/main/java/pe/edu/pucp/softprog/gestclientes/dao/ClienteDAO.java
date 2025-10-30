package pe.edu.pucp.softprog.gestclientes.dao;

import java.util.ArrayList;
import pe.edu.pucp.softprog.dao.IDAO;
import pe.edu.pucp.softprog.gestclientes.model.Cliente;

public interface ClienteDAO extends IDAO<Cliente>{
    ArrayList<Cliente> listarPorDNIoNombre(String DNInombre);
}
