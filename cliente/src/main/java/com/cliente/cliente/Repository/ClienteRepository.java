package com.cliente.cliente.Repository;

import org.springframework.stereotype.Repository;
import com.cliente.cliente.Model.ClienteModel;
import org.springframework.data.repository.CrudRepository;

@Repository
public interface ClienteRepository extends CrudRepository<ClienteModel, Integer>{
    
}
