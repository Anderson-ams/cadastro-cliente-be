package br.com.dev.anderson.clienteempresa.cliente.infra;

import java.util.List;
import java.util.UUID;

import org.springframework.stereotype.Repository;

import br.com.dev.anderson.clienteempresa.cliente.application.repository.ClienteRepository;
import br.com.dev.anderson.clienteempresa.cliente.domain.Cliente;
import lombok.RequiredArgsConstructor;

@Repository
@RequiredArgsConstructor
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
    public void deletarCliente(UUID idCliente) {
        //clienteDBRepository.deleteById(idCliente);
    }
}
