package projeto_poo;

public class Corrida {
	private long id;
	private PontoDeEncontro pontoDeEncontro;
	private Destino destino;
	private Passageiro passageiro;
	
	public Corrida() {
		id = System.currentTimeMillis();
	}
	
	public Corrida(PontoDeEncontro pontoDeEncontro, Destino destino, Passageiro passageiro) {
		id = System.currentTimeMillis();
		this.pontoDeEncontro = pontoDeEncontro;
		this.destino = destino;
		this.passageiro = passageiro;
	}
	
	public Passageiro getPassageiro() {
		return passageiro;
	}
	public void setPassageiro(Passageiro passageiro) {
		this.passageiro = passageiro;
	}
	
	public long getId() {
		return id;
	}
	
	public String toString() {
		if(passageiro.getSexo().equals(Sexo.FEMININO))
			return passageiro.getNome()+" pede para pega-la em "+ pontoDeEncontro.getEndereco();
		return passageiro.getNome()+" pede para pega-lo em "+ pontoDeEncontro.getEndereco();
	}
}
