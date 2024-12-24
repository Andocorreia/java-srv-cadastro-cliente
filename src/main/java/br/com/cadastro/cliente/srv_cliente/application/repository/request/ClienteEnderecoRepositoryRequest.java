package br.com.cadastro.cliente.srv_cliente.application.repository.request;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ClienteEnderecoRepositoryRequest {
    private String cep;
    private String rua;
    private Integer numero;
    private String complemento;
    private String bairro;
    private String cidade;
    private String estado;
}
