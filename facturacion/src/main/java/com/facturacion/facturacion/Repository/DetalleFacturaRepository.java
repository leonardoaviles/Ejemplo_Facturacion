package com.facturacion.facturacion.Repository;

import org.springframework.data.repository.CrudRepository;

import com.facturacion.facturacion.Model.DetalleFacturaModel;

public interface DetalleFacturaRepository extends CrudRepository<DetalleFacturaModel,Long>{
    
}

