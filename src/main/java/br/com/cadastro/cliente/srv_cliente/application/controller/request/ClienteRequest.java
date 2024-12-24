package br.com.cadastro.cliente.srv_cliente.application.controller.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ClienteRequest {
    private Integer id;
    private String nome;
    private String cpf;
    private String email;
    private String telefone;
    private ClienteEnderecoRequest endereco;
    private String sexo;
    private LocalDate dataNascimento;
    private LocalDate dataCadastro;
    private String estadoCivil;
    private String status;
}
