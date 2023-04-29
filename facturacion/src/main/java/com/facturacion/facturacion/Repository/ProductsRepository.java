package com.facturacion.facturacion.Repository;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.facturacion.facturacion.Model.ProductsModel;

@Repository
public interface ProductsRepository extends CrudRepository<ProductsModel,Integer>{

    public abstract Optional<ProductsModel> findByCodigo(String codigo);
    
}

