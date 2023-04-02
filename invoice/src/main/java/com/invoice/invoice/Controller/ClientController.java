package com.invoice.invoice.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.invoice.invoice.Model.ClientModel;
import com.invoice.invoice.Service.ClientService;

@RestController
@RequestMapping("/client")
public class ClientController {

    @Autowired
    ClientService clientService;

    @GetMapping("/{id}")
    public @ResponseBody ClientModel listClientModel(@PathVariable int id){
        return clientService.listClientById(id);

    }

    @GetMapping("/all")
    public @ResponseBody List<ClientModel> listClients(){
        return clientService.listClients();

    }

    @GetMapping("/delete/{id}")
    public void deleteClient(@PathVariable int id){
        
        clientService.deleteClient(id);

    }

    @GetMapping("/guardar")
    public void saveClient(ClientModel clientModel){
        clientService.saveClient(clientModel);

    }



    
}
