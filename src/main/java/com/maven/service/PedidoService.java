/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.maven.service;

import com.maven.model.Pedidos;
import com.maven.repository.PedidoRepository;
import java.util.List;
import java.util.Optional;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author pipes
 */
@Service
@RequiredArgsConstructor
public class PedidoService {

 private final PedidoRepository pedidosRepository;

    @Autowired
    public PedidoService(PedidoRepository pedidosRepository) {
        this.pedidosRepository = pedidosRepository;
    }

    public List<Pedidos> obtenerTodosLosPedidos() {
        return pedidosRepository.findAll();
    }

    public Pedidos guardarPedido(Pedidos pedido) {
        return pedidosRepository.save(pedido);
    }

    // Otros métodos según tus necesidades
}
