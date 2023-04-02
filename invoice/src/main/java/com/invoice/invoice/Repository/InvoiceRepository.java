package com.invoice.invoice.Repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.invoice.invoice.Model.InvoiceModel;

@Repository
public interface InvoiceRepository extends CrudRepository<InvoiceModel,Integer>{
    
}
