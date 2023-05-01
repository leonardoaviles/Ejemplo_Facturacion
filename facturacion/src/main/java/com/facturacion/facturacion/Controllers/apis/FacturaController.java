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

import com.facturacion.facturacion.Service.FacturaService;
import com.facturacion.facturacion.Model.FacturaModel;

@RestController
@RequestMapping("api/facturas")
public class FacturaController {
    
    @Autowired
    FacturaService facturaService;

    @GetMapping("/all")
    public @ResponseBody List<FacturaModel> listarClientes(){
        return facturaService.listarFacturas();
    }

    @GetMapping("/{id}")
    public @ResponseBody FacturaModel listarClientePorID(@PathVariable @Valid long id){

        return facturaService.listarFactura(id);
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
