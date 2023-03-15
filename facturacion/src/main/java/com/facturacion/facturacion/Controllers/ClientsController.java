package com.facturacion.facturacion.Controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
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

}
