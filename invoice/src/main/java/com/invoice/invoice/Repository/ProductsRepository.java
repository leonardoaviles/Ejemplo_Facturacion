package com.invoice.invoice.Repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.invoice.invoice.Model.ProductsModel;

@Repository
public interface ProductsRepository extends CrudRepository<ProductsModel , Integer>{
    
}
