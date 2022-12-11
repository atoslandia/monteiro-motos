package passageiro;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import projeto_poo.CentralDeInformacoes;
import projeto_poo.Passageiro;
import projeto_poo.Usuario;
import projeto_poo.botoes.BotaoConcluir;
import projeto_poo.botoes.BotaoVoltar;
import projeto_poo.erros.CaixaVaziaException;
import projeto_poo.janelas.JanelaDeAvisoPadrao;
import projeto_poo.janelas.JanelaPadrao;
import projeto_poo.paineis.PainelEditarPerfil;

public class JanelaEditarPerfil extends JanelaPadrao{
	
	private Passageiro passageiro;
	
	public JanelaEditarPerfil(Passageiro passageiro) {
		super("Editar perfil");
		this.passageiro = passageiro;
		add(new PainelEditar());
		setVisible(true);
		
	}
	
	private class PainelEditar extends PainelEditarPerfil{

		public PainelEditar() {
			super(passageiro);
			add(getFundoPadrao());
			botaoConcluir();
			botaoVoltar();
		}
		
		private void botaoConcluir(){
			BotaoConcluir botao = getConcluir();
			botao.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					try {
						passageiro.setNome(getNome().pegarConteudo());
						passageiro.setSobrenome(getSobrenome().pegarConteudo());
						passageiro.setEmail(getEmail().pegarConteudo());
						passageiro.setSenha(getSenha().pegarConteudo());
						passageiro.setDataNascimento(getDataNascimento().pegarData());
						CentralDeInformacoes cdi = getPersistencia().buscarCentral();
						cdi.atualizarUsuario(passageiro);
						getPersistencia().salvarPersistencia(cdi);
						dispose();
						new JanelaPrincipalPassageiro(passageiro);
						new JanelaDeAvisoPadrao("Usuário editado com sucesso!");
					} catch (CaixaVaziaException e1) {
						e1.printStackTrace();
					} catch (Exception e1) {
						e1.printStackTrace();
					}
				}
			});
			add(botao);
		}
		private void botaoVoltar() {
			BotaoVoltar botao = getVoltar();
			botao.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					dispose();
					new JanelaPrincipalPassageiro(passageiro);
				}
			});
			add(botao);
		}
		
		
	}
	

}
