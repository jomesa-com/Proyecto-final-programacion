/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;
import java.util.ArrayList;
import java.util.List;
/**
 *
 * @author Juan Daniel
 */
public class ListaDeseos {
    private static List<Producto> deseos = new ArrayList<>();

    public static List<Producto> getDeseos() {
        return deseos;
    }

    public static void agregar(Producto p) {
        if (!deseos.contains(p)) deseos.add(p);
    }

    public static void eliminar(Producto p) {
        deseos.remove(p);
    }

    public static void limpiar() {
        deseos.clear();
    }
}

