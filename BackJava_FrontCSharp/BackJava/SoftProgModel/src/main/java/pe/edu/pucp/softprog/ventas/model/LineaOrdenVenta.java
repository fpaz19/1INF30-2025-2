package pe.edu.pucp.softprog.ventas.model;

import pe.edu.pucp.softprog.almacen.model.Producto;

public class LineaOrdenVenta {
    private int idLineaOrdenVenta;
    private Producto producto;
    private int cantidad;
    private double subtotal;
    private boolean activo;

    public int getIdLineaOrdenVenta() {
        return idLineaOrdenVenta;
    }

    public void setIdLineaOrdenVenta(int idLineaOrdenVenta) {
        this.idLineaOrdenVenta = idLineaOrdenVenta;
    }

    public Producto getProducto() {
        return producto;
    }

    public void setProducto(Producto producto) {
        this.producto = producto;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public double getSubtotal() {
        return subtotal;
    }

    public void setSubtotal(double subtotal) {
        this.subtotal = subtotal;
    }

    public boolean isActivo() {
        return activo;
    }

    public void setActivo(boolean activo) {
        this.activo = activo;
    }
    
    public void calcularSubtotal(){
        subtotal = cantidad * producto.getPrecio();
    }
    
}