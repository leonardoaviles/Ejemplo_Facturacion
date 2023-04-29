package com.facturacion.facturacion.Controllers.apis;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;


import com.facturacion.facturacion.Model.ClientsModel;
import com.facturacion.facturacion.Repository.ClientRepository;
import com.facturacion.facturacion.Service.ClienteService;

@RestController
@RequestMapping("api/Clientes")
public class ClientsController {
    
    @Autowired
    ClienteService clienteService;

    @Autowired
    ClientRepository clientRepository;

    @GetMapping("/all")
    public @ResponseBody List<ClientsModel> listarClientes(){
        return clienteService.listarClientes();
    }

    @GetMapping("/{id}")
    public @ResponseBody ClientsModel listarClientePorID(@PathVariable @Valid int id){

        return clienteService.listarCliente(id);
    }

    @DeleteMapping("delete/{id}")
    public void EliminarClientePorID(@PathVariable @Valid int id){

        clienteService.eliminarCliente(id);
    }

    @ExceptionHandler(DataIntegrityViolationException.class)
    @PostMapping("/save")
    public @ResponseBody ResponseEntity<?> GuardarClientePorID(@RequestBody @Valid ClientsModel clientsModel){

        Optional<ClientsModel> clienteExistente = clientRepository.findByDni(clientsModel.getDni());

        if(clienteExistente.isPresent())
            return ResponseEntity.status(HttpStatus.CONFLICT).body("This client exist");
        else{
            clienteService.guardarCliente(clientsModel);
            return ResponseEntity.status(HttpStatus.CREATED).body("User created");
        }
    }



}
