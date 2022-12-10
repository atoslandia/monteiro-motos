package projeto_poo.paineis;

import javax.swing.JLabel;

import projeto_poo.botoes.BotaoProsseguir;
import projeto_poo.caixas.CaixaEndereco;
import projeto_poo.caixas.CaixaNumeros;
import projeto_poo.caixas.CaixaTextoPadrao;
import projeto_poo.diversos.TextoImagemPadrao;

public class PainelSolicitarCorrida extends PainelPadrao{
	private CaixaEndereco endereco;
	private CaixaEndereco bairro;
	private CaixaNumeros CEP;
	private CaixaNumeros numero;
	private CaixaTextoPadrao complemento;
	
	public PainelSolicitarCorrida() {
		caixaEndereco();
		caixaCEP();
		caixaNumero();
		caixaBairro();
		caixaComplemento();

		setVisible(true);
	}
	
	private void caixaEndereco() {
		JLabel textoEndereco = new TextoImagemPadrao("Endereço: ");
		textoEndereco.setBounds(30, 85, 100, 19);
		add(textoEndereco);
		
		endereco = new CaixaEndereco();
		endereco.setBounds(130, 85, 220, 19);
		add(endereco);
	}
	private void caixaCEP() {
		JLabel textoCEP = new TextoImagemPadrao("CEP: ");
		textoCEP.setBounds(30, 125, 100, 19);
		add(textoCEP);
		
		CEP = new CaixaNumeros();
		CEP.setBounds(130, 125, 220, 19);
		add(CEP);
	}
	private void caixaNumero() {
		JLabel textoNumero = new TextoImagemPadrao("Número: ");
		textoNumero.setBounds(30, 165, 100, 19);
		add(textoNumero);
		
		numero = new CaixaNumeros();
		numero.setBounds(130, 165, 220, 19);
		add(numero);
	}
	private void caixaBairro() {
		JLabel textoBairro = new TextoImagemPadrao("Bairro: ");
		textoBairro.setBounds(30, 205, 100, 19);
		add(textoBairro);
		
		bairro = new CaixaEndereco();
		bairro.setBounds(130, 205, 220, 19);
		add(bairro);
	}
	private void caixaComplemento() {
		JLabel textoComplemento = new TextoImagemPadrao("Complemento: ");
		textoComplemento.setBounds(30, 245, 100, 19);
		add(textoComplemento);
		
		complemento = new CaixaEndereco();
		complemento.setBounds(130, 245, 220, 19);
		add(complemento);
	}
	

	
	
	
}
