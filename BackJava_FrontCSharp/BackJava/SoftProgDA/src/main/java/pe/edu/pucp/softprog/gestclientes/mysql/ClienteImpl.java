package pe.edu.pucp.softprog.gestclientes.mysql;

import java.util.ArrayList;
import pe.edu.pucp.softprog.gestclientes.dao.ClienteDAO;
import pe.edu.pucp.softprog.gestclientes.model.Cliente;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.HashMap;
import java.util.Map;
import pe.edu.pucp.softprog.config.DBManager;
import pe.edu.pucp.softprog.gestclientes.model.Categoria;

public class ClienteImpl implements ClienteDAO{

    private ResultSet rs;
    
    @Override
    public int insertar(Cliente cliente) {
        Map<Integer,Object> parametrosSalida = new HashMap<>();   
        Map<Integer,Object> parametrosEntrada = new HashMap<>();
        parametrosSalida.put(1, Types.INTEGER);
        parametrosEntrada.put(2, cliente.getDni());
        parametrosEntrada.put(3, cliente.getNombre());
        parametrosEntrada.put(4, cliente.getApellidoPaterno());
        parametrosEntrada.put(5, cliente.getSexo());
        parametrosEntrada.put(6, cliente.getFechaNacimiento());
        parametrosEntrada.put(7, cliente.getLineaCredito());
        parametrosEntrada.put(8, cliente.getCategoria().toString());
        DBManager.getInstance().ejecutarProcedimiento("INSERTAR_CLIENTE", parametrosEntrada, parametrosSalida);
        cliente.setIdPersona((int) parametrosSalida.get(1));
        System.out.println("Se ha realizado el registro del cliente");
        return cliente.getIdPersona();
    }

    @Override
    public int modificar(Cliente cliente) {
        Map<Integer,Object> parametrosEntrada = new HashMap<>();
        parametrosEntrada.put(1, cliente.getIdPersona());
        parametrosEntrada.put(2, cliente.getDni());
        parametrosEntrada.put(3, cliente.getNombre());
        parametrosEntrada.put(4, cliente.getApellidoPaterno());
        parametrosEntrada.put(5, cliente.getSexo());
        parametrosEntrada.put(6, cliente.getFechaNacimiento());
        parametrosEntrada.put(7, cliente.getLineaCredito());
        parametrosEntrada.put(8, cliente.getCategoria().toString());
        int resultado = DBManager.getInstance().ejecutarProcedimiento("MODIFICAR_CLIENTE", parametrosEntrada, null);
        System.out.println("Se ha realizado la modificacion del cliente");
        return resultado;
    }

    @Override
    public int eliminar(int idObjeto) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public Cliente obtenerPorId(int idCliente) {
        Cliente cliente = null;
        Map<Integer, Object> parametrosEntrada = new HashMap<>();
        parametrosEntrada.put(1, idCliente);
        rs = DBManager.getInstance().ejecutarProcedimientoLectura("OBTENER_CLIENTE_X_ID", parametrosEntrada);
        System.out.println("Lectura de cliente...");
        try{
            while(rs.next()){
                if(cliente == null) cliente = new Cliente();
                cliente.setIdPersona(rs.getInt("id_cliente"));
                cliente.setDni(rs.getString("DNI"));
                cliente.setNombre(rs.getString("nombre"));
                cliente.setApellidoPaterno(rs.getString("apellido_paterno"));
                cliente.setSexo(rs.getString("sexo").charAt(0));
                cliente.setFechaNacimiento(rs.getDate("fecha_nacimiento"));
                cliente.setLineaCredito(rs.getDouble("linea_credito"));
                cliente.setCategoria(Categoria.valueOf(rs.getString("categoria")));
            }
        }catch(SQLException ex){
            System.out.println(ex.getMessage());
        }finally{
            DBManager.getInstance().cerrarConexion();
        }
        return cliente;
    }

    @Override
    public ArrayList<Cliente> listarTodos() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
}
