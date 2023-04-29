package com.facturacion.facturacion.Model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name = "carrito_producto")
@Data
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
}
