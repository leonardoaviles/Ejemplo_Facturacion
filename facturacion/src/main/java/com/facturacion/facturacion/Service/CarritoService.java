package com.facturacion.facturacion.Service;

import java.util.List;

import com.facturacion.facturacion.Model.CarritoModel;

public interface CarritoService {
    
    public boolean guardarCarrito(CarritoModel carritoModel);
    public List<CarritoModel> listarCarritos();
}
