package com.facturacion.facturacion.Model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name ="products")
public class ProductsModel implements Serializable{

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int pkProducto;
    private String nombre;
    private int stock;
    private int precio;
    
    @JsonIgnore
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "productsModel" , cascade = CascadeType.ALL)
    private List <FacturaModel> facturas;
    
    public ProductsModel(){
        this.facturas = new ArrayList<FacturaModel>();
        
    }

    public ProductsModel(int pkProducto, String nombre, int stock, int precio) {
        this.pkProducto = pkProducto;
        this.nombre = nombre;
        this.stock = stock;
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
    public int getStock() {
        return stock;
    }
    public void setStock(int stock) {
        this.stock = stock;
    }
    public int getPrecio() {
        return precio;
    }
    public void setPrecio(int precio) {
        this.precio = precio;
    }
    
}
