package projeto_poo;

import java.time.LocalDate;

public class Corrida {
	private long id;
	private PontoDeEncontro pontoDeEncontro;
	private Destino destino;
	private Passageiro passageiro;
	private LocalDate agendamento;
	
	public Corrida(PontoDeEncontro pontoDeEncontro, Destino destino, Passageiro passageiro) {
		id = System.currentTimeMillis();
		this.pontoDeEncontro = pontoDeEncontro;
		this.destino = destino;
		this.passageiro = passageiro;
	}
	
	public Corrida(PontoDeEncontro pontoDeEncontro, Destino destino, Passageiro passageiro, LocalDate data) {
		id = System.currentTimeMillis();
		this.pontoDeEncontro = pontoDeEncontro;
		this.destino = destino;
		this.passageiro = passageiro;
		this.agendamento = data;
	}
	
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

}
