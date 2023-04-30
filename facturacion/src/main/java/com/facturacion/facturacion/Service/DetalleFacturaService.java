package com.facturacion.facturacion.Service;

import com.facturacion.facturacion.Model.DetalleFacturaModel;
import java.util.List;

public interface DetalleFacturaService {

    public DetalleFacturaModel listarDetalleFactura(long id);
    public List<DetalleFacturaModel> listarDetalleFacturas();
    
}
