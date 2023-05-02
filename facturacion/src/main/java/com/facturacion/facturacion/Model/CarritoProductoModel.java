package com.facturacion.facturacion.Model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "carrito_producto")
public class CarritoProductoModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "pk_carrito_producto")
    private int id;

    @ManyToOne
    @JoinColumn(name = "fk_carrito")
    private CarritoModel carritoModel;
    
    @ManyToOne
    @JoinColumn(name = "fk_producto")
    private ProductsModel productsModel;
    
    @Column(name = "cantidad")
    private Integer cantidad;

    public CarritoProductoModel() {

    }

    public CarritoProductoModel(int id, CarritoModel carritoModel, ProductsModel productsModel, int cantidad) {
        this.id = id;
        this.carritoModel = carritoModel;
        this.productsModel = productsModel;
        this.cantidad = cantidad;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public CarritoModel getCarritoModel() {
        return carritoModel;
    }

    public void setCarritoModel(CarritoModel carritoModel) {
        this.carritoModel = carritoModel;
    }

    public ProductsModel getProductoModel() {
        return productsModel;
    }

    public void setProductoModel(ProductsModel productsModel) {
        this.productsModel = productsModel;
    }

    public Integer getCantidad() {
        return cantidad;
    }

    public void setCantidad(Integer cantidad) {
        this.cantidad = cantidad;
    }

}
