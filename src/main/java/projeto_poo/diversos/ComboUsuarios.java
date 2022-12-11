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

public class ComboUsuarios extends JComboBox<String>{

	public ComboUsuarios() {
		setFont(new Font("Calibrii", Font.PLAIN, 10));
		setBounds(120, 220, 200, 20);
		addItem("Passageiro");
		addItem("Mototaxista");
		addItem("Administrador");
	}

	public void tipoSelecionado(Usuario usuario) throws UsuarioNaoExisteException {
		if(getSelectedItem().equals("Administrador") && usuario instanceof Administrador)
			new JanelaPrincipalAdministrador((Administrador)usuario);
		if(getSelectedItem().equals("Passageiro") && usuario instanceof Passageiro)
			new JanelaPrincipalPassageiro(usuario);
		if(getSelectedItem().equals("Mototaxista") && usuario instanceof Mototaxista)
			new JanelaPrincipalMototaxista(usuario);
	}
}
