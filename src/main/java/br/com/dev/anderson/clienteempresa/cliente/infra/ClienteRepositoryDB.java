package br.com.dev.anderson.clienteempresa.cliente.infra;

import java.util.List;
import java.util.UUID;

import br.com.dev.anderson.clienteempresa.handler.APIException;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Repository;

import br.com.dev.anderson.clienteempresa.cliente.application.repository.ClienteRepository;
import br.com.dev.anderson.clienteempresa.cliente.domain.Cliente;
import lombok.RequiredArgsConstructor;

@Repository
@RequiredArgsConstructor
@Log4j2
public class ClienteRepositoryDB implements ClienteRepository {

	private final ClienteDBRepository clienteDBRepository;

	@Override
	public Cliente salvaNoBanco(Cliente cliente) {
		clienteDBRepository.save(cliente);
		return cliente;
	}

	@Override
	public List<Cliente> buscaTodosClientes() {

		List<Cliente> todosClientes = clienteDBRepository.findAll();

		return todosClientes;
	}

	@Override
	public Cliente clienteBuscadoPorId(UUID idCliente) {

		Cliente cliente = clienteDBRepository.findById(idCliente)
						.orElseThrow(() -> new RuntimeException("Não encontrado"));

		return cliente;
	}

}
