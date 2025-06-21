/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package Modelo;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class Orden {
    private final List<Producto> productos;
    private double total;
    private final LocalDateTime fecha;

    public Orden(List<Producto> productos, double total, LocalDateTime fecha) {
        this.productos = new ArrayList<>(productos);
        this.total = total;
        this.fecha = fecha;
    }

    public List<Producto> getProductos() {
        return productos;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public LocalDateTime getFecha() {
        return fecha;
    }
}
