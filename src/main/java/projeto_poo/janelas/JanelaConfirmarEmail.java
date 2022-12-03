package projeto_poo.janelas;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextField;

import projeto_poo.componentes.CaixaTextoPadrao;
import projeto_poo.componentes.TextoImagemPadrao;
import projeto_poo.ouvintes.OuvinteTeclasBloqueadas;

public class JanelaConfirmarEmail extends JanelaPadrao{

	public JanelaConfirmarEmail() {
		super("Confirmar e-mail");
		
		botaoConcluir();
		botaoVoltar();
		
		caixaCodigo();
		descricao();
		add(getFundoPadrao());
		logoConfirmarEmail();
		setVisible(true);
	}
	
	private JTextField codigo;
	
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
		JLabel textoCodigo = new TextoImagemPadrao("Código:");
		textoCodigo.setBounds(30, 100, 100, 19);
		add(textoCodigo);
		
		codigo = new CaixaTextoPadrao();
		codigo.addKeyListener(new OuvinteTeclasBloqueadas());
		codigo.setToolTipText(new OuvinteTeclasBloqueadas().getTeclasEspeciais());
		codigo.setBounds(100, 100, 200, 20);
		add(codigo);
	}
	
	private void botaoVoltar() {
		JButton botaoVoltar = getBotaoVoltar();
		botaoVoltar.setBounds(530, 220, 170, 41);
		add(botaoVoltar);
	}
	
	private void botaoConcluir() {
		JButton botaoConcluir = getBotaoConcluir();
		botaoConcluir.setBounds(530, 155, 170, 41);
		add(botaoConcluir);
	}
	
}
