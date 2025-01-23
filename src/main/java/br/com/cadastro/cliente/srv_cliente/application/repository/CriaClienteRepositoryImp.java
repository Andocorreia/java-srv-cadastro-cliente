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
public class CriaClienteRepositoryImp implements CriaClienteRepository {

    @Value("${clientes.url}")
    private String uri;

    @Autowired
    private WebClient.Builder webClientBuilder;

    @Autowired
    ClienteMapper clienteMapper;


    @Override
    public void criar(Cliente cliente) {
        String url = uri + "/cadastrar-cliente" ;

        ClienteRepositoryRequest request = clienteMapper.toClienteRepositoryRequest(cliente);
        webClientBuilder.build().post().uri(url).bodyValue(request).retrieve().bodyToMono(Void.class).block();

    }
}
