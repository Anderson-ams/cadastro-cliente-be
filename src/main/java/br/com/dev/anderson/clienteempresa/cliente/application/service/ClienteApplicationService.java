package br.com.dev.anderson.clienteempresa.cliente.application.service;

import java.util.List;
import java.util.UUID;

import org.springframework.stereotype.Service;

import br.com.dev.anderson.clienteempresa.cliente.application.api.ClienteListResponse;
import br.com.dev.anderson.clienteempresa.cliente.application.api.ClienteRequest;
import br.com.dev.anderson.clienteempresa.cliente.application.api.ClienteResponse;
import br.com.dev.anderson.clienteempresa.cliente.application.repository.ClienteRepository;
import br.com.dev.anderson.clienteempresa.cliente.domain.Cliente;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;

@Service
@Log4j2
@RequiredArgsConstructor
public class ClienteApplicationService implements ClienteService {

	private final ClienteRepository clienteRepository;

	@Override
	public ClienteResponse criaCliente(ClienteRequest clienteRequest) {
		log.info("[inicia] ClienteService - criaCliente");
		Cliente cliente = new Cliente(clienteRequest);
		clienteRepository.salvaNoBanco(cliente);
		log.info("[finaliza] ClienteService - criaCliente");
		return new ClienteResponse(cliente);
	}
	
	
	public List<ClienteListResponse> buscaTodosClientes(){
		log.info("[INICIADO] ClienteService - buscaCliente");
		List<Cliente> cliente = clienteRepository.buscaTodosClientes();
		log.info("[FINALIZADO] ClienteService - buscaCliente");
		return ClienteListResponse.converte(cliente);
	}

    @Override
    public void deletaCliente(UUID idCliente) {
        //busca id cliente: var idCliente = buscaClienteId();
		clienteRepository.deletarCliente(idCliente);
    }

}
