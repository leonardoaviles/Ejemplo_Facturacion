package com.facturacion.facturacion.Controllers;

import com.facturacion.facturacion.Service.ProductsService;
import com.facturacion.facturacion.Model.ProductsModel;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/Productos")
public class ProductsController {
    
    @Autowired
    ProductsService productsService;

    @GetMapping("/all")
    public @ResponseBody List<ProductsModel> listarClientes(){
        return productsService.listarProductos();
    }

    @GetMapping("/{id}")
    public @ResponseBody ProductsModel listarClientePorID(@PathVariable int id){

        return productsService.listarProducto(id);
    }

    @DeleteMapping("delete/{id}")
    public void EliminarClientePorID(@PathVariable int id){

        productsService.eliminarProducto(id);
    }

    @PostMapping("/save")
    public void GuardarClientePorID(ProductsModel ProductsModel){

        productsService.guardarProducto(ProductsModel);
    }

}
