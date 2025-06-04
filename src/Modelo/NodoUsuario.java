/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

/**
 *
 * @author jomes
 */
public class NodoUsuario {
     public Usuario dato;
    public NodoUsuario sig;

    public NodoUsuario(Usuario dato) {
        this.dato = dato;
        this.sig = null;
    }
}
