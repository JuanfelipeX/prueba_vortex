/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.maven.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

/**
 *
 * @author pipes
 */
@Entity
public class Vehiculo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 4, nullable = false)
    private String modelo;

    @Column(length = 7, nullable = false)
    private String placa;

    private String capacidad;

    @ManyToOne
    @JoinColumn(name = "conductor_id")
    private Conductor conductor;

    // Constructor, getters y setters
    public Vehiculo(Long id, String modelo, String placa, String capacidad, Conductor conductor) {
        this.id = id;
        this.modelo = modelo;
        this.placa = placa;
        this.capacidad = capacidad;
        this.conductor = conductor;
    }

    public Vehiculo() {
    }

    public Long getId() {
        return id;
    }

    public String getModelo() {
        return modelo;
    }

    public String getPlaca() {
        return placa;
    }

    public String getCapacidad() {
        return capacidad;
    }

    public Conductor getConductor() {
        return conductor;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    public void setCapacidad(String capacidad) {
        this.capacidad = capacidad;
    }

    public void setConductor(Conductor conductor) {
        this.conductor = conductor;
    }
}
