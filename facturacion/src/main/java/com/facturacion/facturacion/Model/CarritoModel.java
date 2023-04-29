package com.facturacion.facturacion.Model;

import java.util.ArrayList;
import java.util.List;

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

import lombok.Data;

@Entity
@Table(name = "carrito")
@Data
public class CarritoModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name ="pk_carrito")
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    @JoinColumn(name = "fk_cliente")
    private ClientsModel clientsModel;

    @OneToMany(mappedBy = "carritoModel", cascade = CascadeType.ALL)
    @JsonIgnore
    private List<CarritoProductoModel> carritoProductoModel;

    @OneToOne(mappedBy = "carritoModel")
    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"}) 
    private FacturaModel facturaModel;

    @Column(name="estatus")
    private Boolean status;

    public CarritoModel(){
        this.carritoProductoModel = new ArrayList<CarritoProductoModel>();
        this.facturaModel = new FacturaModel();
    }

    public CarritoModel(Long id, ClientsModel clientsModel, boolean status) {
        this.id = id;
        this.clientsModel = clientsModel;
        this.status = status;
    }

}
