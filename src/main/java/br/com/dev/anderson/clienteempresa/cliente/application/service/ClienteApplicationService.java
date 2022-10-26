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

    public List<ClienteListResponse> buscaTodosClientes() {
        log.info("[INICIADO] ClienteService - buscaTodosClientes");
        List<Cliente> cliente = clienteRepository.buscaTodosClientes();
        log.info("[FINALIZADO] ClienteService - buscaTodosClientes");
        return ClienteListResponse.converte(cliente);
    }

    @Override
    public ClienteResponse buscaClientePorId(UUID idCliente) {
        log.info("[INICIADO] ClienteService - buscaClientePorId");
        Cliente cliente = clienteRepository.clienteBuscadoPorId(idCliente);
        log.info("[FINALIZADO] ClienteService - buscaClientePorId");
        return new ClienteResponse(cliente);
    }

}
