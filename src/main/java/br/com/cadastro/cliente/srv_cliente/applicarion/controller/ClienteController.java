package br.com.cadastro.cliente.srv_cliente.applicarion.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1")
public class ClienteController {

    @GetMapping("/clientes")
    public String getClientes() {
        return "OK";
    }

}
