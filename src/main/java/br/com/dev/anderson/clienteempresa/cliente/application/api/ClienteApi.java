package br.com.dev.anderson.clienteempresa.cliente.application.api;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.UUID;

import javax.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import java.util.UUID;

@RestController
@RequestMapping("/v1/cliente")
public interface ClienteApi {
    @PostMapping
    @ResponseStatus(code = HttpStatus.CREATED)
    ClienteResponse postCliente(@RequestBody @Valid ClienteRequest clienteRequest);
    @GetMapping
    @ResponseStatus(code = HttpStatus.OK)
    List<ClienteListResponse> buscaTodosClientes();
    @GetMapping(value = "/{idCliente}")
    @ResponseStatus(code = HttpStatus.OK)
    ClienteResponse buscaClientePorId(@PathVariable UUID idCliente);

    @PatchMapping(value = "/{idCliente}")
    @ResponseStatus(code = HttpStatus.NO_CONTENT)
    void atualizaCliente(@PathVariable UUID idCliente,
                         @RequestBody @Valid ClienteRequestPETCH clienteRequestPETCH);


	@PostMapping
	@ResponseStatus(code = HttpStatus.CREATED)
	ClienteResponse postCliente(@RequestBody @Valid ClienteRequest clienteRequest);

	@GetMapping
	@ResponseStatus(code = HttpStatus.OK)
	List<ClienteListResponse> getCliente();

	@DeleteMapping(value = "/{idCliente}/deletar")
	@ResponseStatus(code = HttpStatus.OK)
	void deletaCliente(@PathVariable UUID idCliente);
}
