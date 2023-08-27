package com.atosalves.model;

import lombok.Data;

@Data
public abstract class Usuario {

	private String nome;
	private String email;
	private String senha;
}
