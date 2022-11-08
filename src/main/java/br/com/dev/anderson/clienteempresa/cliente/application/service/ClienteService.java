package br.com.dev.anderson.clienteempresa.cliente.application.service;

import java.util.List;
import java.util.UUID;

import br.com.dev.anderson.clienteempresa.cliente.application.api.ClienteListResponse;
import br.com.dev.anderson.clienteempresa.cliente.application.api.ClienteRequest;
import br.com.dev.anderson.clienteempresa.cliente.application.api.ClienteResponse;

public interface ClienteService {
	ClienteResponse criaCliente(ClienteRequest clienteRequest);
	
	List<ClienteListResponse> buscaTodosClientes();

	void deletaCliente(UUID idCliente);
}
