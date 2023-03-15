package com.facturacion.facturacion.Service;

import com.facturacion.facturacion.Model.ClientsModel;
import java.util.List;

public interface ClienteService {
    
    public ClientsModel listarCliente(int id);
    public List<ClientsModel> listarClientes();
    public void eliminarCliente(int id);
    public void guardarCliente(ClientsModel clientsModel);

}
