package br.com.cadastro.cliente.srv_cliente.application.controller;

import br.com.cadastro.cliente.srv_cliente.application.controller.request.ClienteRequest;
import br.com.cadastro.cliente.srv_cliente.application.mapper.ClienteMapper;
import br.com.cadastro.cliente.srv_cliente.application.model.Cliente;
import br.com.cadastro.cliente.srv_cliente.application.controller.response.ClienteResponse;
import br.com.cadastro.cliente.srv_cliente.application.service.AtualizaCliente;
import br.com.cadastro.cliente.srv_cliente.application.service.ConsultaCliente;
import br.com.cadastro.cliente.srv_cliente.application.service.CriaCliente;
import br.com.cadastro.cliente.srv_cliente.application.service.DeletaCliente;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Collection;

@RestController
@RequestMapping("/api/v1")
public class ClienteController {

    @Autowired
    ConsultaCliente consultaCliente;

    @Autowired
    DeletaCliente deletaCliente;

    @Autowired
    AtualizaCliente atualizaCliente;

    @Autowired
    ClienteMapper clienteMapper;

    @Autowired
    CriaCliente criaCliente;

    private static final Logger logger = LoggerFactory.getLogger(ClienteController.class);

    @GetMapping("/clientes")
    public Collection<ClienteResponse> getClientes() {
        logger.info("Endpoint /clientes acionado");
        Collection< Cliente> cliente = this.consultaCliente.consultar();
        logger.info("Retorno do endpoint /clientes com {} registros", cliente.size());
        return clienteMapper.toClienteResponse(cliente);

    }

    @GetMapping("/detalhe-cliente/{id}")
    public ClienteResponse getClienteDetalhe(@PathVariable int id) {
        logger.info("Endpoint /detalhe-cliente acionado para o cliente {}", id);
        Cliente cliente = this.consultaCliente.consultarById(id);
        logger.info("Retorno do endpoint /detalhe-cliente com o cliente {}", id);
        return clienteMapper.toClienteResponse(cliente);

    }

    @DeleteMapping("/deletar-cliente/{id}")
    public void deletarCliente(@PathVariable int id) {
        logger.info("Endpoint /deletar-cliente acionado para o cliente {}", id);
        this.deletaCliente.deletar(id);
        logger.info("Cliente {} excluído com sucesso", id);
    }

    @PutMapping("/atualizar-cliente")
    public ClienteResponse atualizarCliente(@RequestBody ClienteRequest clienteRequest) {
        logger.info("Endpoint /atualizar-cliente acionado para o cliente {}", clienteRequest.getId());

        Cliente cliente = clienteMapper.toCliente(clienteRequest);
        Cliente clienteAtualizado = this.atualizaCliente.atualizar(cliente);
        logger.info("Cliente {} atualizado com sucesso", clienteRequest.getId());
        return clienteMapper.toClienteResponse(clienteAtualizado);
    }

    @PostMapping("/cadastrar-cliente")
    public void cadastrarCliente(@RequestBody ClienteRequest clienteRequest) {
        logger.info("Endpoint /cadastrar-cliente acionado para o cliente {}", clienteRequest.getNome());

        Cliente cliente = clienteMapper.toCliente(clienteRequest);
        this.criaCliente.criar(cliente);
        logger.info("Cliente {} cadastrado com sucesso", clienteRequest.getNome());

    }

}
