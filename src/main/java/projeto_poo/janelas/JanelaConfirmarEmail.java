package projeto_poo.janelas;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;

public class JanelaConfirmarEmail extends JanelaPadrao{

	public JanelaConfirmarEmail() {
		super("Confirmar e-mail");
		
		botaoConcluir();
		botaoCancelar();
		
		caixaCodigo();
		descricao();
		add(getFundoPadrao());
		logoConfirmarEmail();
		setVisible(true);
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
	
	private void caixaCodigo() {
		getTextoCodigo().setBounds(30, 100, 100, 19);
		getCodigo().setBounds(100, 100, 200, 20);
	}
	
	private void botaoCancelar() {
		JButton botaoCancelar = getBotaoCancelar();
		botaoCancelar.setBounds(530, 220, 170, 41);
		add(botaoCancelar);
	}
	
	private void botaoConcluir() {
		JButton botaoConcluir = getBotaoConcluir();
		botaoConcluir.setBounds(530, 155, 170, 41);
		add(botaoConcluir);
	}
	
}
