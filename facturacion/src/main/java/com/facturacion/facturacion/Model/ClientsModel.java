package com.facturacion.facturacion.Model;

import java.io.Serializable;

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

import java.util.List;
import java.util.ArrayList;

@Entity
@Table(name = "clients")
@Data
@JsonIgnoreProperties({"hibernateLazyInitializer"})
public class ClientsModel implements Serializable{

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name= "pk_client")
    private int pkClient;

    @Column(name = "nombre")
    private String name;

    @Column(name = "apellido")
    private String lastName;

    @Column(name = "dni")
    private String dni;

    @Column(name = "direccion")
    private String adress;

    @Column(name = "telefono")
    private String phone;

    @Column(name = "correo")
    private String email;

    @JsonIgnore
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "clientsModel" , cascade = CascadeType.ALL)
    private List <FacturaModel> facturas;

    @JsonIgnore
    @OneToMany(mappedBy = "clientsModel", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<CarritoModel> carritoModel = new ArrayList<>();
    

    public ClientsModel(){
        this.facturas = new ArrayList<FacturaModel>();
        this.carritoModel =  new ArrayList<CarritoModel>();
    }

    public ClientsModel(int pkclient, String name, String lastName, String dni,String adress, String phone, String email) {
        this.pkClient = pkclient;
        this.name = name;
        this.lastName = lastName;
        this.dni =dni;
        this.adress = adress;
        this.phone = phone;
        this.email = email;
    }
}


