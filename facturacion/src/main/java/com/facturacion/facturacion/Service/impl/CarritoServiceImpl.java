package com.facturacion.facturacion.Service.impl;

import javax.persistence.Query;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.facturacion.facturacion.Model.CarritoModel;
import com.facturacion.facturacion.Model.CarritoProductoModel;
import com.facturacion.facturacion.Repository.CarritoRepository;
import com.facturacion.facturacion.Service.CarritoService;

@Service
public class CarritoServiceImpl implements CarritoService{

    @Autowired
    CarritoRepository carritoRepository;

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public void guardarCarrito(CarritoModel carritoModel, CarritoProductoModel carritoProductoModel) {

        carritoRepository.save(carritoModel);

        Long pk_carrito = carritoModel.getId();

        String sql = "INSERT INTO carrito_producto (pk_carrito, pk_producto, cantidad) values (:pk_carrito, :pk_producto, :cantidad)";

        Query query = entityManager.createQuery(sql);
        query.setParameter("pk_carrito", pk_carrito);
        query.setParameter("pk_producto", carritoProductoModel.getProductoModel().getPkProducto());
        query.setParameter(":cantidad", carritoProductoModel.getCantidad());
        query.executeUpdate();

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
 