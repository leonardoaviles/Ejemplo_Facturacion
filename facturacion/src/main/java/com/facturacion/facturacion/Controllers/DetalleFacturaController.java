package com.facturacion.facturacion.Controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.facturacion.facturacion.Service.DetalleFacturaService;
import com.facturacion.facturacion.Model.DetalleFacturaModel;


@RestController
@RequestMapping("/detalleFactura")
public class DetalleFacturaController {

    @Autowired
    DetalleFacturaService detalleFacturaService;

    @GetMapping("/all")
    public @ResponseBody List<DetalleFacturaModel> listarDetallesFacturas(){
        return detalleFacturaService.listarDetalleFacturas();
    }

    @GetMapping("/{id}")
    public @ResponseBody DetalleFacturaModel listarDetalleFacturaPorID(@PathVariable  @Valid long id){

        return detalleFacturaService.listarDetalleFactura(id);
    }    
}
