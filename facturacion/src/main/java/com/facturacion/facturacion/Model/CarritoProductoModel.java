package com.facturacion.facturacion.Model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "carrito_producto")
public class CarritoProductoModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "fk_carrito")
    private CarritoModel carritoModel;
    
    @ManyToOne
    @JoinColumn(name = "fk_producto")
    private ProductsModel productsModel;
    
    private Integer cantidad;

    public CarritoProductoModel() {
    }

    public CarritoProductoModel(Long id, CarritoModel carritoModel, ProductsModel productsModel, Integer cantidad) {
        this.id = id;
        this.carritoModel = carritoModel;
        this.productsModel = productsModel;
        this.cantidad = cantidad;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
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
