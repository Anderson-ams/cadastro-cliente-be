package br.com.dev.anderson.clienteempresa.cliente.application.api;

import lombok.Value;

import javax.validation.constraints.NotBlank;

@Value
public class ClienteRequestPETCH {
    private String nome;
    @NotBlank
    private String telefone;
    @NotBlank
    private String endereco;
}
