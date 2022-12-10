package projeto_poo;

public class Destino extends Endereco{
	private float distancia;
	public Destino(String endereco, String cEP, int numero, String bairro, String complemento, float distancia) {
		super(endereco, cEP, numero, bairro, complemento);
		this.distancia = distancia;
	}
	

}
