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
public class ControladorLogin {
     private ListaUsuario lista;

    public ControladorLogin(ListaUsuario lista) {
        this.lista = lista;
    }

    public Usuario validarIngreso(String correo, String clave) {
        return lista.login(correo, clave);
    }
}
