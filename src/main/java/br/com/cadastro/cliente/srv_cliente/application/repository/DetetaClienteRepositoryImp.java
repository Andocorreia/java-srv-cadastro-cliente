package br.com.cadastro.cliente.srv_cliente.application.repository;

import br.com.cadastro.cliente.srv_cliente.application.repository.response.ClienteRepositoryResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.List;

@Service
public class DetetaClienteRepositoryImp implements DetetaClienteRepository {

    @Value("${clientes.url}")
    private String uri;

    @Autowired
    private WebClient.Builder webClientBuilder;


    @Override
    public void deleteById(int id) {
        String url = uri + "/delete-cliente/" + id;
        webClientBuilder.build().delete().uri(url).retrieve().bodyToMono(Void.class).block();
    }
}
