package com.facturacion.facturacion.Service;

import com.facturacion.facturacion.Model.FacturaModel;

import java.util.List;


public interface FacturaService {

    public FacturaModel listarFactura(long id);
    public List<FacturaModel> listarFacturas();
    public void eliminarFactura(long id);
    public void guardarFactura(FacturaModel clientsModel);
    
}
