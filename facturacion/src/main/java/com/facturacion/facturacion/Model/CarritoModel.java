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
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "carrito")
public class CarritoModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name ="pk_carrito")
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    @JoinColumn(name = "fk_cliente")
    ClientsModel clientsModel;

    @Column(name="estatus")
    private boolean status;

    @OneToMany(mappedBy = "carritoModel", cascade = CascadeType.ALL)
    @JsonIgnore
    List<CarritoProductoModel> carritoProductoModel;


    public CarritoModel(){
        this.carritoProductoModel = new ArrayList<CarritoProductoModel>();

    }

    public CarritoModel(Long Id, ClientsModel clientsModel, boolean status) {
        this.id = id;
        this.clientsModel = clientsModel;
        this.status = status;
    }



    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public ClientsModel getClientsModel() {
        return clientsModel;
    }


    public void setClientsModel(ClientsModel clientsModel) {
        this.clientsModel = clientsModel;
    }   
    
    public boolean getStatus(){
        return status;
    }

    public void setStatus(boolean status){
        this.status = status;
    }

}
