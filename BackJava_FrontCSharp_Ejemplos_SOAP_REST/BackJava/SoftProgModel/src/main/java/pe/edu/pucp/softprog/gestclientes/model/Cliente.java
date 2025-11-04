package pe.edu.pucp.softprog.gestclientes.model;
import java.util.Date;
import pe.edu.pucp.softprog.rrhh.model.Persona;
public class Cliente extends Persona{
    private double lineaCredito;
    private Categoria categoria;
    
    public Cliente(){}
    public Cliente(String dni, String nombre, String apellidoPaterno, char sexo, Date fechaNacimiento, double lineaCredito, Categoria categoria){
        super(dni,nombre,apellidoPaterno,sexo,fechaNacimiento);
        this.lineaCredito = lineaCredito;
        this.categoria = categoria;
    }

    public double getLineaCredito() {
        return lineaCredito;
    }

    public void setLineaCredito(double lineaCredito) {
        this.lineaCredito = lineaCredito;
    }

    public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }
    
}
