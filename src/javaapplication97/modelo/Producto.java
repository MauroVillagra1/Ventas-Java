package javaapplication97.modelo;

public class Producto {
    
    private String nombre;
    private double precio;

    @Override
    public String toString() {
        return "Producto{" + ", nombre=" + nombre + ", precio=" + precio + '}';
    }

    public Producto() {
    }

    public Producto(String nombre, double precio) {
        this.nombre = nombre;
        this.precio = precio;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

  

  

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
}
