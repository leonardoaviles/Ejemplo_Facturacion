package com.facturacion.facturacion.Service.impl;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import com.facturacion.facturacion.Model.ProductsModel;
import com.facturacion.facturacion.Repository.ProductsRepository;
import com.facturacion.facturacion.Service.ProductsService;

@Service
public class ProductsServiceImpl implements ProductsService{


    @Autowired
    ProductsRepository productsRepository;

    @Override
    @Transactional(readOnly = true)
    public ProductsModel listarProducto(int id) {

        return productsRepository.findById(id).get();
       
    }

    @Override
    public List<ProductsModel> listarProductos() {
        
        return (List<ProductsModel>) productsRepository.findAll();
    }

    @Override
    public void eliminarProducto(int id) {
        
        productsRepository.deleteById(id);
    }

    @Override
    public void guardarProducto(ProductsModel ProductsModel) {
        
        productsRepository.save(ProductsModel);

    }
    
}
