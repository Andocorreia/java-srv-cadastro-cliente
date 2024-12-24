package br.com.cadastro.cliente.srv_cliente.application.service;

import br.com.cadastro.cliente.srv_cliente.application.model.Cliente;
import br.com.cadastro.cliente.srv_cliente.application.repository.ConsultaClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
public class ConsultaClienteImp implements ConsultaCliente {

    @Autowired
    ConsultaClienteRepository consultaClienteRepository;

    @Override
    public Collection<Cliente> consultarCliente() {
        return consultaClienteRepository.consultarCliente();
    }

    @Override
    public Cliente consultarClienteById(int id) {
        return consultaClienteRepository.consultarClienteById(id);
    }
}
