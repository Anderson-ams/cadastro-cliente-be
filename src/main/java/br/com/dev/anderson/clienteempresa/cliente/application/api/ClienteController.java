package br.com.dev.anderson.clienteempresa.cliente.application.api;

import java.util.List;
import java.util.UUID;

import org.springframework.web.bind.annotation.RestController;

import br.com.dev.anderson.clienteempresa.cliente.application.service.ClienteService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;

@RestController
@Log4j2
@RequiredArgsConstructor
public class ClienteController implements ClienteApi{

	private final ClienteService clienteService;

	@Override
	public ClienteResponse postCliente(ClienteRequest clienteRequest) {
		log.info("[inicia] ClienteController - postCliente");
		ClienteResponse clienteCriado = clienteService.criaCliente(clienteRequest);
		log.info("[finaliza] ClienteController - postCliente");
		return clienteCriado;
	}

	@Override
	public List<ClienteListResponse> buscaTodosClientes() {
		log.info("[inicia] ClienteController - getCliente");
		List<ClienteListResponse> clientes = clienteService.buscaTodosClientes();
		log.info("[finaliza] ClienteController - getCliente");
		return clientes;
	}

	@Override
	public ClienteResponse buscaClientePorId(UUID idCliente) {
		log.info("[INICIA] ClienteController - buscaClientePorId");
		ClienteResponse clienteResponse = clienteService.buscaClientePorId(idCliente);
		log.info("[FINALIZA] ClienteController - buscaClientePorId");
		return clienteResponse;
	}
}
