package com.example.demo.controller;

import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.model.Producto;
import com.example.demo.repository.ProductoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api")
@CrossOrigin
public class ProductoController {
    @Autowired
    ProductoRepository productoRepository;

    @GetMapping("/productos")
    public List<Producto> getAllProductos() {
        return productoRepository.findAll();
    }


//    @GetMapping("/productosbynombre/{nombre}")
//    public List<Producto> getAllProductosByNombre(@PathVariable(value = "nombre") String nombre) {
////        return productoRepository.spproductosearch(nombre);
//        return productoRepository.findByName(nombre);
//    }

    @PostMapping("/productos")
    public Producto createProducto(@Valid @RequestBody Producto producto) {
        return productoRepository.saveAndFlush(producto);
    }

    @GetMapping("/productos/{id}")
    public Producto getProductoById(@PathVariable(value = "id") Long productoId) {
        return productoRepository.findById(productoId)
                .orElseThrow(() -> new ResourceNotFoundException("Producto", "id", productoId));
    }

    @PutMapping("/productos/{id}")
    public Producto updateProducto(@PathVariable(value = "id") Long productoId,
                                           @Valid @RequestBody Producto productoDetails) {
        Producto producto = productoRepository.findById(productoId)
                .orElseThrow(() -> new ResourceNotFoundException("Producto", "id", productoId));
        producto.nombre = productoDetails.nombre;
        producto.descripcion = productoDetails.descripcion;

        Producto updatedProducto = productoRepository.saveAndFlush(producto);
        return updatedProducto;
    }

    @DeleteMapping("/productos/{id}")
    public ResponseEntity<?> deleteProducto(@PathVariable(value = "id") Long productoId) {
        Producto producto = productoRepository.findById(productoId)
                .orElseThrow(() -> new ResourceNotFoundException("Producto", "id", productoId));
        productoRepository.delete(producto);
        return ResponseEntity.ok().build();
    }
}
