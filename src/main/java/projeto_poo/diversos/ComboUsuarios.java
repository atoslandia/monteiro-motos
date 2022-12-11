package projeto_poo.diversos;

import java.awt.Font;

import javax.swing.JComboBox;
import javax.swing.JLabel;

import administrador.JanelaPrincipalAdministrador;
import mototaxista.JanelaPrincipalMototaxista;
import passageiro.JanelaPrincipalPassageiro;
import projeto_poo.Administrador;
import projeto_poo.Mototaxista;
import projeto_poo.Passageiro;
import projeto_poo.Usuario;
import projeto_poo.erros.UsuarioNaoExisteException;
import projeto_poo.janelas.JanelaDeAvisoPadrao;
import projeto_poo.janelas.JanelaLogin;

public class ComboUsuarios extends JComboBox<String>{

	private JanelaLogin janela;
	
	public ComboUsuarios(JanelaLogin janela) {
		this.janela = janela;
		setFont(new Font("Calibrii", Font.PLAIN, 10));
		setBounds(120, 220, 200, 20);
		addItem("Passageiro");
		addItem("Mototaxista");
		addItem("Administrador");
	}

	public void tipoSelecionado(Usuario usuario) throws UsuarioNaoExisteException {
				
		String selecionado = (String) getSelectedItem();
		
		switch (selecionado) {
		case "Administrador":
			if(usuario instanceof Administrador) {
				janela.dispose();
				new JanelaPrincipalAdministrador((Administrador)usuario);
			}else
				new JanelaDeAvisoPadrao("Usuário não encontrado");
			break;
		case "Passageiro":
			if(usuario instanceof Passageiro) {
				janela.dispose();
				new JanelaPrincipalPassageiro((Passageiro)usuario);
			}else
				new JanelaDeAvisoPadrao("Usuário não encontrado");
			break;
		case "Mototaxista":
			if(usuario instanceof Mototaxista) {
				janela.dispose();
				new JanelaPrincipalMototaxista((Mototaxista)usuario);
			}else
				new JanelaDeAvisoPadrao("Usuário não encontrado");
			break;
		}
	}
}
