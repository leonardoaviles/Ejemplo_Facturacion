package com.facturacion.facturacion.Controllers.front;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.facturacion.facturacion.Model.CarritoModel;
import com.facturacion.facturacion.Model.CarritoProductoModel;
import com.facturacion.facturacion.Model.ClientsModel;
import com.facturacion.facturacion.Repository.CarritoRepository;
import com.facturacion.facturacion.Repository.ClientRepository;
import com.facturacion.facturacion.Service.CarritoService;
import com.facturacion.facturacion.Service.ClienteService;

@Controller
@RequestMapping("/carrito")
public class CarritoFrontController {

    @Autowired
    CarritoService carritoService;

    @Autowired
    ClientRepository clientRepository;

    @Autowired
    ClienteService clienteService;

    @Autowired
    CarritoRepository carritoRepository;

    @PostMapping("/save")
    public String guardarCarrito(@ModelAttribute("carrito") CarritoModel carritoModel,
            @ModelAttribute("carritoProducto") CarritoProductoModel carritoProductoModel) {

        carritoService.guardarCarrito(carritoModel);

        return "cliente";
    }

    @GetMapping("/{id}")
    public String crearCarritoPorId(@PathVariable int id, Model model) {

        ClientsModel clientsModel = clientRepository.findById(id).get();

        Optional<List<CarritoModel>> optional = carritoRepository.findByClientsModel(clientsModel);

        ClientsModel cliente = clienteService.listarCliente(id);
        model.addAttribute("clientes", cliente);

        return "cliente";
    }

}
