package com.facturacion.facturacion.Controllers.apis;

import java.util.List;


import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.facturacion.facturacion.Service.ClienteService;
import com.facturacion.facturacion.Service.FacturaService;
import com.facturacion.facturacion.Model.CarritoModel;
import com.facturacion.facturacion.Model.ClientsModel;
import com.facturacion.facturacion.Model.FacturaModel;
import com.facturacion.facturacion.Repository.CarritoRepository;
import com.facturacion.facturacion.Repository.ClientRepository;
import com.facturacion.facturacion.Repository.FacturaRepository;

@RestController
@RequestMapping("api/facturas")
public class FacturaController {
    
    @Autowired
    FacturaService facturaService;

    @Autowired
    ClientRepository clientRepository;

    @Autowired
    FacturaRepository facturaRepository;

    @GetMapping("/all")
    public @ResponseBody List<FacturaModel> listarFacturas(){
        
        List<FacturaModel> facturaModel = facturaService.listarFacturas();

        for(int i= 0; i< facturaModel.size(); i++){

            if(facturaModel.get(i).getClientsModel() == null)
                facturaModel.remove(i);
        }

        return facturaService.listarFacturas();
    }

    @GetMapping("/{id}")
    public @ResponseBody List<FacturaModel> listarFacturaPorID(@PathVariable @Valid int id){

        ClientsModel clientsModel  = clientRepository.findById(id).get();
        return facturaRepository.findByclientsModel(clientsModel);
    }

    @DeleteMapping("delete/{id}")
    public void EliminarFacturaPorID(@PathVariable @Valid long id){

        facturaService.eliminarFactura(id);
    }

    @PostMapping("/save")
    public void GuardarFacturaPorID(@RequestBody @Valid FacturaModel facturaModel){

        facturaService.guardarFactura(facturaModel);
    }


}
