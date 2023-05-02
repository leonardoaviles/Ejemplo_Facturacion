package com.facturacion.facturacion.Controllers.front;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.facturacion.facturacion.Service.FacturaService;
import com.facturacion.facturacion.Model.ClientsModel;
import com.facturacion.facturacion.Model.FacturaModel;
import com.facturacion.facturacion.Repository.ClientRepository;
import com.facturacion.facturacion.Repository.FacturaRepository;

@Controller
@RequestMapping("/facturas")
public class FacturaFrontController {
    
    @Autowired
    FacturaService facturaService;

    @Autowired
    FacturaRepository facturaRepository;

    @Autowired
    ClientRepository clientRepository;


    @GetMapping
    public String listarFacturas(Model model){
        List<FacturaModel> factura = facturaService.listarFacturas();
        model.addAttribute("facturas", factura);

        return "facturas";
    }

    @GetMapping("/cliente/{id}")
    public String listarFacturas(@PathVariable int id, Model model){

       ClientsModel clientsModel = clientRepository.findById(id).get();

        List<FacturaModel> factura = facturaRepository.findByclientsModel(clientsModel);
        model.addAttribute("facturas", factura);

        return "facturas";
    }

    @DeleteMapping("delete/{id}")
    public void EliminarClientePorID(@PathVariable @Valid long id){

        facturaService.eliminarFactura(id);
    }

    @PostMapping("/save")
    public void GuardarClientePorID(@RequestBody @Valid FacturaModel FacturaModel){

        facturaService.guardarFactura(FacturaModel);
    }

}
