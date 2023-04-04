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

import org.springframework.lang.NonNull;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "factura")
public class FacturaModel implements Serializable{

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "pk_factura")
    private long pkFactura;
    @NonNull
    @Column(name = "date_factura")
    private String dateFactura;
    @NonNull
    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"}) 
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "fk_cliente")
    private ClientsModel clientsModel;
    @NonNull
    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"}) 
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "fk_producto")
    private ProductsModel productsModel;

    public FacturaModel(){
        
    }

    public FacturaModel(long pkFactura, String dateFactura, ClientsModel clientsModel, ProductsModel productsModel) {
        this.pkFactura = pkFactura;
        this.dateFactura = dateFactura;
        this.clientsModel = clientsModel;
        this.productsModel = productsModel;
    }
    public long getPkFactura() {
        return pkFactura;
    }
    public void setPkFactura(long pkFactura) {
        this.pkFactura = pkFactura;
    }
    public String getDateFactura() {
        return dateFactura;
    }
    public void setDateFactura(String dateFactura) {
        this.dateFactura = dateFactura;
    }
    public ClientsModel getClientsModel() {
        return clientsModel;
    }
    public void setClientsModel(ClientsModel clientsModel) {
        this.clientsModel = clientsModel;
    }

    public ProductsModel getProductsModel() {
        return productsModel;
    }
    public void setProductsModel(ProductsModel productsModel) {
        this.productsModel = productsModel;
    }
    
}
