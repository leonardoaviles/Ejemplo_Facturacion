package com.facturacion.facturacion.Service.impl;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import com.facturacion.facturacion.Model.DetalleFacturaModel;
import com.facturacion.facturacion.Repository.DetalleFacturaRepository;
import com.facturacion.facturacion.Service.DetalleFacturaService;

@Service
public class DetalleFacturaServiceImpl implements DetalleFacturaService {

    @Autowired
    DetalleFacturaRepository detalleFacturaRepository;

    @Override
    @Validated
    public DetalleFacturaModel listarDetalleFactura(@Valid long id) {
       
        return detalleFacturaRepository.findById(id).get();
    }

    @Override
    @Validated
    public List<DetalleFacturaModel> listarDetalleFacturas() {
        // TODO Auto-generated method stub
        return (List<DetalleFacturaModel>) detalleFacturaRepository.findAll();
    }
}
