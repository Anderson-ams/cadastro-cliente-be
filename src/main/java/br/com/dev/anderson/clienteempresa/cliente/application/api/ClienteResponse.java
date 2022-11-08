package br.com.dev.anderson.clienteempresa.cliente.application.api;

import br.com.dev.anderson.clienteempresa.cliente.domain.Cliente;
import lombok.Value;

import java.util.UUID;

@Value
public class ClienteResponse {
	private UUID id;

	public ClienteResponse(Cliente cliente) {
		this.id = cliente.getId();

	}
}
