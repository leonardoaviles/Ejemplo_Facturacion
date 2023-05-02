package com.facturacion.facturacion.Model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name ="products")
public class ProductsModel implements Serializable{

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "pk_producto")
    private int pkProducto;
    private String nombre;
    private String codigo;
    private int stock;
    private double precio;

    @JsonIgnore
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "productsModel" , cascade = CascadeType.ALL)
    private List<CarritoProductoModel> carritoProductoModel;
    
    public ProductsModel(){
        this.carritoProductoModel = new ArrayList<CarritoProductoModel>();
        
    }

    public ProductsModel(int pkProducto, String nombre, String codigo, int stock, double precio) {
        this.pkProducto = pkProducto;
        this.nombre = nombre;
        this.codigo = codigo;
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
    public String getCodigo() {
        return codigo;
    }
    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public int getStock() {
        return stock;
    }
    public void setStock(int stock) {
        this.stock = stock;
    }
    public double getPrecio() {
        return precio;
    }
    public void setPrecio(double precio) {
        this.precio = precio;
    }
    
}
