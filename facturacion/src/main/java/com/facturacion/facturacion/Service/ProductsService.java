package com.facturacion.facturacion.Service;

import java.util.List;

import com.facturacion.facturacion.Model.ProductsModel;

public interface ProductsService {

    public ProductsModel listarProducto(int id);
    public List<ProductsModel> listarProductos();
    public void eliminarProducto(int id);
    public void guardarProducto(ProductsModel clientsModel);
    
}

