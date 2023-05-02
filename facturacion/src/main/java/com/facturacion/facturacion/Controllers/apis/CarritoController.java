package com.facturacion.facturacion.Controllers.apis;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
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

    @GetMapping("CPM/all")
    public @ResponseBody List<CarritoProductoModel> listarCarritos2() {

        return (List<CarritoProductoModel>) carritoProductoRepository.findAll();
    }

    @PostMapping("/save")
    public void crearCarritoPorId(@RequestBody CarritoProductoModel carritoProductoModel) {

        ClientsModel clientsModel = carritoProductoModel.getCarritoModel().getClientsModel();
        CarritoModel carritoModel = new CarritoModel();

        carritoModel.setClientsModel(clientsModel);
        carritoService.guardarCarrito(carritoModel, carritoProductoModel);
    }

}
