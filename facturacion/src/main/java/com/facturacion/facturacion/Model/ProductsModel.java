package com.facturacion.facturacion.Model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name ="products")
public class ProductsModel implements Serializable{

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int pkProducto;
    private String nombre;
    private int precio;
    
    public ProductsModel(){
        
    }

    public ProductsModel(int pkProducto, String nombre, int precio) {
        this.pkProducto = pkProducto;
        this.nombre = nombre;
        this.precio = precio;
    }
    public int getPkProducto() {
        return pkProducto;
    }
    public void setPkProducto(int pkProducto) {
        this.pkProducto = pkProducto;
    }
    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public int getPrecio() {
        return precio;
    }
    public void setPrecio(int precio) {
        this.precio = precio;
    }
    
}
