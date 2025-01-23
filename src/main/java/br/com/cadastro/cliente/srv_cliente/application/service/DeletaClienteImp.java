package br.com.cadastro.cliente.srv_cliente.application.service;

import br.com.cadastro.cliente.srv_cliente.application.repository.DetetaClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DeletaClienteImp implements DeletaCliente {

    @Autowired
    DetetaClienteRepository detetaClienteRepository;

    @Override
    public void deletar(int id) {
        detetaClienteRepository.deleteById(id);
    }
}
