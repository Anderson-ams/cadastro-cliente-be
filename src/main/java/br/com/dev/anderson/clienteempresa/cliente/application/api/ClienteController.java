package br.com.dev.anderson.clienteempresa.cliente.application.api;

import java.util.List;
import java.util.UUID;

import org.springframework.web.bind.annotation.RestController;

import br.com.dev.anderson.clienteempresa.cliente.application.service.ClienteService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;

import javax.validation.Valid;

@RestController
@Log4j2
@RequiredArgsConstructor
public class ClienteController implements ClienteApi{

	private final ClienteService clienteService;

	@Override
	public ClienteResponse postCliente(ClienteRequest clienteRequest) {
		ClienteResponse clienteCriado = clienteService.criaCliente(clienteRequest);
		return clienteCriado;
	}

	@Override
	public List<ClienteListResponse> buscaTodosClientes() {
		List<ClienteListResponse> clientes = clienteService.buscaTodosClientes();
		return clientes;
	}

	@Override
	public ClienteResponse buscaClientePorId(UUID idCliente) {
		ClienteResponse clienteResponse = clienteService.buscaClientePorId(idCliente);
		return clienteResponse;
	}

	@Override
	public void atualizaCliente(UUID idCliente, @Valid ClienteRequestPETCH clienteRequestPETCH) {
		log.info("PassouAqui=@@1@@ - INICIA CONTROLLER");
		clienteService.atualizaCliente(idCliente, clienteRequestPETCH);
		log.info("PassouAqui=@@1@@ - FINALIZOU CONTROLLER");
	}

	@Override
	public void deletaCliente(UUID idCliente) {
	clienteService.deletaCliente(idCliente);
	}
}
