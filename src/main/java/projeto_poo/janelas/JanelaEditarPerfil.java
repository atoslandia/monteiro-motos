package projeto_poo.janelas;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import administrador.JanelaPrincipalAdministrador;
import projeto_poo.Administrador;
import projeto_poo.CentralDeInformacoes;
import projeto_poo.Usuario;
import projeto_poo.botoes.BotaoConcluir;
import projeto_poo.botoes.BotaoVoltar;
import projeto_poo.paineis.PainelEditarPerfil;

public class JanelaEditarPerfil extends JanelaPadrao{
	
	private Usuario usuario;
	private EditarPerfil painelEditarPerfil;
	
	public JanelaEditarPerfil(Usuario usuario) {
		super("Editar perfil");
		this.usuario = usuario;
		add(painelEditarPerfil = new EditarPerfil());
		setVisible(true);
	}
	
	private class EditarPerfil extends PainelEditarPerfil{
		public EditarPerfil() {
			super(usuario);
			botoes();
			add(getFundoPadrao());
		}
		
		private void botoes() {
			
			BotaoConcluir concluir = new BotaoConcluir();
			concluir.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					try {
						usuario.setNome(getNome().pegarConteudo());
						usuario.setSobrenome(getSobrenome().pegarConteudo());
						usuario.setEmail(getEmail().pegarConteudo());
						usuario.setSenha(getSenha().pegarConteudo());
						usuario.setDataNascimento(getDataNascimento().pegarData());
						CentralDeInformacoes cdi = getPersistencia().buscarCentral();
						cdi.atualizarUsuario(usuario);
						getPersistencia().salvarPersistencia(cdi);
						dispose();
						new JanelaPrincipalAdministrador((Administrador)usuario);
						new JanelaDeAvisoPadrao("Usuário editado com sucesso!");
					} catch (Exception e1) {
						e1.printStackTrace();
				}
			}
			});
			add(concluir);
			
			BotaoVoltar voltar = new BotaoVoltar();
			voltar.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					dispose();
					new JanelaPrincipalAdministrador((Administrador)usuario);
				}
			});
			add(voltar);
			
		}
		
	}
	
}
