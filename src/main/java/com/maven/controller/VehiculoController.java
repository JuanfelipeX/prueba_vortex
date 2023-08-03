/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.maven.controller;

import com.maven.model.Vehiculo;
import com.maven.service.VehiculoService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author pipes
 */

@RestController
@RequestMapping("/api/vehiculos")
public class VehiculoController {
    
     private final VehiculoService vehiculoService;

    @Autowired
    public VehiculoController(VehiculoService vehiculoService) {
        this.vehiculoService = vehiculoService;
    }

    @GetMapping
    public ResponseEntity<List<Vehiculo>> obtenerTodosLosVehiculos() {
        List<Vehiculo> vehiculos = vehiculoService.obtenerTodosLosVehiculos();
        return new ResponseEntity<>(vehiculos, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Vehiculo> guardarVehiculo(@RequestBody Vehiculo vehiculo) {
        Vehiculo savedVehiculo = vehiculoService.guardarVehiculo(vehiculo);
        return new ResponseEntity<>(savedVehiculo, HttpStatus.CREATED);
    }
    
}
