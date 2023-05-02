package com.facturacion.facturacion.Controllers.apis;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.facturacion.facturacion.Model.CarritoModel;
import com.facturacion.facturacion.Model.CarritoProductoModel;
import com.facturacion.facturacion.Model.ClientsModel;
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

    @GetMapping("/all")
    public @ResponseBody List<CarritoModel> listarCarritos(){

        return carritoService.listarCarritos();
    }

    @PostMapping("/{id}")
    public void crearCarritoPorId(@PathVariable int id) {

        ClientsModel clientsModel = clientRepository.findById(id).get();

        Optional<CarritoModel> optional = carritoRepository.findByClientsModel(clientsModel);

        if (!optional.isPresent() || optional.get().getStatus() == false) {

            CarritoModel carritoModel = new CarritoModel();
            carritoModel.setStatus(true);
            carritoModel.setClientsModel(clientsModel);
            

            carritoService.guardarCarrito(carritoModel);
        }
    }
}
