package com.facturacion.facturacion.Repository;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.facturacion.facturacion.Model.ClientsModel;

@Repository
public interface ClientRepository  extends CrudRepository<ClientsModel,Integer>{

    public abstract Optional<ClientsModel> findByDni(String dni);
    
}

