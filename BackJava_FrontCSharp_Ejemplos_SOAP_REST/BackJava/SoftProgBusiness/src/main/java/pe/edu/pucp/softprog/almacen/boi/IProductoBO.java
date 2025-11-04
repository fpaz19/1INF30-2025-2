package pe.edu.pucp.softprog.almacen.boi;

import java.util.ArrayList;
import pe.edu.pucp.softprog.almacen.model.Producto;
import pe.edu.pucp.softprog.bo.IBaseBO;

public interface IProductoBO extends IBaseBO<Producto>{
    ArrayList<Producto> listarPorNombre(String nombre);
}
