package pe.edu.pucp.softprog.rrhh.model;
public class Area {
    private int idArea;
    private String nombre;
    private boolean activo;

    public Area(){}
    
    public Area(String nombre) {
        this.nombre = nombre;
    }
    
    public int getIdArea() {
        return idArea;
    }

    public void setIdArea(int idArea) {
        this.idArea = idArea;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public boolean isActivo() {
        return activo;
    }

    public void setActivo(boolean activo) {
        this.activo = activo;
    }

    @Override
    public String toString() {
        return "Area: " + "idArea = " + idArea + ", nombre = " + nombre + ", activo = " + activo;
    }
}
