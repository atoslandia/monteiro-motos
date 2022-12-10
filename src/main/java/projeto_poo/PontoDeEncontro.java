package projeto_poo;

public class PontoDeEncontro {
	private String endereco;
	private String CEP;
	private int numero;
	private String bairro;
	private String complemento;
	
	public PontoDeEncontro(String endereco, String cEP, int numero, String bairro, String complemento) {
		super();
		this.endereco = endereco;
		CEP = cEP;
		this.numero = numero;
		this.bairro = bairro;
		this.complemento = complemento;
	}
	
	public String getCEP() {
		return CEP;
	}
	public void setCEP(String cEP) {
		CEP = cEP;
	}
	public int getNumero() {
		return numero;
	}
	public void setNumero(int numero) {
		this.numero = numero;
	}
	public String getBairro() {
		return bairro;
	}
	public void setBairro(String bairro) {
		this.bairro = bairro;
	}
	public String getComplemento() {
		return complemento;
	}
	public void setComplemento(String complemento) {
		this.complemento = complemento;
	}
	
	public String getEndereco() {
		return endereco;
	}
	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}
}
