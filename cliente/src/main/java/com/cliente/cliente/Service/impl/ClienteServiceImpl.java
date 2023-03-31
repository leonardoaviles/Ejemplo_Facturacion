package com.cliente.cliente.Service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cliente.cliente.Model.ClienteModel;
import com.cliente.cliente.Repository.ClienteRepository;
import com.cliente.cliente.Service.ClienteService;

@Service
public class ClienteServiceImpl implements  ClienteService{
   
    @Autowired
    ClienteRepository clienteRepository;

    ClienteModel clienteModel;

    @Override
    public ClienteModel listClientByAge(int id) {
         
        int edad = 0;

        clienteModel = clienteRepository.findById(id).get();
        edad = 2023 - Integer.valueOf(clienteModel.getAnios());

        clienteModel.setAnios(String.valueOf(edad));

        return clienteModel;
    
    }


    
}