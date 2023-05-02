package com.facturacion.facturacion.Service.impl;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.facturacion.facturacion.Model.FacturaModel;
import com.facturacion.facturacion.Repository.FacturaRepository;
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

    @Override
    public FacturaModel listarFactura(long id) {
        return facturaRepository.findById(id).get();
    }

    @Override
    public List<FacturaModel> listarFacturas() {

        return (List<FacturaModel>) facturaRepository.findAll();
    }

    @Override
    public void eliminarFactura(long id) {

        facturaRepository.deleteById(id);
    }

    @Override
    public void guardarFactura(FacturaModel facturaModel) {

        

        facturaRepository.save(facturaModel);

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
