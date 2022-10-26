package br.com.dev.anderson.clienteempresa.cliente.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;

import org.hibernate.validator.constraints.br.CPF;

import br.com.dev.anderson.clienteempresa.cliente.application.api.ClienteRequest;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Getter
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@NoArgsConstructor(access = AccessLevel.PRIVATE)
@Entity 
public class Cliente {
	@Id
	//@GeneratedValue(strategy = GenerationType.AUTO)
	private UUID id;
	@NotBlank
	private String nome;
	@NotBlank
	//@CPF
	@Column(unique = true)
	private String cpf;
	@NotBlank
	private String telefone;
	@NotBlank
	private String endereco;

	public Cliente(ClienteRequest clienteRequest) {
		this.id = UUID.randomUUID();
		this.nome = clienteRequest.getNome();
		this.cpf = clienteRequest.getCpf();
		this.telefone = clienteRequest.getTelefone();
		this.endereco = clienteRequest.getEndereco();
	}
}

