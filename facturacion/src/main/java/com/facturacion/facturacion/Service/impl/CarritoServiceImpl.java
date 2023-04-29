package com.facturacion.facturacion.Service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.facturacion.facturacion.Model.CarritoModel;
import com.facturacion.facturacion.Repository.CarritoRepository;
import com.facturacion.facturacion.Service.CarritoService;

@Service
public class CarritoServiceImpl implements CarritoService {

    @Autowired
    CarritoRepository carritoRepository;

    @Override
    public boolean guardarCarrito(CarritoModel carritoModel) {

        try {
            carritoRepository.save(carritoModel);
        } catch (Exception e) {
            throw new RuntimeException("Error al guardar Carrito");

        }

        if (carritoRepository.findByClientsModel(carritoModel.getClientsModel()) != null)
            return true;

        else
            return false;
    }

    @Override
    public List<CarritoModel> listarCarritos() {
        try {
            return (List<CarritoModel>) carritoRepository.findAll();
        } catch (Exception e) {
            throw new RuntimeException("Error al listar Carritos");

        }
    }
}
