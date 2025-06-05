/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;
import javafx.beans.property.*;
/**
 *
 * @author jomes
 */
public class Producto {
    
    private final StringProperty codigo;
    private final StringProperty nombre;
    private final StringProperty talla;
    private final StringProperty color;
    private final DoubleProperty precio;
    private final IntegerProperty stock;
    private final StringProperty categoria;

    public Producto(String codigo, String nombre, String talla, String color, double precio, int stock, String categoria) {
        this.codigo = new SimpleStringProperty(codigo);
        this.nombre = new SimpleStringProperty(nombre);
        this.talla = new SimpleStringProperty(talla);
        this.color = new SimpleStringProperty(color);
        this.precio = new SimpleDoubleProperty(precio);
        this.stock = new SimpleIntegerProperty(stock);
        this.categoria = new SimpleStringProperty(categoria);
    }
    
     public StringProperty codigoProperty() { return codigo; }
    public StringProperty nombreProperty() { return nombre; }
    public StringProperty tallaProperty() { return talla; }
    public StringProperty colorProperty() { return color; }
    public DoubleProperty precioProperty() { return precio; }
    public IntegerProperty stockProperty() { return stock; }
    public StringProperty categoriaProperty() { return categoria; }

    public String getCodigo() { return codigo.get(); }
    public void setCodigo(String v) { codigo.set(v); }

    public String getNombre() { return nombre.get(); }
    public void setNombre(String v) { nombre.set(v); }

    public String getTalla() { return talla.get(); }
    public void setTalla(String v) { talla.set(v); }

    public String getColor() { return color.get(); }
    public void setColor(String v) { color.set(v); }

    public double getPrecio() { return precio.get(); }
    public void setPrecio(double v) { precio.set(v); }

    public int getStock() { return stock.get(); }
    public void setStock(int v) { stock.set(v); }

    public String getCategoria() { return categoria.get(); }
    public void setCategoria(String v) { categoria.set(v); }
    
}
