package br.com.dev.anderson.clienteempresa.cliente.application.repository;

import java.util.List;
import java.util.UUID;

import br.com.dev.anderson.clienteempresa.cliente.domain.Cliente;

public interface ClienteRepository {
	Cliente salvaNoBanco(Cliente cliente);

	List<Cliente> buscaTodosClientes();

	Cliente clienteBuscadoPorId(UUID idCliente);
}
