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
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.Data;

@Entity
@Table(name ="products")
@Data
@JsonIgnoreProperties({"hibernateLazyInitializer"})
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
    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "productsModel" , cascade = CascadeType.ALL)
    private List<CarritoProductoModel> carritoProductoModel;

    @JsonIgnore
    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    @OneToMany(mappedBy = "productsModel")
    private List<DetalleFacturaModel> detallesFacturaModel;
    
    public ProductsModel(){
        this.carritoProductoModel = new ArrayList<CarritoProductoModel>();
        this.detallesFacturaModel = new ArrayList<DetalleFacturaModel>();
        
    }

    public ProductsModel(int pkProducto, String nombre, String codigo, int stock, double precio) {
        this.pkProducto = pkProducto;
        this.nombre = nombre;
        this.codigo = codigo;
        this.stock = stock;
        this.precio = precio;
    }
     
}
