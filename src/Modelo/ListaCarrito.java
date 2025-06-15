/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

/**
 *
 * @author jomes
 */
public class ListaCarrito {
    private nodoCarrito cab;
    
    public ListaCarrito(){
        cab=null;
    }
    
      public boolean esVacia() {
        return cab == null;
    }
      
    public void Insertar(Producto producto){
        nodoCarrito nuevo = new nodoCarrito(producto);
        
        if (cab==null){
            cab=nuevo;
        }else{
            nodoCarrito p=cab;
            while(p.sig!=null){
                p=p.sig;
            }
        p.sig=nuevo;
        }
    }
    
     public void vaciar() {
        cab = null;
    }
     
     public double calcularTotal(){
         double total=0;
         nodoCarrito p=cab;
         while(p!=null){
             total+=p.producto.getPrecio();
             p=p.sig;
         }
         return total;
     }
     
     public nodoCarrito getCabecera(){
         return cab;
     }
}
