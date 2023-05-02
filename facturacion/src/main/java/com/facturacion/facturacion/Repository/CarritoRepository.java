package com.facturacion.facturacion.Repository;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.facturacion.facturacion.Model.CarritoModel;
import com.facturacion.facturacion.Model.ClientsModel;

@Repository
public interface CarritoRepository extends CrudRepository<CarritoModel,Integer>{

    public abstract Optional<CarritoModel> findByClientsModel(ClientsModel clientsModel);
    
}
