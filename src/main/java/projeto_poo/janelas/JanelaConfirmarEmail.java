package projeto_poo.janelas;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextField;

import projeto_poo.Administrador;
import projeto_poo.CentralDeInformacoes;
import projeto_poo.Mototaxista;
import projeto_poo.Passageiro;
import projeto_poo.Usuario;
import projeto_poo.componentes.BotaoConcluir;
import projeto_poo.componentes.BotaoVoltar;
import projeto_poo.componentes.CaixaTextoPadrao;
import projeto_poo.componentes.ComponentesEstaticos;
import projeto_poo.componentes.TextoImagemPadrao;

public class JanelaConfirmarEmail extends JanelaPadrao{
	
	private JTextField codigo;
	private String codigoGerado;
	private Usuario usuario;
	
	public JanelaConfirmarEmail(String codigoGerado, Usuario usuario) {
		super("Confirmar e-mail");
		
		this.codigoGerado = codigoGerado;
		this.usuario = usuario;

		botaoConcluir();
		botaoVoltar();
		
		caixaCodigo();
		descricao();
		logoConfirmarEmail();
		add(ComponentesEstaticos.fundoPadrao());
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
		JLabel textoCodigo = new TextoImagemPadrao("Código:");
		textoCodigo.setBounds(30, 100, 100, 19);
		add(textoCodigo);
		
		codigo = new CaixaTextoPadrao();
		codigo.addKeyListener(new OuvinteTeclasCodigo());
		codigo.setToolTipText(new OuvinteTeclasCodigo().getTeclasEspeciais());
		codigo.setBounds(100, 100, 200, 20);
		add(codigo);
	}
	
	private void botaoConcluir() {
		JButton botaoConcluir = new BotaoConcluir();
		botaoConcluir.setBounds(530, 170, 170, 41);
		botaoConcluir.addActionListener(new OuvinteBotaoConcluir());
		add(botaoConcluir);
	}

	private void botaoVoltar() {
		JButton botaoVoltar = new BotaoVoltar();
		botaoVoltar.setBounds(590, 220, 58, 22);
		botaoVoltar.addActionListener(new OuvinteBotaoVoltar());
		add(botaoVoltar);
	}
	
	private class OuvinteBotaoConcluir implements ActionListener {
		
		public void actionPerformed(ActionEvent e) {
			
			if(codigo.getText().equals(codigoGerado)) {
				try {
					CentralDeInformacoes cdi = getPersistencia().buscarCentral();
					if(usuario instanceof Passageiro) {
						cdi.adicionarUsuario((Passageiro)usuario);
						getPersistencia().salvarPersistencia(cdi);
					} else if(usuario instanceof Mototaxista) {
						cdi.adicionarUsuario((Mototaxista)usuario);
						getPersistencia().salvarPersistencia(cdi);
					}
					else if(usuario instanceof Administrador){
						cdi.adicionarUsuario((Administrador)usuario);
						getPersistencia().salvarPersistencia(cdi);
					}
					dispose();
					new JanelaLogin();
				} catch (Exception e2) {
					e2.printStackTrace();
				}
				
			} else
				codigo.setBorder(getBordaErro());
		}
	}
	
	private class OuvinteBotaoVoltar implements ActionListener {
		
		public void actionPerformed(ActionEvent e) {
			dispose();
			new JanelaLogin();
		}
		
	}
	
	private class OuvinteTeclasCodigo implements KeyListener{
		
		private String teclasEspeciais = "Caracteres permitidos: números";
		
		public void keyTyped(KeyEvent e) {
			char t = e.getKeyChar(); 
			
			if(!Character.isDigit(t))
				e.consume();
		}

		public void keyPressed(KeyEvent e) {}
		public void keyReleased(KeyEvent e) {}

		public String getTeclasEspeciais() {
			return teclasEspeciais;
		}
	}
}
