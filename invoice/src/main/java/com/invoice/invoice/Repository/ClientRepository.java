package com.invoice.invoice.Repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.invoice.invoice.Model.ClientModel;

@Repository
public interface ClientRepository extends CrudRepository<ClientModel , Integer>{
    
}
