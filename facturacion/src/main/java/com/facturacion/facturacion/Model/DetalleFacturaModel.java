package com.facturacion.facturacion.Model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.websocket.ClientEndpoint;

import org.springframework.lang.NonNull;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "detalle_factura")
public class DetalleFacturaModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "pk_detalle_factura")
    private long pkDetalleFactura;

    @NonNull
    @Column(name = "date_factura")
    private String dateFactura;

    @NonNull
    @JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "fk_factura")
    private FacturaModel facturaModel;

    @Column(name="precio_venta")
    private double precioVenta;

    @Column(name="total")
    private double total;

    public DetalleFacturaModel() {

    }

    public DetalleFacturaModel(long pkDetalleFactura, String dateFactura, FacturaModel facturaModel, double total) {
        this.pkDetalleFactura = pkDetalleFactura;
        this.dateFactura = dateFactura;
        this.facturaModel = facturaModel;
        this.total = total;
    }

    public long getPkDetalleFactura() {
        return pkDetalleFactura;
    }

    public void setPkDetalleFactura(long pkDetalleFactura) {
        this.pkDetalleFactura = pkDetalleFactura;
    }

    public String getDateFactura() {
        return dateFactura;
    }

    public void setDateFactura(String dateFactura) {
        this.dateFactura = dateFactura;
    }

    public FacturaModel getFacturaModel() {
        return facturaModel;
    }

    public void setFacturaModel(FacturaModel facturaModel) {
        this.facturaModel = facturaModel;
    }

    public double getPrecioVenta() {
        return precioVenta;
    }

    public void setPrecioVenta(double precioVenta) {
        this.precioVenta = precioVenta;
    }


    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    

  

}
