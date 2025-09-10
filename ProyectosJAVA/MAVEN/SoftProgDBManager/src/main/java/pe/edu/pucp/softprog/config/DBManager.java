package pe.edu.pucp.softprog.config;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
public class DBManager {
    
    private static DBManager dbManager;
    private final String url; 
    private final String user;
    private final String password;
    private Connection con;
    
    private DBManager(){
        this.url = "jdbc:mysql://"
                + "database-prog3-0681."
                + "czyu42uq2yue.us-east-1.rds."
                + "amazonaws.com/prog3";
        this.user = "admin";
        this.password = "1inf300681prog3";
    }
    
    public static DBManager getInstance(){
        if(dbManager == null)
            dbManager = new DBManager();
        return dbManager;
    }
    
    public Connection getConnection(){
        try{
            if(con == null || con.isClosed()){
                Class.forName("com.mysql.cj.jdbc.Driver");
                con = DriverManager.getConnection
                (url,user,password);
            }
        }catch(ClassNotFoundException | SQLException ex){
            System.out.println("ERROR AL INTENTAR "
                    + "CONECTAR CON LA BD: " +
                    ex.getMessage());
        }
        return con;
    }
    
    public void cerrarConexion(){
        try{
            con.close();
        }catch(Exception ex){
            System.out.println("ERROR AL CERRAR LA CONEXION: "
            + ex.getMessage());
        }
    }
}
