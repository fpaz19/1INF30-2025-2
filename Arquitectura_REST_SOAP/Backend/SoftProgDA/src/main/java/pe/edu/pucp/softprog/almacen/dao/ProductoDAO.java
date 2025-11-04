package pe.edu.pucp.softprog.almacen.dao;

import java.util.ArrayList;
import pe.edu.pucp.softprog.almacen.model.Producto;
import pe.edu.pucp.softprog.dao.IDAO;

public interface ProductoDAO extends IDAO<Producto>{
    ArrayList<Producto> listarPorNombre(String nombre);
}
