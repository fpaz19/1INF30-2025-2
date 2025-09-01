package pe.edu.pucp.softprog.gestclientes.model;
import pe.edu.pucp.softprog.rrhh.model.Persona;
public class Cliente extends Persona{
    private double lineaCredito;
    private Categoria categoria;

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
