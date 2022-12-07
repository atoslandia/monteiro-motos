package projeto_poo.janelas;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPasswordField;

import projeto_poo.Usuario;
import projeto_poo.componentes.CaixaSenha;
import projeto_poo.componentes.TextoImagemPadrao;

public class JanelaAlterarSenha extends JanelaPadrao{
	
	private JPasswordField senha;
	private Usuario usuario;
	
	public JanelaAlterarSenha(Usuario usuario) {
		super("Alterar senha");
		
		this.usuario = usuario;
		
		novaSenha();
		botoes();
		logo();
		
		add(getFundoPadrao());
		setVisible(true);
	}
	
	private void logo() {
		JLabel logo = new TextoImagemPadrao(new ImageIcon("imgs/esqueciminhasenha.png"));
		logo.setBounds(30, 30, 503, 37);
		add(logo);
	}
	
	private void botoes() {
		JButton botaoConcluir = getBotaoConcluir();
		botaoConcluir.setBounds(500, 155, 170, 41);
		botaoConcluir.addActionListener(new OuvinteBotaoConcluir());
		add(botaoConcluir);
	}
	
	private void novaSenha() {
		TextoImagemPadrao textoEmail = new TextoImagemPadrao("Nova senha: ");
        textoEmail.setBounds(30, 120, 100, 20);
        add(textoEmail);
        
        senha = new CaixaSenha();
        senha.setBounds(120, 120, 200, 20);
        add(senha);
	}
	
	private class OuvinteBotaoConcluir implements ActionListener{
		public void actionPerformed(ActionEvent e) {
//			if(!new String(senha.getPassword()).equals(""))
				
		}
	}
	
}
