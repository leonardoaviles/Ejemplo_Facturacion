package com.facturacion.facturacion.Model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
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
    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"}) 
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "fk_cliente")
    private ClientsModel clientsModel;

    @OneToOne(mappedBy = "facturaModel")
    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"}) 
    private DetalleFacturaModel detalleFacturaModel;

    public FacturaModel(){
        
    }

    public FacturaModel(long pkFactura, ClientsModel clientsModel) {
        this.pkFactura = pkFactura;
        this.clientsModel = clientsModel;
    }
    public long getPkFactura() {
        return pkFactura;
    }
    public void setPkFactura(long pkFactura) {
        this.pkFactura = pkFactura;
    }

    public ClientsModel getClientsModel() {
        return clientsModel;
    }
    public void setClientsModel(ClientsModel clientsModel) {
        this.clientsModel = clientsModel;
    }
}
