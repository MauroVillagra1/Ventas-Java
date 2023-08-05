package javaapplication97.modelo;
import java.sql.*;
import java.util.ArrayList;
public class DB {
    
        public static ArrayList<Producto> obtenerProductos(String palabra){
        ArrayList<Producto> resultado = new ArrayList<>();
        int i = 0;
        try {
            Connection c = DriverManager.getConnection(
              "jdbc:mariadb://localhost/ventas","root","1234");
            PreparedStatement sql = c.prepareStatement(
               "SELECT * from producto where nombre like '%"+palabra+"%'");
            ResultSet res = sql.executeQuery();
            while (res.next()){
                Producto p = new Producto();
                p.setPrecio(i);
                p.setNombre(res.getString("nombre"));
                p.setPrecio(res.getDouble("precio"));
                resultado.add(p);
                i= (i + 1);
            }            
        } catch(Exception e){
            e.printStackTrace();
        }
        return resultado;
    }

    
    
    
    public static ArrayList<Producto> obtenerProductos(){
        int i = 0;
        ArrayList<Producto> resultado = new ArrayList<>();
        try {
            Connection c = DriverManager.getConnection(
              "jdbc:mariadb://localhost/ventas","root","1234");
            PreparedStatement sql = c.prepareStatement("SELECT * from producto");
            ResultSet res = sql.executeQuery();
            while (res.next()){
                Producto p = new Producto();
                p.setPrecio(i);
                p.setNombre(res.getString("nombre"));
                p.setPrecio(res.getDouble("precio"));
                resultado.add(p);
                i= (i + 1);

            }            
        } catch(Exception e){
            e.printStackTrace();
        }
        return resultado;
    }
    
    
  
    
 public static void agregar(Producto producto) {
    try {
        Connection c = DriverManager.getConnection(
            "jdbc:mariadb://localhost/ventas", "root", "1234");
        PreparedStatement sql = c.prepareStatement(
            "INSERT INTO PRODUCTO (nombre, precio) VALUES (?, ?)");
        sql.setString(1, producto.getNombre());
        sql.setDouble(2, producto.getPrecio());
        sql.executeUpdate();
        System.out.print(sql);
        // Cierre de recursos
        sql.close();
        c.close();
    } catch (Exception e) {
        e.printStackTrace();
    }
}


}
