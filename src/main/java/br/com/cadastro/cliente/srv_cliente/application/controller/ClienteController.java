package br.com.cadastro.cliente.srv_cliente.application.controller;

import br.com.cadastro.cliente.srv_cliente.application.mapper.ClienteMapper;
import br.com.cadastro.cliente.srv_cliente.application.model.Cliente;
import br.com.cadastro.cliente.srv_cliente.application.controller.response.ClienteResponse;
import br.com.cadastro.cliente.srv_cliente.application.service.ConsultaCliente;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Collection;

@RestController
@RequestMapping("/api/v1")
public class ClienteController {

    @Autowired
    ConsultaCliente consultaCliente;

    @Autowired
    ClienteMapper clienteMapper;

    private static final Logger logger = LoggerFactory.getLogger(ClienteController.class);

    @GetMapping("/clientes")
    public Collection<ClienteResponse> getClientes() {
        logger.info("Endpoint /clientes acionado");
        Collection< Cliente> cliente = this.consultaCliente.consultarCliente();
        logger.info("Retorno do endpoint /clientes com {} registros", cliente.size());
        return clienteMapper.toClienteResponse(cliente);

    }

}
