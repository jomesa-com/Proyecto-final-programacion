/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

/**
 *
 * @author jomes
 */
public class ListaUsuario {
    private NodoUsuario cab;
    
     public ListaUsuario() {
        cab = null;
    }

    public boolean registrarUsuario(Usuario nuevo) {
        if (existeCorreo(nuevo.correo)) return false;

        NodoUsuario nuevoNodo = new NodoUsuario(nuevo);
        if (cab == null) {
            cab = nuevoNodo;
        } else {
            NodoUsuario p = cab;
            while (p.sig != null) {
                p = p.sig;
            }
            p.sig = nuevoNodo;
        }
        return true;
    }

    public Usuario login(String correo, String contraseña) {
        NodoUsuario p = cab;
        while (p != null) {
            if (p.dato.correo.equalsIgnoreCase(correo) && p.dato.contraseña.equals(contraseña)) {
                return p.dato;
            }
            p = p.sig;
        }
        return null;
    }

    private boolean existeCorreo(String correo) {
        NodoUsuario p = cab;
        while (p != null) {
            if (p.dato.correo.equalsIgnoreCase(correo)) return true;
            p = p.sig;
        }
        return false;
    }
}
