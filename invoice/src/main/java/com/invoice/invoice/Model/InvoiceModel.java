package com.invoice.invoice.Model;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.List;

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

import org.hibernate.annotations.GeneratorType;
import org.hibernate.annotations.ManyToAny;
import org.springframework.lang.NonNull;

import java.io.Serializable;

@Entity
@Table(name = "invoice")
public class InvoiceModel implements Serializable{

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "pk_invoice")
    private int pkInvoice;

    @NonNull
    @Column(name = "date_time")
    
    private LocalDateTime dateTime;
    @Column(name = "total")
    
    private double total;
    
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "pk_client")
    private ClientModel fkClient;

    @OneToMany(mappedBy = "invoice")
    private List<InvoiceDetailModel> invoiceDetailModel;

    public InvoiceModel(LocalDateTime dateTime, double total, ClientModel fkClient) {
        this.dateTime = dateTime;
        this.total = total;
        this.fkClient = fkClient;
    }

    public InvoiceModel() {
        
    }

    public int getPkInvoice() {
        return pkInvoice;
    }

    public void setPkInvoice(int pkInvoice) {
        this.pkInvoice = pkInvoice;
    }

    public LocalDateTime getDateTime() {
        return dateTime;
    }

    public void setDateTime(LocalDateTime dateTime) {
        this.dateTime = dateTime;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public ClientModel getFkClient() {
        return fkClient;
    }

    public void setFkClient(ClientModel fkClient) {
        this.fkClient = fkClient;
    }

    public List<InvoiceDetailModel> getInvoiceDetailModel() {
        return invoiceDetailModel;
    }

    public void setInvoiceDetailModel(List<InvoiceDetailModel> invoiceDetailModel) {
        this.invoiceDetailModel = invoiceDetailModel;
    }


    
}
