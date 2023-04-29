package com.facturacion.facturacion.Model;

import java.io.Serializable;

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
@Table(name = "factura")
@Data
public class FacturaModel implements Serializable{

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "pk_factura")
    private long pkFactura;

    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"}) 
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "fk_cliente")
    private ClientsModel clientsModel;

    @OneToOne
    @JoinColumn(name = "fk_carrito")
    private CarritoModel carritoModel;

    @Column(name = "date_factura")
    private String dateFactura;

    @OneToOne(mappedBy = "facturaModel")
    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"}) 
    private DetalleFacturaModel detalleFacturaModel;

    public FacturaModel(){
        this.detalleFacturaModel = new DetalleFacturaModel();
        
    }

    public FacturaModel(long pkFactura, ClientsModel clientsModel, CarritoModel carritoModel, String dateFactura) {
        this.pkFactura = pkFactura;
        this.clientsModel = clientsModel;
        this.carritoModel = carritoModel;
        this.dateFactura = dateFactura;
    }
}
