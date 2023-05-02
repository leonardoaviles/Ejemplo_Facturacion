package com.facturacion.facturacion.Service;

import java.util.List;

import com.facturacion.facturacion.Model.CarritoModel;
import com.facturacion.facturacion.Model.CarritoProductoModel;
import com.facturacion.facturacion.Model.ClientsModel;

public interface CarritoService {
    
    public void guardarCarrito(CarritoModel carritoModel, CarritoProductoModel carritoProductoModel);
    public void guardarCarrito(CarritoModel carritoModel);
    public List<CarritoModel> listarCarritos();
}
