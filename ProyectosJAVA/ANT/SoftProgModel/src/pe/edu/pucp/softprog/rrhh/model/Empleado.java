package pe.edu.pucp.softprog.rrhh.model;

import java.util.Date;

public class Empleado extends Persona{
    private String cargo;
    private double sueldo;
    private boolean activo;
    

    public Empleado(String cargo, double sueldo, boolean activo, String dni, String nombre, String apellidoPaterno, char genero, Date fechaNacimiento) {
        super(dni, nombre, apellidoPaterno, genero, fechaNacimiento);
        this.cargo = cargo;
        this.sueldo = sueldo;
        this.activo = activo;
    }
    
    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

    public double getSueldo() {
        return sueldo;
    }

    public void setSueldo(double sueldo) {
        this.sueldo = sueldo;
    }

    public boolean isActivo() {
        return activo;
    }

    public void setActivo(boolean activo) {
        this.activo = activo;
    }
    
    
}
