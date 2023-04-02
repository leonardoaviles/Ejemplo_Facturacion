package com.invoice.invoice.Model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "invoice_details")
public class InvoiceDetailModel {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "pk_invoice_detail")
    private int pkInvoiceDetail;

    @Column(name = "amount")
    private int amount;

    private double price;
    
    @ManyToOne
    @JoinColumn(name = "pk_invoice")
    private InvoiceModel pkInvoiceModel;

    @ManyToOne
    @JoinColumn(name = "pk_products")
    private ProductsModel pkProductsModel;

    public InvoiceDetailModel(int amount, double price, InvoiceModel pkInvoiceModel, ProductsModel pkProductsModel) {
        this.amount = amount;
        this.price = price;
        this.pkInvoiceModel = pkInvoiceModel;
        this.pkProductsModel = pkProductsModel;
    }

    public InvoiceDetailModel() {
    }

    public int getPkInvoiceDetail() {
        return pkInvoiceDetail;
    }

    public void setPkInvoiceDetail(int pkInvoiceDetail) {
        this.pkInvoiceDetail = pkInvoiceDetail;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public InvoiceModel getPkInvoiceModel() {
        return pkInvoiceModel;
    }

    public void setPkInvoiceModel(InvoiceModel pkInvoiceModel) {
        this.pkInvoiceModel = pkInvoiceModel;
    }

    public ProductsModel getPkProductsModel() {
        return pkProductsModel;
    }

    public void setPkProductsModel(ProductsModel pkProductsModel) {
        this.pkProductsModel = pkProductsModel;
    }

    

}


