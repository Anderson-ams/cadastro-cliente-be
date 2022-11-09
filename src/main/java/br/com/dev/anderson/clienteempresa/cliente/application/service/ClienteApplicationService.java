package br.com.dev.anderson.clienteempresa.cliente.application.service;

import br.com.dev.anderson.clienteempresa.cliente.application.api.ClienteListResponse;
import br.com.dev.anderson.clienteempresa.cliente.application.api.ClienteRequest;
import br.com.dev.anderson.clienteempresa.cliente.application.api.ClienteRequestPETCH;
import br.com.dev.anderson.clienteempresa.cliente.application.api.ClienteResponse;
import br.com.dev.anderson.clienteempresa.cliente.application.repository.ClienteRepository;
import br.com.dev.anderson.clienteempresa.cliente.domain.Cliente;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@Log4j2
@RequiredArgsConstructor
public class ClienteApplicationService implements ClienteService {
    private final ClienteRepository clienteRepository;

    @Override
    public ClienteResponse criaCliente(ClienteRequest clienteRequest) {
        Cliente cliente = new Cliente(clienteRequest);
        clienteRepository.salvaNoBanco(cliente);
        return new ClienteResponse(cliente);
    }

    public List<ClienteListResponse> buscaTodosClientes() {
        List<Cliente> cliente = clienteRepository.buscaTodosClientes();
        return ClienteListResponse.converte(cliente);
    }

    @Override
    public ClienteResponse buscaClientePorId(UUID idCliente) {
        Cliente cliente = clienteRepository.clienteBuscadoPorId(idCliente);
        return new ClienteResponse(cliente);
    }

    @Override
    public void atualizaCliente(UUID idCliente, ClienteRequestPETCH clienteRequestPETCH) {
        log.info("PassouAqui=@@2@@ - INICIA APPLICATIONSERVICE");
        Cliente cliente = clienteRepository.clienteBuscadoPorId(idCliente);
        cliente.alteraCliente(clienteRequestPETCH);
        clienteRepository.salvaNoBanco(cliente);
        log.info("PassouAqui=@@2@@ - FINALIZA APPLICATIONSERVICE");
    }

    @Override
    public void deletaCliente(UUID idCliente) {
//        Cliente cliente = clienteRepository.clienteBuscadoPorId(idCliente);
        clienteRepository.deletarCliente(idCliente);
    }


}
