package com.facturacion.facturacion.Repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.facturacion.facturacion.Model.ClientsModel;
import com.facturacion.facturacion.Model.FacturaModel;

import java.util.List;
import java.util.Optional;

@Repository
public interface FacturaRepository extends CrudRepository<FacturaModel,Long>{

    public abstract List<FacturaModel> findByclientsModel(ClientsModel clientsModel);
    
}
