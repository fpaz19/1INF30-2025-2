package pe.edu.pucp.softprog.main;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import pe.edu.pucp.softprog.rrhh.dao.AreaDAO;
import pe.edu.pucp.softprog.rrhh.mysql.AreaImpl;
import pe.edu.pucp.softprog.rrhh.model.Area;
import pe.edu.pucp.softprog.rrhh.model.Empleado;

public class Principal {
    public static void main(String[] args){
//        try{
//            //Registrar el DRIVER de conexion
//            Class.forName("com.mysql.cj.jdbc.Driver");
//            //Abrimos la conexion con la BD
//            Connection con 
//                = DriverManager.getConnection
//        ("jdbc:mysql://"
//                + "database-prog3-0681."
//                + "czyu42uq2yue.us-east-1.rds."
//                + "amazonaws.com/prog3", 
//                "admin", "1inf300681prog3");
//            System.out.println("SE HA EFECTUADO LA CONEXION");
//            Statement st = con.createStatement();
//            //String sql = "INSERT INTO area(nombre,activa) "
//            //        + "VALUES('FINANZAS',1)";
//            String sql = "UPDATE area SET activa = 0 WHERE"
//                    + " id_area = 2";
//            st.executeUpdate(sql);
//            System.out.println("SE HA REGISTRADO EL AREA");
//            sql = "SELECT id_area, nombre, activa FROM"
//                    + " area";
//            ResultSet rs = st.executeQuery(sql);
//            while(rs.next()){
//                System.out.println(rs.getInt("id_area"));
//                System.out.println(rs.getString("nombre"));
//                System.out.println(rs.getInt("activa"));
//            }
//            con.close();
//        }catch(Exception ex){
//            System.out.println("ERROR AL INTENTAR "
//                    + "CONECTAR CON LA BD: " +
//                    ex.getMessage());
//        }
        Area objArea = new Area("RECURSOS HUMANOS");
        AreaDAO objAreaDA = new AreaImpl();
        objAreaDA.insertar(objArea);
        
    }
}
