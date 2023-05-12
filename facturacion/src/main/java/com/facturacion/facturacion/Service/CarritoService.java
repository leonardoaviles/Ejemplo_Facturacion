package com.facturacion.facturacion.Service;

import java.util.List;
import java.util.Optional;

import com.facturacion.facturacion.Model.CarritoModel;
import com.facturacion.facturacion.Model.ClientsModel;

public interface CarritoService {
    
    public boolean guardarCarrito(CarritoModel carritoModel);
    public List<CarritoModel> listarCarritos();
    public Optional<List<CarritoModel>> listarCarritosPorId(ClientsModel ClientsModel);
}
