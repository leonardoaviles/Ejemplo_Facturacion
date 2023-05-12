package com.facturacion.facturacion.Service.impl;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.facturacion.facturacion.Model.CarritoModel;
import com.facturacion.facturacion.Model.CarritoProductoModel;
import com.facturacion.facturacion.Model.DetalleFacturaModel;
import com.facturacion.facturacion.Model.FacturaModel;
import com.facturacion.facturacion.Model.ProductsModel;
import com.facturacion.facturacion.Repository.CarritoRepository;
import com.facturacion.facturacion.Repository.ClientRepository;
import com.facturacion.facturacion.Repository.DetalleFacturaRepository;
import com.facturacion.facturacion.Repository.FacturaRepository;
import com.facturacion.facturacion.Repository.ProductsRepository;
import com.facturacion.facturacion.Service.FacturaService;

import org.apache.http.HttpResponse;
import org.apache.http.ParseException;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;
import com.google.gson.Gson;
import java.util.Map;

@Service
public class FacturaServiceImpl implements FacturaService {

    @Autowired
    FacturaRepository facturaRepository;

    @Autowired
    ClientRepository clienteRepository;

    @Autowired
    CarritoRepository carritoRepository;

    @Autowired
    DetalleFacturaRepository detalleFacturaRepository;

    @Autowired
    ProductsRepository productsRepository;

    @Override
    public FacturaModel listarFactura(long id) {
        try {
            return facturaRepository.findById(id).get();
        } catch (Exception e) {
            throw new RuntimeException("Error al listar Factura");

        }

    }

    @Override
    public List<FacturaModel> listarFacturas() {

        try {
            return (List<FacturaModel>) facturaRepository.findAll();
        } catch (Exception e) {
            throw new RuntimeException("Error al listar Facturas");

        }
    }

    @Override
    public void eliminarFactura(long id) {

        if (facturaRepository.existsById(id)) {
            try {
                facturaRepository.deleteById(id);
            } catch (Exception e) {
                throw new RuntimeException("Error al eliminar Factura");

            }
        } else
            throw new RuntimeException("Error al eliminar Factura, no existe");
    }

    @Override
    public void guardarFactura(FacturaModel facturaModel) {

        try {
            facturaModel.setDateFactura(fecha());

            DetalleFacturaModel detalleFacturaModel = new DetalleFacturaModel();

            detalleFacturaModel.setFacturaModel(facturaModel);

            List<CarritoModel> carritoModel = carritoRepository.findByClientsModel(facturaModel.getClientsModel())
                    .get();
            CarritoModel carritoModel2 = new CarritoModel();


            for (CarritoModel carrito : carritoModel) {

                if (carrito.getStatus() == true) {
                    carritoModel2 = carrito;
                    break;
                }
            }

            List<CarritoProductoModel> carritoProductoModel = carritoModel2.getCarritoProductoModel();

            for (CarritoProductoModel carrito : carritoProductoModel) {
                int cantidad = carrito.getCantidad();
                double precio = carrito.getProductsModel().getPrecio();
                double total = cantidad * precio;
                ProductsModel productsModel = new ProductsModel();

                productsModel = productsRepository.findByCodigo(carrito.getProductsModel().getCodigo()).get();

                if (cantidad <= productsModel.getStock()) {
                    detalleFacturaModel.setProductsModel(carrito.getProductsModel());
                    detalleFacturaModel.setCantidad(carrito.getCantidad());
                    detalleFacturaModel.setPrecioVenta(carrito.getProductsModel().getPrecio());

                    detalleFacturaModel.setTotal(total);

                    facturaRepository.save(facturaModel);

                    detalleFacturaRepository.save(detalleFacturaModel);

                    int stock = productsModel.getStock();

                    productsModel.setStock(stock - cantidad);

                    productsRepository.save(productsModel);

                }
            }
            carritoModel2.setStatus(false);

            carritoRepository.save(carritoModel2);

        } catch (Exception e) {
            throw new RuntimeException("Error al guardar factura");
        }

    }

    public String fecha() {

        String url = "http://worldtimeapi.org/api/timezone/America/Mexico_City";

        // Crear un objeto HttpClient
        HttpClient httpClient = HttpClientBuilder.create().build();

        // Crear una solicitud GET con la URL del API
        HttpGet request = new HttpGet("https://worldtimeapi.org/api/timezone/America/Mexico_City");

        // Ejecutar la solicitud y obtener la respuesta
        HttpResponse response = null;
        try {
            response = httpClient.execute(request);
        } catch (ClientProtocolException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        // Convertir la respuesta a una cadena de texto
        String jsonResponse = null;
        try {
            jsonResponse = EntityUtils.toString(response.getEntity());
        } catch (ParseException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        // Crear un objeto Gson
        Gson gson = new Gson();

        // Convertir la respuesta JSON a un mapa
        Map<String, Object> result = gson.fromJson(jsonResponse, Map.class);

        // Obtener el valor de la propiedad "datetime" del mapa
        String datetime = (String) result.get("datetime");

        // Imprimir la fecha y hora
        return datetime;

    }
}
