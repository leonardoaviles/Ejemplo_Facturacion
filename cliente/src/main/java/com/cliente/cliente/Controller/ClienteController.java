package com.cliente.cliente.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.cliente.cliente.Model.ClienteModel;
import com.cliente.cliente.Service.ClienteService;

@RestController
@RequestMapping("/client")
public class ClienteController {

    @Autowired
    ClienteService clienteService;

    @GetMapping("/{id}")
    public @ResponseBody ClienteModel listarCliente(@PathVariable int id){

        System.out.println(clienteService.listClientByAge(id));
        return  clienteService.listClientByAge(id);


    }

    

}
