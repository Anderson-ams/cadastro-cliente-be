package br.com.dev.anderson.clienteempresa.credencial.domain;

import lombok.Getter;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.UUID;

public class Credencial {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;
    @Getter
    private String usuario = "Anderson";
    @NotNull
    @Size(max = 60)
    private String senha;


}
