package com.facturacion.facturacion.Controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.facturacion.facturacion.Service.FacturaService;
import com.facturacion.facturacion.Model.FacturaModel;

@RestController
@RequestMapping("/facturas")
public class FacturaController {
    
    @Autowired
    FacturaService facturaService;

    @GetMapping("/all")
    public @ResponseBody List<FacturaModel> listarClientes(){
        return facturaService.listarFacturas();
    }

    @GetMapping("/{id}")
    public @ResponseBody FacturaModel listarClientePorID(@PathVariable long id){

        return facturaService.listarFactura(id);
    }

    @DeleteMapping("delete/{id}")
    public void EliminarClientePorID(@PathVariable long id){

        facturaService.eliminarFactura(id);
    }

    @PostMapping("/save")
    public void GuardarClientePorID(FacturaModel FacturaModel){

        facturaService.guardarFactura(FacturaModel);
    }


}
