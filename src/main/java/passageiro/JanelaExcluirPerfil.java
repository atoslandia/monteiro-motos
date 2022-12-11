package passageiro;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;

import projeto_poo.CentralDeInformacoes;
import projeto_poo.Passageiro;
import projeto_poo.botoes.BotaoProsseguir;
import projeto_poo.botoes.BotaoVoltar;
import projeto_poo.diversos.TextoImagemPadrao;
import projeto_poo.janelas.JanelaLogin;
import projeto_poo.janelas.JanelaPadrao;

public class JanelaExcluirPerfil extends JanelaPadrao{
	private Passageiro passageiro;
	
	public JanelaExcluirPerfil(Passageiro passageiro) {
		super("Excluir perfil");
		this.passageiro = passageiro;
		add(getFundoPadrao());
		mensagem();
		botoes();
		setVisible(true);
	}
	
	private void mensagem() {
		TextoImagemPadrao logo = new TextoImagemPadrao( new ImageIcon("imgs/excluirperfil.png"));
		logo.setBounds(30, 30, 336, 32);
		TextoImagemPadrao txtConfirmacao = new TextoImagemPadrao("Tem certeza que deseja excluir seu perfil permanentemente?");
		txtConfirmacao.setBounds(30, 92, 350, 30);
		add(txtConfirmacao);
		add(logo);
	}
	
	private void botoes() {
		BotaoProsseguir  botaoProsseguir = new BotaoProsseguir();
		botaoProsseguir.addActionListener( new OuvinteProsseguir());
		
		BotaoVoltar botaoVoltar = new BotaoVoltar();
		botaoVoltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				new JanelaPrincipalPassageiro(passageiro);
			}
		});
		add(botaoVoltar);
		add(botaoProsseguir);
	}

	
	private class OuvinteProsseguir implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			try {
				CentralDeInformacoes cdi = getPersistencia().buscarCentral();
				cdi.removerUsuario(passageiro);
				getPersistencia().salvarPersistencia(cdi);
				dispose();
				new JanelaLogin();
			} catch (Exception e1) {
				e1.printStackTrace();
			}
		}
		
	}
}






