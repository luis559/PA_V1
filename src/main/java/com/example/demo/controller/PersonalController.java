/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.demo.controller;

import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.model.Personal;
import com.example.demo.repository.PersonalRepository;
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
public class PersonalController {
    @Autowired
    PersonalRepository personalRepository;

    @GetMapping("/personal")
    public List<Personal> getAllPersonal() {
        return personalRepository.findAll();
    }
     @PostMapping("/personal")
    public Personal createPersonal(@Valid @RequestBody Personal personal) {
        return personalRepository.saveAndFlush(personal);
    }

    @GetMapping("/personal/{id}")
    public Personal getPersonalById(@PathVariable(value = "id") Long personalId) {
        return personalRepository.findById(personalId)
                .orElseThrow(() -> new ResourceNotFoundException("personal", "id", personalId));
    }

    @PutMapping("/personal/{id}")
    public Personal updatePersonal(@PathVariable(value = "id") Long personalId,
                                           @Valid @RequestBody Personal personalDetails) {
        Personal personal = personalRepository.findById(personalId)
                .orElseThrow(() -> new ResourceNotFoundException("Personal", "id", personalId));
        personal.nombre = personalDetails.nombre;
        personal.cargo = personalDetails.cargo;
         personal.sueldo = personalDetails.sueldo;
         personal.edad = personalDetails.edad;
         personal.celular = personalDetails.celular;

        Personal updatedPersonal = personalRepository.saveAndFlush(personal);
        return updatedPersonal;
    }

    @DeleteMapping("/personal/{id}")
    public ResponseEntity<?> deletePersonal(@PathVariable(value = "id") Long personalId) {
        Personal personal = personalRepository.findById(personalId)
                .orElseThrow(() -> new ResourceNotFoundException("Personal", "id", personalId));
        personalRepository.delete(personal);
        return ResponseEntity.ok().build();
    }
}
