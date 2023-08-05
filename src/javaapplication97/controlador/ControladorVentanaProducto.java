package javaapplication97.controlador;

import javaapplication97.modelo.DB;
import javaapplication97.modelo.Producto;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

public class ControladorVentanaProducto {
    //Evento del boton Agregar
public static void Agregar(String nombre, double precio){
        Producto producto = new Producto(nombre, precio);
        DB.agregar(producto);
    }

    public static void Mostrar(TableModel model) {
    int i = 1;
    
    
    DefaultTableModel modelo = (DefaultTableModel) model;
    modelo.setNumRows(0);       
    for (Producto producto : DB.obtenerProductos()){
        modelo.addRow(
                new Object[]{
                i,
                 producto.getNombre(),
                 producto.getPrecio()
                });
        i = (i+1);
    }
}

    public static void Mostrar(TableModel model, String palabra) {
    int i = 0;
    DefaultTableModel modelo = (DefaultTableModel) model;
    modelo.setNumRows(0);       
    for (Producto producto : DB.obtenerProductos()){
        modelo.addRow(
                new Object[]{
                i,
                 producto.getNombre(),
                 producto.getPrecio()
                });
        i = (i+1);
    }
}


    
}
