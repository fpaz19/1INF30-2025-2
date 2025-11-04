package pe.edu.pucp.softprog.ventas.model;

import java.util.ArrayList;
import java.util.Date;
import pe.edu.pucp.softprog.gestclientes.model.Cliente;
import pe.edu.pucp.softprog.rrhh.model.Empleado;

public class OrdenVenta {
    private int idOrdenVenta;
    private Empleado empleado;
    private Cliente cliente;
    private ArrayList<LineaOrdenVenta> lineasOrdenVenta;
    private double total;
    private Date fechaHora;
    private boolean activa;

    public OrdenVenta(){
        this.lineasOrdenVenta = new ArrayList<>();
    }
    
    public int getIdOrdenVenta() {
        return idOrdenVenta;
    }

    public void setIdOrdenVenta(int idOrdenVenta) {
        this.idOrdenVenta = idOrdenVenta;
    }

    public ArrayList<LineaOrdenVenta> getLineasOrdenVenta() {
        return lineasOrdenVenta;
    }

    public void setLineasOrdenVenta(ArrayList<LineaOrdenVenta> lineasOrdenVenta) {
        this.lineasOrdenVenta = lineasOrdenVenta;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public Date getFechaHora() {
        return fechaHora;
    }

    public void setFechaHora(Date fechaHora) {
        this.fechaHora = fechaHora;
    }

    public boolean isActiva() {
        return activa;
    }

    public void setActiva(boolean activa) {
        this.activa = activa;
    }

    public Empleado getEmpleado() {
        return empleado;
    }

    public void setEmpleado(Empleado empleado) {
        this.empleado = empleado;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }
    
    public void agregarLineaOrdenVenta(LineaOrdenVenta lov){
        this.lineasOrdenVenta.add(lov);
    }
    
    public void calcularTotal(){
        total = 0;
        for(LineaOrdenVenta lov : lineasOrdenVenta){
            total += lov.getSubtotal();
        }
    }
}