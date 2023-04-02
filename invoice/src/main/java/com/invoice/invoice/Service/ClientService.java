package com.invoice.invoice.Service;

import java.util.List;

import com.invoice.invoice.Model.ClientModel;

public interface ClientService {

    public List<ClientModel> listClients();
    public ClientModel listClientById(int id);
    public void deleteClient(int id);
    public void saveClient(ClientModel clientModel);

}
