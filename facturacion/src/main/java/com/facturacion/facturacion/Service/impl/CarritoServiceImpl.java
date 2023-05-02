package com.facturacion.facturacion.Service.impl;

import javax.persistence.Query;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.facturacion.facturacion.Model.CarritoModel;
import com.facturacion.facturacion.Model.CarritoProductoModel;
import com.facturacion.facturacion.Repository.CarritoProductoRepository;
import com.facturacion.facturacion.Repository.CarritoRepository;
import com.facturacion.facturacion.Service.CarritoService;

@Service
public class CarritoServiceImpl implements CarritoService{

    @Autowired
    CarritoRepository carritoRepository;

    @Autowired
    private EntityManager entityManager;

    @Autowired
    private CarritoProductoRepository carritoProductoRepository;

    @Override
    public void guardarCarrito(CarritoModel carritoModel, CarritoProductoModel carritoProductoModel) {

        carritoRepository.save(carritoModel);
        carritoProductoRepository.save(carritoProductoModel);

    }   
    @Override
    public void guardarCarrito(CarritoModel carritoModel) {

        carritoRepository.save(carritoModel);

    }
    @Override
    public List<CarritoModel> listarCarritos() {

        return (List<CarritoModel>) carritoRepository.findAll();
    }    
}
 