package com.facturacion.facturacion.Service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.facturacion.facturacion.Model.FacturaModel;
import com.facturacion.facturacion.Repository.FacturaRepository;
import com.facturacion.facturacion.Service.FacturaService;

@Service
public class FacturaServiceImpl implements FacturaService{

    @Autowired
    FacturaRepository facturaRepository;  

    @Override
    public FacturaModel listarFactura(long id) {
       return facturaRepository.findById(id).get();
    }

    @Override
    public List<FacturaModel> listarFacturas() {

        return (List<FacturaModel>) facturaRepository.findAll();
    }

    @Override
    public void eliminarFactura(long id) {

        facturaRepository.deleteById(id);
    }

    @Override
    public void guardarFactura(FacturaModel facturaModel) {
        facturaRepository.save(facturaModel);
        
    }
    
}
