package administrador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import projeto_poo.Administrador;
import projeto_poo.CentralDeInformacoes;
import projeto_poo.Usuario;
import projeto_poo.janelas.JanelaDeAvisoPadrao;
import projeto_poo.janelas.JanelaPadrao;
import projeto_poo.paineis.PainelEditarPerfil;

public class JanelaEditarPerfilAdministrador extends JanelaPadrao{
	
	private Usuario usuario;
	private PainelEditar painelEditar;
	
	public JanelaEditarPerfilAdministrador(Usuario usuario) {
		super("Editar perfil");
		this.usuario = usuario;
		add(painelEditar = new PainelEditar());
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
						new JanelaPrincipalAdministrador((Administrador)usuario);
						new JanelaDeAvisoPadrao("Usuário editado com sucesso!");
					}catch (Exception e2) {
					}
				}
			});
			getVoltar().addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					dispose();
					new JanelaPrincipalAdministrador((Administrador)usuario);
				}
			});
		}
	}
	
	
}
