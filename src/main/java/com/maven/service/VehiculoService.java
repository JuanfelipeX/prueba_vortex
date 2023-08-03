/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.maven.service;

import com.maven.model.Vehiculo;
import com.maven.repository.VehiculoRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author pipes
 */
@Service
public class VehiculoService {

       private final VehiculoRepository vehiculoRepository;

    @Autowired
    public VehiculoService(VehiculoRepository vehiculoRepository) {
        this.vehiculoRepository = vehiculoRepository;
    }

    public List<Vehiculo> obtenerTodosLosVehiculos() {
        return vehiculoRepository.findAll();
    }

    public Vehiculo guardarVehiculo(Vehiculo vehiculo) {
        return vehiculoRepository.save(vehiculo);
    }
}
