package br.com.cadastro.cliente.srv_cliente.application.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Cliente {
    private Integer id;
    private String nome;
    private String cpf;
    private String email;
    private String telefone;
    private Endereco endereco;
    private String sexo;
    private LocalDate dataNascimento;
    private LocalDate dataCadastro;
    private String estadoCivil;
    private String status;
}
