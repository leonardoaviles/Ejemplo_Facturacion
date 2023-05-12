package com.facturacion.facturacion.Model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.Data;

@Entity
@Table(name = "detalle_factura")
@Data
public class DetalleFacturaModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "pk_detalle_factura")
    private long pkDetalleFactura;

    @JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "fk_factura")
    private FacturaModel facturaModel;

    @JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "fk_producto")
    private ProductsModel productsModel;

    @Column(name = "cantidad")
    private int cantidad;

    @Column(name="precio_venta")
    private double precioVenta;

    @Column(name="total")
    private double total;

    public DetalleFacturaModel() {

    }

    public DetalleFacturaModel(long pkDetalleFactura, FacturaModel facturaModel, ProductsModel productsModel, int cantidad, double precioVenta,  double total) {
        this.pkDetalleFactura = pkDetalleFactura;
        this.facturaModel = facturaModel;
        this.productsModel = productsModel;
        this.cantidad = cantidad;
        this.precioVenta = precioVenta;
        this.total = total;
       
    }
}
