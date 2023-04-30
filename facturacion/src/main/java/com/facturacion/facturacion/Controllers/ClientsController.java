package com.facturacion.facturacion.Controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.facturacion.facturacion.Model.ClientsModel;
import com.facturacion.facturacion.Service.ClienteService;

@RestController
@RequestMapping("/Clientes")
public class ClientsController {
    
    @Autowired
    ClienteService clienteService;

    @GetMapping("/all")
    public @ResponseBody List<ClientsModel> listarClientes(){
        return clienteService.listarClientes();
    }

    @GetMapping("/{id}")
    public @ResponseBody ClientsModel listarClientePorID(@PathVariable @Valid int id){

        return clienteService.listarCliente(id);
    }

    @DeleteMapping("delete/{id}")
    public void EliminarClientePorID(@PathVariable int id){

        clienteService.eliminarCliente(id);
    }

    @PostMapping("/save")
    public void GuardarClientePorID(ClientsModel clientsModel){

        clienteService.guardarCliente(clientsModel);
    }



}
