/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

import java.util.ArrayList;
import java.util.List;

public class HistorialCompras {
    private static final List<Orden> historial = new ArrayList<>();
    public static void agregar(Orden o) { historial.add(o); }
    public static List<Orden> getHistorial() { return new ArrayList<>(historial); }
}