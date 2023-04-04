package com.facturacion.facturacion.Repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.facturacion.facturacion.Model.FacturaModel;

@Repository
public interface FacturaRepository extends CrudRepository<FacturaModel,Long>{
    
}
