package br.com.dev.anderson.clienteempresa.cliente.application.api;

import java.util.List;
import java.util.stream.Collectors;

import br.com.dev.anderson.clienteempresa.cliente.domain.Cliente;
import lombok.Value;

@Value
public class ClienteListResponse {

	private Long id;
	private String nome;
	private String cpf;
	private String telefone;
	private String endereco;
	
	public ClienteListResponse(Cliente cliente) {
		this.id = cliente.getId();
		this.nome = cliente.getNome();
		this.cpf = cliente.getCpf();
		this.telefone = cliente.getTelefone();
		this.endereco = cliente.getEndereco();
	}

	public static List<ClienteListResponse> converte(List<Cliente> cliente) {
		return cliente.stream().map(ClienteListResponse::new)
				.collect(Collectors.toList());
	}
}
