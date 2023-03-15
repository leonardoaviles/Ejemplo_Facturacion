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
import javax.persistence.Table;

import org.springframework.lang.NonNull;

@Entity
@Table(name = "factura")
public class FacturaModel implements Serializable{

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int pkFactura;
    @NonNull
    @Column(name = "dateFactura")
    private String dateFactura;
    @NonNull
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "pkClient")
    private ClientsModel clientsModel;
    @NonNull
    @ManyToMany(fetch = FetchType.LAZY)
    @JoinColumn(name = "pkProducto")
    private List<ProductsModel> productsModel;

    public FacturaModel(){
        
    }

    public FacturaModel(int pkFactura, String dateFactura, ClientsModel clientsModel, ProductsModel productsModel) {
        this.pkFactura = pkFactura;
        this.dateFactura = dateFactura;
        this.clientsModel = clientsModel;
        this.productsModel = new ArrayList<ProductsModel>();
    }
    public int getPkFactura() {
        return pkFactura;
    }
    public void setPkFactura(int pkFactura) {
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

    public List<ProductsModel> getProductsModel() {
        return productsModel;
    }
    public void setProductsModel(List<ProductsModel> productsModel) {
        this.productsModel = productsModel;
    }
    
}
