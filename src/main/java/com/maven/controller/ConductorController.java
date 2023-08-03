/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.maven.controller;

import com.maven.model.Conductor;
import com.maven.model.Vehiculo;
import com.maven.service.ConductorService;
import com.maven.service.VehiculoService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author pipes
 */
@RestController
@RequestMapping("/api/conductores")
public class ConductorController {

       private final ConductorService conductorService;
    private final VehiculoService vehiculoService;

    @Autowired
    public ConductorController(ConductorService conductorService, VehiculoService vehiculoService) {
        this.conductorService = conductorService;
        this.vehiculoService = vehiculoService;
    }

    @GetMapping
    public ResponseEntity<List<Conductor>> obtenerTodosLosConductores() {
        List<Conductor> conductores = conductorService.obtenerTodosLosConductores();
        return new ResponseEntity<>(conductores, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Conductor> guardarConductor(@RequestBody Conductor conductor) {
        Conductor savedConductor = conductorService.guardarConductor(conductor);
        return new ResponseEntity<>(savedConductor, HttpStatus.CREATED);
    }

    @PostMapping("/{conductorId}/asignar-vehiculos")
    public ResponseEntity<Conductor> asignarVehiculos(@PathVariable Long conductorId, @RequestBody List<Long> vehiculosIds) {
        Conductor conductor = conductorService.obtenerConductorPorId(conductorId);
        if (conductor == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        List<Vehiculo> vehiculos = vehiculoService.obtenerVehiculosPorIds(vehiculosIds);
        if (vehiculos.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        for (Vehiculo vehiculo : vehiculos) {
            if (vehiculo.getConductor() == null) {
                vehiculo.setConductor(conductor);
                vehiculoService.guardarVehiculo(vehiculo);
            }
        }

        return new ResponseEntity<>(conductor, HttpStatus.OK);
    }

    @PostMapping("/{conductorId}/desasociar-vehiculos")
    public ResponseEntity<Conductor> desasociarVehiculos(@PathVariable Long conductorId, @RequestBody List<Long> vehiculosIds) {
        Conductor conductor = conductorService.obtenerConductorPorId(conductorId);
        if (conductor == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        List<Vehiculo> vehiculos = vehiculoService.obtenerVehiculosPorIds(vehiculosIds);
        if (vehiculos.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        for (Vehiculo vehiculo : vehiculos) {
            if (vehiculo.getConductor() != null && vehiculo.getConductor().getId().equals(conductorId)) {
                vehiculo.setConductor(null);
                vehiculoService.guardarVehiculo(vehiculo);
            }
        }

        return new ResponseEntity<>(conductor, HttpStatus.OK);
    }
}
