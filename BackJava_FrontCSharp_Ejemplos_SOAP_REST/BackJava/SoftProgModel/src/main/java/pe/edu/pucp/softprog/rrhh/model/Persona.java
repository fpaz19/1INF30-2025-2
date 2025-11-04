package pe.edu.pucp.softprog.rrhh.model;
import java.text.SimpleDateFormat;
import java.util.Date;
public class Persona {
    private int idPersona;
    private String dni;
    private String nombre;
    private String apellidoPaterno;
    private char sexo;
    private Date fechaNacimiento;

    public Persona(){}
    public Persona(int idPersona, String dni, String nombre, String apellidoPaterno, char sexo, Date fechaNacimiento){
        this.idPersona = idPersona;
        this.dni = dni;
        this.nombre = nombre;
        this.apellidoPaterno = apellidoPaterno;
        this.sexo = sexo;
        this.fechaNacimiento = fechaNacimiento;
    }
    public Persona(String dni, String nombre, String apellidoPaterno, char sexo, Date fechaNacimiento){
        this.dni = dni;
        this.nombre = nombre;
        this.apellidoPaterno = apellidoPaterno;
        this.sexo = sexo;
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

    public char getSexo() {
        return sexo;
    }

    public void setSexo(char sexo) {
        this.sexo = sexo;
    }

    public Date getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(Date fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    @Override
    public String toString() {
        SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
        String fechaNac = null;
        try{
            fechaNac = sdf.format(fechaNacimiento);
        }catch(Exception ex){
            System.out.println("Error convirtiendo fecha");
        }
        return idPersona + "\n" + 
               "Nombre: " + nombre + "\n" +
               "Apellido Paterno: " + apellidoPaterno + "\n" +
               "Sexo: " + sexo + "\n" +
               "Fecha de nacimiento: " + fechaNac;
    }
    
    
}