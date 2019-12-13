/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.demo.controller;

import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.model.Proveedores;
import com.example.demo.repository.ProveedoresRepository;
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
public class ProveedoresController {
     @Autowired
    ProveedoresRepository proveedoresRepository;

    @GetMapping("/proveedores")
    public List<Proveedores> getAllProveedores() {
        return proveedoresRepository.findAll();
    }
     @PostMapping("/proveedores")
    public Proveedores createProveedores(@Valid @RequestBody Proveedores proveedores) {
        return proveedoresRepository.saveAndFlush(proveedores);
    }

    @GetMapping("/proveedores/{id}")
    public Proveedores getProveedoresById(@PathVariable(value = "id") Long proveedoresId) {
        return proveedoresRepository.findById(proveedoresId)
                .orElseThrow(() -> new ResourceNotFoundException("Proveedores", "id", proveedoresId));
    }

    @PutMapping("/proveedores/{id}")
    public Proveedores updateProveedores(@PathVariable(value = "id") Long proveedoresId,
                                           @Valid @RequestBody Proveedores proveedoresDetails) {
        Proveedores proveedores = proveedoresRepository.findById(proveedoresId)
                .orElseThrow(() -> new ResourceNotFoundException("Proveedores", "id", proveedoresId));
        proveedores.nombre = proveedoresDetails.nombre;
        proveedores.estado = proveedoresDetails.estado;
         proveedores.numero = proveedoresDetails.numero;

        Proveedores updatedProveedores = proveedoresRepository.saveAndFlush(proveedores);
        return updatedProveedores;
    }

    @DeleteMapping("/proveedores/{id}")
    public ResponseEntity<?> deleteProveedores(@PathVariable(value = "id") Long proveedoresId) {
        Proveedores proveedores = proveedoresRepository.findById(proveedoresId)
                .orElseThrow(() -> new ResourceNotFoundException("Proveedores", "id", proveedoresId));
        proveedoresRepository.delete(proveedores);
        return ResponseEntity.ok().build();
    }
}
