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
        // Puedes cargar algunos productos de ejemplo al inicio
        listaProductos.add(new Producto("P001", "Camiseta Futbol", "M", "Azul", 79_900, 10, "Pantalón"));
        listaProductos.add(new Producto("C001", "Camiseta Blanca", "L", "Blanco", 29_900, 20, "Camiseta"));
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
