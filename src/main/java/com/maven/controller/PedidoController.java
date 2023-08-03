/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.maven.controller;

import com.maven.model.Pedidos;
import com.maven.repository.PedidoRepository;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author pipes
 */
@RestController
@RequestMapping("api/pedido")
@RequiredArgsConstructor
public class PedidoController {

    @Autowired
    private PedidoRepository pedidoRepository;

    @Autowired
    public PedidoController(PedidoRepository pedidoRepository) {
        this.pedidoRepository = pedidoRepository;
    }

    // Endpoint para obtener todos los pedidos
    @GetMapping
    public List<Pedidos> obtenerTodosLosPedidos() {
        return pedidoRepository.findAll();
    }

    // Endpoint para crear un nuevo pedido
    @PostMapping
    public Pedidos crearPedido(@RequestBody Pedidos pedido) {
        return pedidoRepository.save(pedido);
    }

    // Endpoint para obtener un pedido por su ID
    @GetMapping("/{id}")
    public ResponseEntity<Pedidos> obtenerPedidoPorId(@PathVariable Long id) {
        Pedidos pedido = pedidoRepository.findById(id).orElse(null);
        if (pedido != null) {
            return ResponseEntity.ok(pedido);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    // Endpoint para actualizar un pedido existente
    @PutMapping("/{id}")
    public ResponseEntity<Pedidos> actualizarPedido(@PathVariable Long id, @RequestBody Pedidos pedidoActualizado) {
        Pedidos pedido = pedidoRepository.findById(id).orElse(null);
        if (pedido != null) {
            pedido.setTipo_pedido(pedidoActualizado.getTipo_pedido());
            pedido.setDireccion(pedidoActualizado.getDireccion());
            pedido.setConductor_id(pedidoActualizado.getConductor_id());
            return ResponseEntity.ok(pedidoRepository.save(pedido));
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    // Endpoint para eliminar un pedido por su ID
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarPedidoPorId(@PathVariable Long id) {
        Pedidos pedido = pedidoRepository.findById(id).orElse(null);
        if (pedido != null) {
            pedidoRepository.delete(pedido);
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }

}
