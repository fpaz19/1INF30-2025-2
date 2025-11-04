package pe.edu.pucp.softprog.gestclientes.boi;

import java.util.ArrayList;
import pe.edu.pucp.softprog.bo.IBaseBO;
import pe.edu.pucp.softprog.gestclientes.model.Cliente;

public interface IClienteBO extends IBaseBO<Cliente>{
    ArrayList<Cliente> listarPorDNIoNombre(String DNInombre);
}
