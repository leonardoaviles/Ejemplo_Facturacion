package com.invoice.invoice.Model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.springframework.lang.NonNull;

import java.util.*;

@Entity
@Table(name = "client")
public class ClientModel implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "pk_client")

    private int pkClient;
    @NonNull
    @Column(name = "name_client")
    private String nameClient;
    @NonNull
    @Column(name = "last_name_client")
    private String lastNameClient;
    @NonNull
    @Column(name = "doc_number")
    private String docNumber;

    @OneToMany(mappedBy = "pk_invvamooice")
    private List<InvoiceModel> invoiceModel;

    public ClientModel() {
        invoiceModel = new ArrayList<InvoiceModel>();
    }

    public ClientModel(String nameClient, String lastNameClient, String docNumber) {
        this.nameClient = nameClient;
        this.lastNameClient = lastNameClient;
        this.docNumber = docNumber;
    }

    public int getPkClient() {
        return pkClient;
    }
    public void setPkClient(int pkClient) {
        this.pkClient = pkClient;
    }
    public String getNameClient() {
        return nameClient;
    }
    public void setNameClient(String nameClient) {
        this.nameClient = nameClient;
    }
    public String getLastNameClient() {
        return lastNameClient;
    }
    public void setLastNameClient(String lastNameClient) {
        this.lastNameClient = lastNameClient;
    }
    public String getDocNumber() {
        return docNumber;
    }
    public void setDocNumber(String docNumber) {
        this.docNumber = docNumber;
    }

    public List<InvoiceModel> getInvoiceModel() {
        return invoiceModel;
    }

    public void setInvoiceModel(List<InvoiceModel> invoiceModel) {
        this.invoiceModel = invoiceModel;
    }

}
