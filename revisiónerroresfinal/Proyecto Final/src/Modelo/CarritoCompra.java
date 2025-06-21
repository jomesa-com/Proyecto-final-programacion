/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

import java.util.ArrayList;
import java.util.List;

public class CarritoCompra {
    private static final CarritoCompra instancia = new CarritoCompra();

    private List<Producto> productos = new ArrayList<>();

    private CarritoCompra() {} 

    public static CarritoCompra getInstancia() {
        return instancia;
    }

    public void agregarProducto(Producto producto) {
        productos.add(producto);
    }

    public List<Producto> getItems() {
        return new ArrayList<>(productos); 
    }

    public double getTotal() {
        return productos.stream().mapToDouble(Producto::getPrecio).sum();
    }

    public void vaciar() {
        productos.clear();
    }
}
