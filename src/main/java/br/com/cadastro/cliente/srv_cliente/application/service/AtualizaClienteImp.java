package br.com.cadastro.cliente.srv_cliente.application.service;

import br.com.cadastro.cliente.srv_cliente.application.model.Cliente;
import br.com.cadastro.cliente.srv_cliente.application.repository.AtualizaClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AtualizaClienteImp implements AtualizaCliente {

    @Autowired
    AtualizaClienteRepository atualizaClienteRepository;

    @Override
    public Cliente atualizar(Cliente cliente) {
        return atualizaClienteRepository.atualizar(cliente);
    }
}
