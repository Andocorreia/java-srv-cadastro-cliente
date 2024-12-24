package br.com.cadastro.cliente.srv_cliente.application.repository;

import br.com.cadastro.cliente.srv_cliente.application.model.Cliente;

import java.util.Collection;

public interface ConsultaClienteRepository {
    Collection<Cliente> consultarCliente();

    Cliente consultarClienteById(int id);
}
