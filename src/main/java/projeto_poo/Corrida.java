package projeto_poo;

public class Corrida {
	private long id;
	private String endereco;
	private String destino;
	private Passageiro passageiro;
	
	public Corrida() {
		id = System.currentTimeMillis();
	}
	
	public Corrida(String e, String d, Passageiro p) {
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
	public String getDestino() {
		return destino;
	}
	public void setDestino(String destino) {
		this.destino = destino;
	}
	public String getEndereco() {
		return endereco;
	}
	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}
	public long getId() {
		return id;
	}
	
	public String toString() {
	    String[] primeiroNome = getPassageiro().getNome().split(" ");
		if(getPassageiro().getSexo().equals(Sexo.F))
			return (primeiroNome[0]+" pede para pega-la em "+getEndereco());
		return (primeiroNome[0]+" pede para pega-lo em "+getEndereco());
	}
}
