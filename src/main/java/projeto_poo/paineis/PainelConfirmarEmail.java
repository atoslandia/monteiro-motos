package projeto_poo.paineis;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

import projeto_poo.caixas.CaixaCodigo;
import projeto_poo.diversos.TextoImagemPadrao;

public class PainelConfirmarEmail extends PainelPadrao{
	
	private CaixaCodigo codigo;
	
	public PainelConfirmarEmail() {
		super();
		logoConfirmarEmail();
		descricao();
		codigo();
	}
	
   	private void logoConfirmarEmail() {
		JLabel logo = new TextoImagemPadrao(new ImageIcon("imgs/confirmaremail.png"));
		logo.setBounds(30, 30, 422, 31);
		add(logo);
	}
	
	private void descricao() {
		JLabel descricao = new TextoImagemPadrao("Verifique seu e-mail e preencha com o código de segurança recebido:");
		descricao.setBounds(30, 70, 500, 20);
		add(descricao);
	}
	
 	private void codigo() {
		TextoImagemPadrao textoCodigo = new TextoImagemPadrao("Código:");
		textoCodigo.setBounds(30, 100, 100, 19);
		add(textoCodigo);
		
		codigo = new CaixaCodigo();
		codigo.setBounds(100, 100, 200, 20);
		add(codigo);
	}
 	
 	public CaixaCodigo getCodigo() {
		return codigo;
	}
 	
}
