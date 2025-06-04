/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controlador;
import Modelo.*;

/**
 *
 * @author jomes
 */
public class ControladorRegistro {
     private ListaUsuario lista;

    public ControladorRegistro(ListaUsuario lista) {
        this.lista = lista;
    }

    public boolean registrar(String nombre, String correo, String clave) {
        Usuario nuevo = new Usuario(nombre, correo, clave);
        return lista.registrarUsuario(nuevo);
    }
}
