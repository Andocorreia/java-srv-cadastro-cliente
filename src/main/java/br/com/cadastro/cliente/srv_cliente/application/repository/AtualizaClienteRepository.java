package br.com.cadastro.cliente.srv_cliente.application.repository;

import br.com.cadastro.cliente.srv_cliente.application.model.Cliente;

public interface AtualizaClienteRepository {
    Cliente atualizarCliente(Cliente cliente);
}
