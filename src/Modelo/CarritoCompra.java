/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

import java.util.ArrayList;
import java.util.List;

public class CarritoCompra {
    private static final CarritoCompra instancia = new CarritoCompra();
    private final List<Producto> items = new ArrayList<>();

    private CarritoCompra() {}
    public static CarritoCompra getInstancia() { return instancia; }

    public void agregar(Producto p) { items.add(p); }
    public void remover(Producto p) { items.remove(p); }
    public List<Producto> getItems() { return new ArrayList<>(items); }
    public double getTotal() { return items.stream().mapToDouble(Producto::getPrecio).sum(); }
    public void vaciar() { items.clear(); }
}