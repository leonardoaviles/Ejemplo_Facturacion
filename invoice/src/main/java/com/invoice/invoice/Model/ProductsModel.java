package com.invoice.invoice.Model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.springframework.lang.NonNull;

import net.bytebuddy.dynamic.loading.ClassReloadingStrategy.Strategy;

@Entity
@Table(name= "products")
public class ProductsModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "pk_product")
    private int pkProduct;
    
    @NonNull
    @Column(name ="description")
    private String description;
    
    @NonNull
    @Column(name = "code")
    private String code;
    
    @Column(name = "stock")
    private int stock;

    @Column(name = "price")
    private double price;

    @OneToMany(mappedBy = "products")
    private List<InvoiceDetailModel> invoiceDetailModel; 

    


    public ProductsModel(String description, String code, int stock, double price) {
        this.description = description;
        this.code = code;
        this.stock = stock;
        this.price = price;
    }

    public ProductsModel() {
        invoiceDetailModel = new ArrayList<InvoiceDetailModel>();
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public List<InvoiceDetailModel> getInvoiceDetailModel() {
        return invoiceDetailModel;
    }

    public void setInvoiceDetailModel(List<InvoiceDetailModel> invoiceDetailModel) {
        this.invoiceDetailModel = invoiceDetailModel;
    }

    
    
}
