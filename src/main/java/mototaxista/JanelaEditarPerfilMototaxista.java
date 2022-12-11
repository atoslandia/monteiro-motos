package mototaxista;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import administrador.JanelaPrincipalAdministrador;
import projeto_poo.Administrador;
import projeto_poo.CentralDeInformacoes;
import projeto_poo.Mototaxista;
import projeto_poo.Usuario;
import projeto_poo.janelas.JanelaDeAvisoPadrao;
import projeto_poo.janelas.JanelaPadrao;
import projeto_poo.paineis.PainelEditarPerfil;

public class JanelaEditarPerfilMototaxista extends JanelaPadrao{
	
	private Usuario usuario;
	
	public JanelaEditarPerfilMototaxista(Usuario usuario) {
		super("Editar perfil");
		this.usuario = usuario;
		setVisible(true);
	}
	
	private class PainelEditar extends PainelEditarPerfil{
		public PainelEditar() {
			super(usuario);
			botoes();
		}
		private void botoes() {
			
			getConcluir().addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					try {
						usuario.setNome(getNome().pegarConteudo());
						usuario.setSobrenome(getSobrenome().pegarConteudo());
						usuario.setSenha(getSenha().pegarConteudo());
						usuario.setDataNascimento(getDataNascimento().pegarData());
						CentralDeInformacoes cdi = getPersistencia().buscarCentral();
						cdi.atualizarUsuario(usuario);
						getPersistencia().salvarPersistencia(cdi);
						dispose();
						new JanelaPrincipalMototaxista((Mototaxista)usuario);
						new JanelaDeAvisoPadrao("Usuário editado com sucesso!");
					}catch (Exception e2) {
					}
				}
			});
			getVoltar().addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					dispose();
					new JanelaPrincipalMototaxista((Mototaxista)usuario);
				}
			});
		}
	}
	
}
