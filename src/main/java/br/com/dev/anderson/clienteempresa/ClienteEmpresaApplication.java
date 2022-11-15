package br.com.dev.anderson.clienteempresa;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
@RequestMapping("/")
public class ClienteEmpresaApplication {
	@GetMapping
	public String teste() {
		return "Aqui";
	}
	public static void main(String[] args) {
		SpringApplication.run(ClienteEmpresaApplication.class, args);
	}

}
