package com.atosalves.model.statepattern;

import com.atosalves.dto.corrida.CorridaDTO;
import com.atosalves.dto.corrida.EnderecoDTO;
import com.atosalves.dto.usuario.UsuarioDTO;
import com.atosalves.enums.EstadoCorrida;
import com.atosalves.enums.TipoUsuario;
import com.atosalves.model.Avaliacao;
import com.atosalves.model.Corrida;
import com.atosalves.model.Mototaxista;
import com.atosalves.model.exceptions.AcessoNegadoException;

public class CorridaPendente extends CorridaState {

	public CorridaPendente(Corrida corrida) {
		super(corrida);
		nome = EstadoCorrida.PENDENTE;
	}

	@Override
	public void finalizarCorrida() throws AcessoNegadoException {
		throw new AcessoNegadoException("Não foi possivel finalizar");
	}

	@Override
	public void reivindicarCorrida(UsuarioDTO mototaxista) {
		corrida.setMototaxista((Mototaxista) mototaxista.usuario());
		corrida.setEstado(new CorridaReivindicada(corrida));
	}

	@Override
	public void cancelarCorrida(TipoUsuario tipoUsuario) throws AcessoNegadoException {
		if (tipoUsuario.equals(TipoUsuario.PASSAGEIRO)) {
			corrida.getPassageiro().getGerenciadorDePagamento().reembolso();
			corrida.setEstado(new CorridaCancelada(corrida));
			corrida.removerObservador();
		} else {
			throw new AcessoNegadoException("Não foi possivel Cancelar");
		}
	}

	@Override
	public CorridaDTO solicitarCorrida(UsuarioDTO passageiro, EnderecoDTO pontoDeEncontro, EnderecoDTO destino)
		throws AcessoNegadoException {
		throw new AcessoNegadoException(corrida.getId(), "Cancele a corrida para pedir outra");
	}

	@Override
	public void avaliarMototaxista(Avaliacao avaliacao) throws AcessoNegadoException {
		throw new AcessoNegadoException("Não é possivel avaliar");
	}
}
