/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.maven.service;

import com.maven.model.Conductor;
import com.maven.repository.ConductorRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author pipes
 */
@Service
public class ConductorService {

    
    private final ConductorRepository conductorRepository;

    @Autowired
    public ConductorService(ConductorRepository conductorRepository) {
        this.conductorRepository = conductorRepository;
    }

    public List<Conductor> obtenerTodosLosConductores() {
        return conductorRepository.findAll();
    }

    public Conductor guardarConductor(Conductor conductor) {
        return conductorRepository.save(conductor);
    }

    public Conductor obtenerConductorPorId(Long id) {
        return conductorRepository.findById(id).orElse(null);
    }

}
