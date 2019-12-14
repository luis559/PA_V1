/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.demo.controller;

import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.model.Sucursales;
import com.example.demo.repository.SucursalesRepository;
import java.util.List;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/api")
@CrossOrigin

public class SucursalesController {
    @Autowired
    SucursalesRepository sucursalesRepository;

    @GetMapping("/sucursales")
    public List<Sucursales> getAllSucursales() {
        return sucursalesRepository.findAll();
    }
     @PostMapping("/sucursales")
    public Sucursales createSucursales(@Valid @RequestBody Sucursales sucursales) {
        return sucursalesRepository.saveAndFlush(sucursales);
    }

    @GetMapping("/sucursales/{id}")
    public Sucursales getSucursalesById(@PathVariable(value = "id") Long sucursalesId) {
        return sucursalesRepository.findById(sucursalesId)
                .orElseThrow(() -> new ResourceNotFoundException("sucursales", "id", sucursalesId));
    }

    @PutMapping("/sucursales/{id}")
    public Sucursales updateSucursales(@PathVariable(value = "id") Long sucursalesId,
                                           @Valid @RequestBody Sucursales sucursalesDetails) {
        Sucursales sucursales = sucursalesRepository.findById(sucursalesId)
                .orElseThrow(() -> new ResourceNotFoundException("Sucursales", "id", sucursalesId));
        sucursales.nombre = sucursalesDetails.nombre;
        sucursales.ciudad = sucursalesDetails.ciudad;
        sucursales.direccion = sucursalesDetails.direccion;
        sucursales.telefono = sucursalesDetails.telefono;
        sucursales.gerencia = sucursalesDetails.gerencia;

        Sucursales updatedSucursales = sucursalesRepository.saveAndFlush(sucursales);
        return updatedSucursales;
    }

    @DeleteMapping("/sucursales/{id}")
    public ResponseEntity<?> deleteSucursales(@PathVariable(value = "id") Long sucursalesId) {
        Sucursales sucursales = sucursalesRepository.findById(sucursalesId)
                .orElseThrow(() -> new ResourceNotFoundException("Sucursales", "id", sucursalesId));
        sucursalesRepository.delete(sucursales);
        return ResponseEntity.ok().build();
    }
}
