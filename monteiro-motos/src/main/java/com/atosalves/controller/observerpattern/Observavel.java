package com.atosalves.controller.observerpattern;

import com.atosalves.dto.CorridaEventoDTO;
import com.thoughtworks.xstream.annotations.XStreamAsAttribute;
import lombok.Getter;

@Getter
public abstract class Observavel {

	@XStreamAsAttribute
	private Observador observador;

	public void adicionarObservador(Observador observador) {
		this.observador = observador;
	}

	public void removerObservador() {
		observador = null;
	}

	protected void notificarObservador(CorridaEventoDTO corrida) {
		observador.update(corrida);
	}
}
