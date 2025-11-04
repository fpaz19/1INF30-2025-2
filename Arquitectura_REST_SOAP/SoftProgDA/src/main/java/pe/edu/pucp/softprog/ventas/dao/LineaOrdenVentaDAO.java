package pe.edu.pucp.softprog.ventas.dao;

import java.util.ArrayList;
import pe.edu.pucp.softprog.ventas.model.LineaOrdenVenta;

public interface LineaOrdenVentaDAO {
    ArrayList<LineaOrdenVenta> listarPorIdOrdenVenta(int idOrdenVenta);
}