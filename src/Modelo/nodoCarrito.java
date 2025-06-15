/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

/**
 *
 * @author jomes
 */
public class nodoCarrito {
    public Producto producto;
    public nodoCarrito sig;

    public nodoCarrito(Producto producto) {
        this.producto = producto;
        this.sig = null;
    }
}
