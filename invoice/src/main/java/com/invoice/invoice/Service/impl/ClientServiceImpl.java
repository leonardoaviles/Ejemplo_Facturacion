package com.invoice.invoice.Service.impl;

import java.util.List;

import javax.websocket.ClientEndpoint;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.invoice.invoice.Model.ClientModel;
import com.invoice.invoice.Repository.ClientRepository;
import com.invoice.invoice.Service.ClientService;

@Service
public class ClientServiceImpl implements ClientService{

    @Autowired
    ClientRepository clientRepository;

    @Override
    public List<ClientModel> listClients() {
       
        return (List<ClientModel>) clientRepository.findAll();
    }

    @Override
    public ClientModel listClientById(int id) {
        return clientRepository.findById(id).get();
    }

    @Override
    public void deleteClient(int id) {
        
        clientRepository.deleteById(id);
    }

    @Override
    public void saveClient(ClientModel clientModel) {
            
        clientRepository.save(clientModel);
        
    }
    
}
