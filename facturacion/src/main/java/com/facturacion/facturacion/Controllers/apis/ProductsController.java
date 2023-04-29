package com.facturacion.facturacion.Controllers.apis;

import com.facturacion.facturacion.Service.ProductsService;
import com.facturacion.facturacion.Model.ProductsModel;
import com.facturacion.facturacion.Repository.ProductsRepository;


import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.crossstore.ChangeSetPersister.NotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/Productos")
public class ProductsController {
    
    @Autowired
    ProductsService productsService;

    @Autowired
    ProductsRepository productsRepository;

    @ExceptionHandler(NotFoundException.class)
    @GetMapping("/all")
    public @ResponseBody List<ProductsModel> listarProductos(){
        return productsService.listarProductos();
    }

    @ExceptionHandler(NotFoundException.class)
    @GetMapping("/{id}")
    public @ResponseBody ProductsModel listarProductoPorID(@PathVariable @Valid int id){

        return productsService.listarProducto(id);
    }

    @ExceptionHandler(NotFoundException.class)
    @DeleteMapping("delete/{id}")
    public @ResponseBody void EliminarProductoPorID(@PathVariable @Valid int id){

        productsService.eliminarProducto(id);
    }

    @ExceptionHandler(DataIntegrityViolationException.class)
    @PostMapping("/save")
    public @ResponseBody ResponseEntity<?> GuardarProductoPorID(@RequestBody @Valid ProductsModel productsModel){

        Optional<ProductsModel> ProductoExistente = productsRepository.findByCodigo(productsModel.getCodigo());

        if(ProductoExistente.isPresent())
            return ResponseEntity.status(HttpStatus.CONFLICT).body("This product exist");
        else{
            productsService.guardarProducto(productsModel);
            return ResponseEntity.status(HttpStatus.CREATED).body("product created");
        }
    }

    @ExceptionHandler(DataIntegrityViolationException.class)
    @PostMapping("/update")
    public @ResponseBody ResponseEntity<?> actualizarProductoPorCodigo(@RequestBody @Valid ProductsModel productsModel){
        
        Optional<ProductsModel> ProductoExistente = productsRepository.findByCodigo(productsModel.getCodigo());

        if(ProductoExistente.isPresent())
        {
            productsService.guardarProducto(productsModel);
            return ResponseEntity.status(HttpStatus.CONFLICT).body("This product exist");
        }
        else{
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Thos producto does not exist");
        }

    }
}
