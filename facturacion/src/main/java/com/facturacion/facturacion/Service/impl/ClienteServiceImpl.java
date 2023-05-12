package com.facturacion.facturacion.Service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.facturacion.facturacion.Model.ClientsModel;
import com.facturacion.facturacion.Repository.ClientRepository;
import com.facturacion.facturacion.Service.ClienteService;

@Service
public class ClienteServiceImpl implements ClienteService {

    @Autowired
    private ClientRepository clientRepository;

    @Override
    @Transactional(readOnly = true)
    public ClientsModel listarCliente(int id) {
        try {
            return clientRepository.findById(id).get();
        } catch (Exception e) {
            throw new RuntimeException("Error al listar Cliente");

        }
    }

    @Override
    public List<ClientsModel> listarClientes() {

        try {
            return (List<ClientsModel>) clientRepository.findAll();

        } catch (Exception e) {
            throw new RuntimeException("Error al listar Clientes");

        }
    }

    @Override
    public void eliminarCliente(int id) {

            try {
                clientRepository.deleteById(id);

            } catch (Exception e) {
                throw new RuntimeException("Error al eliminar Cliente");

            }

    }

    @Override
    public boolean guardarCliente(ClientsModel clientsModel) {

        try {
            clientRepository.save(clientsModel);
        } catch (Exception e) {
            throw new RuntimeException("Error al guardar Cliente");

        }

        if (clientRepository.findByDni(clientsModel.getDni()).get() != null)
            return true;
        else
            return false;
    }

}
