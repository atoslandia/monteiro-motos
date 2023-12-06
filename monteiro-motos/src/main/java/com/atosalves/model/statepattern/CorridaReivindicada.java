package com.atosalves.model.statepattern;

import com.atosalves.dto.CorridaDTO;
import com.atosalves.dto.EnderecoDTO;
import com.atosalves.dto.UsuarioDTO;
import com.atosalves.enums.EstadoCorrida;
import com.atosalves.enums.TipoUsuario;
import com.atosalves.model.Corrida;
import com.atosalves.model.exceptions.AcessoNegadoException;

public class CorridaReivindicada extends CorridaState {

	public CorridaReivindicada(Corrida corrida) {
		super(corrida);
		nome = EstadoCorrida.REINVINDICADA;
	}

	@Override
	public void finalizarCorrida() {
		float saldoAnterior = corrida.getMototaxista().getLucro();
		corrida.getMototaxista().setLucro(saldoAnterior + (corrida.getValor() - ((corrida.getValor() * 20) / 100)));
		corrida.setEstado(new CorridaFinalizada(corrida));
		corrida.removerObservador();
	}

	@Override
	public void cancelarCorrida(TipoUsuario tipoUsuario) throws AcessoNegadoException {
		if (tipoUsuario.equals(TipoUsuario.MOTOTAXISTA)) {
			corrida.getPassageiro().getGerenciadorDePagamento().reembolso();
			corrida.setEstado(new CorridaCancelada(corrida));
			corrida.removerObservador();
		} else {
			throw new AcessoNegadoException("Não foi possivel cancelar");
		}
	}

	@Override
	public void reivindicarCorrida(UsuarioDTO mototaxista) throws AcessoNegadoException {
		throw new AcessoNegadoException("Não foi possivel reivindicar");
	}

	@Override
	public CorridaDTO solicitarCorrida(UsuarioDTO passageiro, EnderecoDTO pontoDeEncontro, EnderecoDTO destino)
		throws AcessoNegadoException {
		throw new AcessoNegadoException(corrida.getId(), "Já tem uma corrida em andamento");
	}
}
