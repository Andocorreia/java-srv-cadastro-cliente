package br.com.cadastro.cliente.srv_cliente.application.repository;

import br.com.cadastro.cliente.srv_cliente.application.mapper.ClienteMapper;
import br.com.cadastro.cliente.srv_cliente.application.model.Cliente;
import br.com.cadastro.cliente.srv_cliente.application.repository.request.ClienteRepositoryRequest;
import br.com.cadastro.cliente.srv_cliente.application.repository.response.ClienteRepositoryResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

@Service
public class AtualizaClienteRepositoryImp implements AtualizaClienteRepository {

    @Value("${clientes.url}")
    private String uri;

    @Autowired
    private WebClient.Builder webClientBuilder;

    @Autowired
    ClienteMapper clienteMapper;

    @Override
    public Cliente atualizarCliente(Cliente cliente) {

        String url = uri + "/alterar-cliente" ;

        ClienteRepositoryRequest request = clienteMapper.toClienteRepositoryRequest(cliente);

        ClienteRepositoryResponse clienteResponse =
                webClientBuilder.build().put().uri(url).bodyValue(request).retrieve().bodyToMono(ClienteRepositoryResponse.class).block();

        if (clienteResponse != null) {
            return clienteMapper.toCliente(clienteResponse);
        }
        return null;
    }
}
