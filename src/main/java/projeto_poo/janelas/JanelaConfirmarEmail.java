package projeto_poo.janelas;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Random;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextField;

import projeto_poo.Administrador;
import projeto_poo.CentralDeInformacoes;
import projeto_poo.Passageiro;
import projeto_poo.Pessoas;
import projeto_poo.Sexo;
import projeto_poo.componentes.CaixaTextoPadrao;
import projeto_poo.componentes.TextoImagemPadrao;
import projeto_poo.ouvintes.OuvinteTeclasBloqueadas;

public class JanelaConfirmarEmail extends JanelaPadrao{
	
	public JanelaConfirmarEmail(String codigoGerado, Pessoas pessoa) {
		super("Confirmar e-mail");
		
		botaoConcluir();
		botaoVoltar();
		
		this.codigoGerado = codigoGerado;
		
		this.pessoa = pessoa;
		
		caixaCodigo();
		descricao();
		add(getFundoPadrao());
		logoConfirmarEmail();
		setVisible(true);
	}
	
	private JTextField codigo;
	private String codigoGerado;
	
	private Pessoas pessoa;
	
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
		JButton botaoConcluir = getBotaoConcluir();
		botaoConcluir.setBounds(530, 170, 170, 41);
		botaoConcluir.addActionListener(new OuvinteBotaoConcluir());
		add(botaoConcluir);
	}

	private void botaoVoltar() {
		JButton botaoVoltar = getBotaoVoltar();
		botaoVoltar.setBounds(590, 220, 58, 22);
		botaoVoltar.addActionListener(new OuvinteBotaoVoltar());
		add(botaoVoltar);
	}
	
	private class OuvinteBotaoConcluir implements ActionListener {
		
		
		public void actionPerformed(ActionEvent e) {
			
			if(codigo.getText().equals(codigoGerado)) {
				try {
					CentralDeInformacoes cdi = getPersistencia().buscarCentral();
					if(pessoa instanceof Administrador) {
						System.out.println("foi criado um administrador");
						cdi.setAdministrador((Administrador)pessoa);
						getPersistencia().salvarPersistencia(cdi);
					}
					else if(pessoa instanceof Passageiro) {
						System.out.println("foi criado um passageiro");
						cdi.adicionarPassageiro((Passageiro)pessoa);
						getPersistencia().salvarPersistencia(cdi);
					}
					dispose();
					new JanelaLogin();
				} catch (Exception e2) {
					System.out.println("erro ao inserir codigo "+e2);
				}
				
			} else
				codigo.setBorder(getBordaErro());
		}
	}
	
	private class OuvinteBotaoVoltar implements ActionListener {
		
		public void actionPerformed(ActionEvent e) {
			dispose();
			new PrimeiroAcesso();
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
