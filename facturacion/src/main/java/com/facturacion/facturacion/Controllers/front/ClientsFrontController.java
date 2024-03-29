package com.facturacion.facturacion.Controllers.front;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.facturacion.facturacion.Model.ClientsModel;
import com.facturacion.facturacion.Repository.ClientRepository;
import com.facturacion.facturacion.Service.ClienteService;
import com.facturacion.facturacion.Service.ProductsService;

@Controller
@RequestMapping("/Clientes")
public class ClientsFrontController {
    
    @Autowired
    ClienteService clienteService;

    @Autowired
    ClientRepository clientRepository;

    @Autowired
    ProductsService productsService;

    @GetMapping("/all")
    public String listarClientes(Model model){

        List<ClientsModel> clientes = clienteService.listarClientes();
        model.addAttribute("clientes", clientes);
        return "clientes";
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
