package projeto_poo.paineis;

import javax.swing.JLabel;
import javax.swing.JTextField;

import projeto_poo.botoes.BotaoProsseguir;
import projeto_poo.caixas.CaixaBairroEndereco;
import projeto_poo.caixas.CaixaCEPNumero;
import projeto_poo.caixas.CaixaTextoPadrao;
import projeto_poo.diversos.TextoImagemPadrao;

public class PainelSolicitarCorrida extends PainelPadrao{
	
	private CaixaBairroEndereco endereco;
	private CaixaBairroEndereco bairro;
	private CaixaCEPNumero CEP;
	private CaixaCEPNumero numero;
	private JTextField complemento;
	
	

	public PainelSolicitarCorrida() {
		super();
		caixaEndereco();
		caixaCEP();
		caixaNumero();
		caixaBairro();
		caixaComplemento();
	}
	
	private void caixaEndereco() {
		TextoImagemPadrao textoEndereco = new TextoImagemPadrao("Endereço: ");
		textoEndereco.setBounds(30, 85, 100, 19);
		add(textoEndereco);
		
		endereco = new CaixaBairroEndereco();
		endereco.setBounds(130, 85, 220, 19);
		add(endereco);
	}
	private void caixaCEP() {
		TextoImagemPadrao textoCEP = new TextoImagemPadrao("CEP: ");
		textoCEP.setBounds(30, 125, 100, 19);
		add(textoCEP);
		
		CEP = new CaixaCEPNumero();
		CEP.setBounds(130, 125, 220, 19);
		add(CEP);
	}
	private void caixaNumero() {
		TextoImagemPadrao textoNumero = new TextoImagemPadrao("Número: ");
		textoNumero.setBounds(30, 165, 100, 19);
		add(textoNumero);
		
		numero = new CaixaCEPNumero();
		numero.setBounds(130, 165, 220, 19);
		add(numero);
	}
	private void caixaBairro() {
		TextoImagemPadrao textoBairro = new TextoImagemPadrao("Bairro: ");
		textoBairro.setBounds(30, 205, 100, 19);
		add(textoBairro);
		
		bairro = new CaixaBairroEndereco();
		bairro.setBounds(130, 205, 220, 19);
		add(bairro);
	}
	private void caixaComplemento() {
		TextoImagemPadrao textoComplemento = new TextoImagemPadrao("Complemento: ");
		textoComplemento.setBounds(30, 245, 100, 19);
		add(textoComplemento);
		
		complemento = new JTextField();
		complemento.setBounds(130, 245, 220, 19);
		add(complemento);
	}

	public CaixaBairroEndereco getEndereco() {
		return endereco;
	}

	public CaixaBairroEndereco getBairro() {
		return bairro;
	}

	public CaixaCEPNumero getCEP() {
		return CEP;
	}

	public CaixaCEPNumero getNumero() {
		return numero;
	}
	public JTextField getComplemento() {
		return complemento;
	}
}
