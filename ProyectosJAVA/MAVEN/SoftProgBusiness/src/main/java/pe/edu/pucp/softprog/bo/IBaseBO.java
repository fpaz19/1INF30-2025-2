package pe.edu.pucp.softprog.bo;

import java.util.ArrayList;

public interface IBaseBO <T>{
    int insertar(T objeto) throws Exception;
    int modificar(T objeto) throws Exception;
    int eliminar(int idObjeto) throws Exception;
    T obtenerPorId(int idObjeto) throws Exception;
    ArrayList<T> listarTodos() throws Exception;
    void validar(T objeto) throws Exception;
}