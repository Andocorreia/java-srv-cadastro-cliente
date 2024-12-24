package br.com.cadastro.cliente.srv_cliente.application.repository.request;

import br.com.cadastro.cliente.srv_cliente.application.repository.response.ClienteEnderecoRepositoryResponse;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
public class ClienteRepositoryRequest {
    private Integer id;
    private String nome;
    private String cpf;
    private String email;
    private String telefone;
    private ClienteEnderecoRepositoryRequest endereco;
    private String sexo;
    private LocalDate dataNascimento;
    private LocalDate dataCadastro;
    private String estadoCivil;
    private String status;
}
