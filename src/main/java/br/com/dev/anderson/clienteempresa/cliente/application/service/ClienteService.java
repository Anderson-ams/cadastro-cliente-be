package br.com.dev.anderson.clienteempresa.cliente.application.service;

import java.util.List;
import java.util.UUID;

import br.com.dev.anderson.clienteempresa.cliente.application.api.ClienteListResponse;
import br.com.dev.anderson.clienteempresa.cliente.application.api.ClienteRequest;
import br.com.dev.anderson.clienteempresa.cliente.application.api.ClienteRequestPETCH;
import br.com.dev.anderson.clienteempresa.cliente.application.api.ClienteResponse;
import br.com.dev.anderson.clienteempresa.cliente.domain.Cliente;

public interface ClienteService {
    ClienteResponse criaCliente(ClienteRequest clienteRequest);

    List<ClienteListResponse> buscaTodosClientes();

    ClienteResponse buscaClientePorId(UUID idCliente);

    void atualizaCliente(UUID idCliente, ClienteRequestPETCH clienteRequestPETCH);
}
