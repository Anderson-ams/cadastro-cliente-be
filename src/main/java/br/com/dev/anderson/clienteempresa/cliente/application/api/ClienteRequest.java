package br.com.dev.anderson.clienteempresa.cliente.application.api;

import javax.validation.constraints.NotBlank;

import lombok.Value;

@Value
public class ClienteRequest {

	private String nome;
	@NotBlank
	private String cpf;
	@NotBlank
	private String telefone;
	@NotBlank
	private String endereco;
}


