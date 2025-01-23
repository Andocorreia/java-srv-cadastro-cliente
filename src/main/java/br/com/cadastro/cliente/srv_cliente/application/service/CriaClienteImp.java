package br.com.cadastro.cliente.srv_cliente.application.service;

import br.com.cadastro.cliente.srv_cliente.application.model.Cliente;
import br.com.cadastro.cliente.srv_cliente.application.repository.CriaClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CriaClienteImp implements CriaCliente {

    @Autowired
    CriaClienteRepository criaClienteRepository;

    @Override
    public void criar(Cliente cliente) {
        criaClienteRepository.criar(cliente);
    }

}
