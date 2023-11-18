package com.atosalves.model;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Endereco {

	private String cidade;
	private String bairro;
	private String rua;
	private String CEP;
}
