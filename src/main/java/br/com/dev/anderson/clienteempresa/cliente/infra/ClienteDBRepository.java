package br.com.dev.anderson.clienteempresa.cliente.infra;

import javax.persistence.Id;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.dev.anderson.clienteempresa.cliente.domain.Cliente;

import java.util.UUID;

public interface ClienteDBRepository extends JpaRepository<Cliente, Id>{

}
