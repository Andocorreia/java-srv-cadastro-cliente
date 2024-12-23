package br.com.cadastro.cliente.srv_cliente.application.repository;

import br.com.cadastro.cliente.srv_cliente.application.mapper.ClienteMapper;
import br.com.cadastro.cliente.srv_cliente.application.model.Cliente;
import br.com.cadastro.cliente.srv_cliente.application.repository.response.ClienteRepositoryResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.Collections;
import java.util.List;

@Repository
public class ConsultaClienteRepositoryImp implements ConsultaClienteRepository {

    @Value("${clientes.url}")
    private String url;

    @Autowired
    private WebClient.Builder webClientBuilder;

    @Autowired
    ClienteMapper clienteMapper;

    public Collection<Cliente> consultarCliente() {
        List<ClienteRepositoryResponse> clienteResponse =
                webClientBuilder.build().get().uri(url).retrieve().bodyToFlux(ClienteRepositoryResponse.class)
                        .collectList().block();

        if (clienteResponse != null) {
            return clienteMapper.toCliente(clienteResponse);
        }

        return Collections.EMPTY_LIST;
    }
}
