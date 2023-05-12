package com.facturacion.facturacion.Service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.facturacion.facturacion.Model.ProductsModel;
import com.facturacion.facturacion.Repository.ProductsRepository;
import com.facturacion.facturacion.Service.ProductsService;

@Service
public class ProductsServiceImpl implements ProductsService {

    @Autowired
    ProductsRepository productsRepository;

    @Override
    @Transactional(readOnly = true)
    public ProductsModel listarProducto(int id) {

        try {
            return productsRepository.findById(id).get();
        } catch (Exception e) {
            throw new RuntimeException("Error al listar producto, no existe");

        }

    }

    @Override
    public List<ProductsModel> listarProductos() {

        try {

            return (List<ProductsModel>) productsRepository.findAll();
        } catch (Exception e) {
            throw new RuntimeException("Error al listar productos, no existen");

        }
    }

    @Override
    public void eliminarProducto(int id) {

        if (productsRepository.existsById(id)) {
            try {
                productsRepository.deleteById(id);
            } catch (Exception e) {
                throw new RuntimeException("Error al eliminar producto");

            }
        } else
            throw new RuntimeException("Error al eliminar producto, no existe");

    }

    @Override
    public boolean guardarProducto(ProductsModel productsModel) {

        try {
            productsRepository.save(productsModel);
        } catch (Exception e) {
            throw new RuntimeException("Error al guardar producto");

        }

        if (productsRepository.findByCodigo(productsModel.getCodigo()).get() != null)
            return true;
        else
            return false;

    }

}
