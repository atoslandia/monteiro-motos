package com.atosalves.model;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Endereco {

	private String bairro;
	private String rua;
	private String CEP;

	@Override
	public String toString() {
		return "Bairro: " + bairro + "\nRua: " + rua + "\nCEP: " + CEP;
	}
}
