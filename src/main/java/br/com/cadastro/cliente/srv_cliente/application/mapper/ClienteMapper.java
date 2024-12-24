package br.com.cadastro.cliente.srv_cliente.application.mapper;

import br.com.cadastro.cliente.srv_cliente.application.controller.request.ClienteRequest;
import br.com.cadastro.cliente.srv_cliente.application.model.Cliente;
import br.com.cadastro.cliente.srv_cliente.application.controller.response.ClienteResponse;
import br.com.cadastro.cliente.srv_cliente.application.repository.request.ClienteRepositoryRequest;
import br.com.cadastro.cliente.srv_cliente.application.repository.response.ClienteRepositoryResponse;
import org.mapstruct.Mapper;

import java.util.Collection;

@Mapper(componentModel = "spring")
public interface ClienteMapper {

    Collection<ClienteResponse> toClienteResponse(Collection<Cliente> clientes);

    ClienteResponse toClienteResponse(Cliente clientes);

    Cliente toCliente(ClienteRepositoryResponse clientesRepositoryResponse);

    Collection<Cliente> toCliente(Collection<ClienteRepositoryResponse> clientesRepositoryResponse);

    Cliente toCliente(ClienteRequest clienteRequest);

    ClienteRepositoryRequest toClienteRepositoryRequest(Cliente cliente);
}
