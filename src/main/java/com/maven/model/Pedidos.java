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
public class Pedidos {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 20)
    private String tipo_pedido;

    @Column(length = 50)
    private String direccion;

    @ManyToOne
    @JoinColumn(name = "conductor_id", nullable = false)
    private Conductor conductor;

    public Pedidos(Long id, String tipo_pedido, String direccion, Conductor conductor) {
        this.id = id;
        this.tipo_pedido = tipo_pedido;
        this.direccion = direccion;
        this.conductor = conductor;
    }

    public Pedidos() {
    }

    public Long getId() {
        return id;
    }

    public String getTipo_pedido() {
        return tipo_pedido;
    }

    public String getDireccion() {
        return direccion;
    }

    public Conductor getConductor() {
        return conductor;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setTipo_pedido(String tipo_pedido) {
        this.tipo_pedido = tipo_pedido;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public void setConductor(Conductor conductor) {
        this.conductor = conductor;
    }

      public Conductor getConductor_id() {
        return conductor;
    }

}
