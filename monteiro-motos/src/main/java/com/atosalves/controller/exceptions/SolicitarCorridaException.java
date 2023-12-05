package com.atosalves.controller.exceptions;

public class SolicitarCorridaException extends Exception {

	private Long idCorrida;

	public SolicitarCorridaException(Long idCorrida, String message) {
		super(message);
		this.idCorrida = idCorrida;
	}

	public Long getIdCorrida() {
		return idCorrida;
	}
}
