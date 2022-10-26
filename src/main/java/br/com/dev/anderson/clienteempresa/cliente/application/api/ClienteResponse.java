package br.com.dev.anderson.clienteempresa.cliente.application.api;

import br.com.dev.anderson.clienteempresa.cliente.domain.Cliente;
import lombok.Value;

import java.util.UUID;

@Value
public class ClienteResponse {
	private UUID id;
	private String nome;
	private String cpf;
	private String telefone;
	private String endereco;

	public ClienteResponse(Cliente cliente) {
		this.id = cliente.getId();
		this.nome = cliente.getNome();
		this.cpf = cliente.getCpf();
		this.telefone = cliente.getTelefone();
		this.endereco = cliente.getEndereco();
	}
}
