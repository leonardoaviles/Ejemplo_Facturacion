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

import org.springframework.lang.NonNull;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.util.List;
import java.util.ArrayList;

@Entity
@Table(name = "clients")
public class ClientsModel implements Serializable{

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name= "pk_client")
    private int pkClient;
    @NonNull
    @Column(name = "nombre")
    private String name;
    @NonNull
    @Column(name = "apellido")
    private String lastName;
    @NonNull
    @Column(name = "dni")
    private String dni;
    @NonNull
    @Column(name = "direccion")
    private String adress;
    @NonNull
    @Column(name = "telefono")
    private String phone;
    @NonNull
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
        this.facturas = new ArrayList<FacturaModel>();
    }

    public int getPkClient() {
        return pkClient;
    }
    public void setPkClient(int pkclient) {
        this.pkClient = pkclient;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getLastName() {
        return lastName;
    }
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getDni() {
        return dni;
    }
    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getAdress() {
        return adress;
    }
    public void setAdress(String adress) {
        this.adress = adress;
    }
    public String getPhone() {
        return phone;
    }
    public void setPhone(String phone) {
        this.phone = phone;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public List<FacturaModel> getFacturas() {
        return facturas;
    }

    public void setFacturas(List<FacturaModel> facturas) {
        this.facturas = facturas;
    }
}


