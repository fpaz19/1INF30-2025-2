package pe.edu.pucp.softprog.rrhh.model;
import java.util.Date;
public class Persona {
    
    private int idPersona;
    private String dni;
    private String nombre;
    private String apellidoPaterno;
    private char genero;
    private Date fechaNacimiento;
    public int edad;

    public Persona(){}
    
    public Persona(String dni, String nombre, String apellidoPaterno, char genero, Date fechaNacimiento) {
        this.dni = dni;
        this.nombre = nombre;
        this.apellidoPaterno = apellidoPaterno;
        this.genero = genero;
        this.fechaNacimiento = fechaNacimiento;
    }
    
    public int getIdPersona() {
        return idPersona;
    }

    public void setIdPersona(int idPersona) {
        this.idPersona = idPersona;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellidoPaterno() {
        return apellidoPaterno;
    }

    public void setApellidoPaterno(String apellidoPaterno) {
        this.apellidoPaterno = apellidoPaterno;
    }

    public char getGenero() {
        return genero;
    }

    public void setGenero(char genero) {
        this.genero = genero;
    }

    public Date getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(Date fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }
    
}
