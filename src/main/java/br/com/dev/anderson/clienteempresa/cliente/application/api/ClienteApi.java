package br.com.dev.anderson.clienteempresa.cliente.application.api;

import java.util.List;
import java.util.UUID;

import javax.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/v1/cliente")
public interface ClienteApi {

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
