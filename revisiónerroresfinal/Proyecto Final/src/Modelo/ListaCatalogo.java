/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class ListaCatalogo {

    private static final ObservableList<Producto> listaProductos = FXCollections.observableArrayList();

    static {
        
        listaProductos.add(new Producto("P001", "Camiseta Futbol", "M", "Azul", 79_900, 10, "Hombres", "/Imagenes/camiseta1.jpg"));
        listaProductos.add(new Producto("C001", "Pantalón Azul", "L", "Blanco", 29_900, 20, "Mujeres", "/Imagenes/pantalon1.jpg"));
        listaProductos.add(new Producto("P002", "Camiseta Oversize", "L", "Negro", 59_900, 15, "Hombres", "/Imagenes/camiseta2.jpg"));
        listaProductos.add(new Producto("P012", "Bermuda Sport", "M", "Azul Marino", 79_900, 20, "Infantil", "/Imagenes/bermuda1.jpg"));
        listaProductos.add(new Producto("P013", "Chaqueta Corta", "S", "Verde Oliva Claro", 139_900, 9, "Mujeres", "/Imagenes/chaqueta1.jpg"));
    }
    
    public static ObservableList<Producto> getProductos() {
        return listaProductos;
    }

    public static void agregarProducto(Producto p) {
        listaProductos.add(p);
    }

    public static void eliminarProducto(Producto p) {
        listaProductos.remove(p);
    }
}
