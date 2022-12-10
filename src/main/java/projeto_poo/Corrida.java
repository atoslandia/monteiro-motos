package projeto_poo;

public class Corrida {
	private long id;
	private PontoDeEncontro endereco;
	private Destino destino;
	private Passageiro passageiro;
	
	public Corrida() {
		id = System.currentTimeMillis();
	}
	
	public Corrida(PontoDeEncontro e, Destino d, String cep, int numero , String bairro, String complemento , Passageiro p) {
		id = System.currentTimeMillis();
		endereco = e;
		destino = d;
		passageiro = p;
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
	    String[] primeiroNome = getPassageiro().getNome().split(" ");
		if(getPassageiro().getSexo().equals(Sexo.F))
			return (primeiroNome[0]+" pede para pega-la em "+ endereco.getEndereco());
		return (primeiroNome[0]+" pede para pega-lo em "+ endereco.getEndereco());
	}
}
