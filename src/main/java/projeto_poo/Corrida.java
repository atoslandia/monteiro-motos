package projeto_poo;

import java.time.LocalDate;
import java.time.ZoneOffset;
import java.time.ZonedDateTime;
import java.util.Date;

public class Corrida {
	private boolean corridaAceita;
	private Mototaxista mototaxistaBloqueado;
	private long id;
	private PontoDeEncontro pontoDeEncontro;
	private Destino destino;
	private Passageiro passageiro;
	private LocalDate agendamento;
	
	public Corrida(PontoDeEncontro pontoDeEncontro, Destino destino, Passageiro passageiro) {
		this.corridaAceita = false;
		this.id = System.currentTimeMillis();
		this.pontoDeEncontro = pontoDeEncontro;
		this.destino = destino;
		this.passageiro = passageiro;
	}
	
	public Corrida(PontoDeEncontro pontoDeEncontro, Destino destino, Passageiro passageiro, LocalDate data) {
		this.corridaAceita = false;
		this.id = data.toEpochDay();
		this.pontoDeEncontro = pontoDeEncontro;
		this.destino = destino;
		this.passageiro = passageiro;
		this.agendamento = data;
	}
	
//	public String dataDaCorrida() {
//		Date data = new Date(id);
//		int mes = data.getMonth();
//		int ano = data.getYear();
//		return dia+"/"+mes+1+"/"+ano;
//	}
	
	public Passageiro getPassageiro() {
		return passageiro;
	}
	
	public long getId() {
		return id;
	}
	
	public Destino getDestino() {
		return destino;
	}
	public LocalDate getAgendamento() {
		return agendamento;
	}

	public String toString() {
		if(passageiro.getSexo().equals(Sexo.FEMININO))
			return passageiro.getNome()+" pede para pega-la em "+ pontoDeEncontro.getEndereco();
		return passageiro.getNome()+" pede para pega-lo em "+ pontoDeEncontro.getEndereco();
	}

	public boolean isCorridaAceita() {
		return corridaAceita;
	}

	public void setCorridaAceita(boolean corridaAceita) {
		this.corridaAceita = corridaAceita;
	}

	public Mototaxista getMototaxistaBloqueado() {
		return mototaxistaBloqueado;
	}

	public void setMototaxistaBloqueado(Mototaxista mototaxistaBloqueado) {
		this.mototaxistaBloqueado = mototaxistaBloqueado;
	}

}
