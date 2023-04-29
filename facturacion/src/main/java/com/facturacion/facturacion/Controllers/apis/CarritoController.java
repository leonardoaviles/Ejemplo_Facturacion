package com.facturacion.facturacion.Controllers.apis;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.facturacion.facturacion.Model.CarritoModel;
import com.facturacion.facturacion.Model.CarritoProductoModel;
import com.facturacion.facturacion.Model.ClientsModel;
import com.facturacion.facturacion.Repository.CarritoProductoRepository;
import com.facturacion.facturacion.Repository.CarritoRepository;
import com.facturacion.facturacion.Repository.ClientRepository;
import com.facturacion.facturacion.Service.CarritoService;
import com.facturacion.facturacion.Service.ClienteService;

@RestController
@RequestMapping("api/carrito")
public class CarritoController {

    @Autowired
    CarritoService carritoService;

    @Autowired
    ClientRepository clientRepository;

    @Autowired
    ClienteService clienteService;

    @Autowired
    CarritoRepository carritoRepository;

    @Autowired
    CarritoProductoRepository carritoProductoRepository;

    @GetMapping("/all")
    public @ResponseBody List<CarritoModel> listarCarritos() {

        return carritoService.listarCarritos();
    }

    @GetMapping("/cliente/{id}")
    public @ResponseBody List<CarritoModel> listarCarritoPorCliente(@PathVariable @Valid int id){

        ClientsModel clientsModel = clientRepository.findById(id).get();

        return  carritoRepository.findByClientsModel(clientsModel).get();

    }

    @GetMapping("CPM/all")
    public @ResponseBody List<CarritoProductoModel> listarCarritos2() {

        return (List<CarritoProductoModel>) carritoProductoRepository.findAll();
    }

    @PostMapping("/save")
    public @ResponseBody ResponseEntity<?> guardarCarrito(@RequestBody @Valid CarritoModel carritoModel) {

        if(carritoService.guardarCarrito(carritoModel))
             return ResponseEntity.status(HttpStatus.CREATED).body("Carrito created");
        else
             return ResponseEntity.status(HttpStatus.CONFLICT).body("Can't create carrito");

    }

    @ExceptionHandler(DataIntegrityViolationException.class)
    @PutMapping("/{id}")
    public @ResponseBody ResponseEntity<?> updateCarritoPorId(@PathVariable @Valid int id, @RequestBody @Valid List<CarritoProductoModel> carritoProductoModel) {
        
        ClientsModel clientsModel = clientRepository.findById(id).get();

        List<CarritoModel> carritoModel = carritoRepository.findByClientsModel(clientsModel).get();
        CarritoModel carritoModel2 = new CarritoModel();

        for(CarritoModel carrito : carritoModel){

            if(carrito.getStatus()==true){
                carritoModel2 = carrito;
                break;
            }
    }

        if(carritoModel2.getStatus() == true)
        {
            carritoModel2.getCarritoProductoModel().addAll(carritoProductoModel);
            return ResponseEntity.status(HttpStatus.CREATED).body("Carrito updated");
            
        }
        else{
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("This carrito does not exist");
        }
    }

}
