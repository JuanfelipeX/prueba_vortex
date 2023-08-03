/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.maven.model;

import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

/**
 *
 * @author pipes
 */
@Entity
public class Conductor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 11, nullable = false)
    private String identificacion;

    @Column(length = 20)
    private String apellido;

    @Column(length = 20, nullable = false)
    private String nombre;

    @Column(length = 10, nullable = false)
    private String telefono;

    @Column(length = 50)
    private String direccion;

    @OneToMany(mappedBy = "conductor")
    private List<Vehiculo> vehiculos;

    // Constructor, getters y setters
    public Conductor(Long id, String identificacion, String apellido, String nombre, String telefono, String direccion) {
        this.id = id;
        this.identificacion = identificacion;
        this.apellido = apellido;
        this.nombre = nombre;
        this.telefono = telefono;
        this.direccion = direccion;
    }

    public Conductor() {
    }

    public Long getId() {
        return id;
    }

    public String getIdentificacion() {
        return identificacion;
    }

    public String getApellido() {
        return apellido;
    }

    public String getNombre() {
        return nombre;
    }

    public String getTelefono() {
        return telefono;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setIdentificacion(String identificacion) {
        this.identificacion = identificacion;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }
}
