package br.com.cadastro.cliente.srv_cliente.application.service;

import br.com.cadastro.cliente.srv_cliente.application.model.Cliente;

import java.util.Collection;

public interface ConsultaCliente {
    Collection<Cliente> consultarCliente();
}
