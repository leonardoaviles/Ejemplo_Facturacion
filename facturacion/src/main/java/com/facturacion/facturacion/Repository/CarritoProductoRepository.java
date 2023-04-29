package com.facturacion.facturacion.Repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.facturacion.facturacion.Model.CarritoProductoModel;

@Repository
public interface CarritoProductoRepository extends CrudRepository<CarritoProductoModel, Integer>{
    
}

