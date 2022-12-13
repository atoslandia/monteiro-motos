package mototaxista;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;

import projeto_poo.CentralDeInformacoes;
import projeto_poo.Corrida;
import projeto_poo.Mototaxista;
import projeto_poo.Usuario;
import projeto_poo.botoes.BotaoConcluir;
import projeto_poo.diversos.TextoImagemPadrao;
import projeto_poo.janelas.JanelaDeAvisoPadrao;
import projeto_poo.janelas.JanelaPadrao;

public class JanelaCorridaReinvidicada extends JanelaPadrao{
	
	private Usuario mototaxista;
	private Corrida corrida;
	
	public JanelaCorridaReinvidicada(Usuario mototaxista, Corrida corrida) {
		super("Corrida em andamento");
		this.mototaxista = mototaxista;
		this.corrida = corrida;
		informacoesCorrida();
		botoes();
		logo();
		add(getFundoPadrao());
		setVisible(true);
	}
	
	private void informacoesCorrida() {
		TextoImagemPadrao texto = new TextoImagemPadrao(corrida.toString());
		texto.setBounds(30, 60, 300, 200);
		add(texto);
	}
	
	private void botoes() {
		BotaoConcluir concluir = new BotaoConcluir();
		concluir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					corrida.setEstadoDaCorrida("Reinvidicada");
					CentralDeInformacoes cdi = getPersistencia().buscarCentral();
					cdi.atualizarCorrida(corrida);
					getPersistencia().salvarPersistencia(cdi);
					dispose();
					new JanelaDeAvisoPadrao("Corrida concluída com sucesso!", new JanelaPrincipalMototaxista((Mototaxista)mototaxista));
				} catch (Exception e1) {
					e1.printStackTrace();
				}
			}
		});
		add(concluir);
	}
	
	private void logo() {
		TextoImagemPadrao logo = new TextoImagemPadrao(new ImageIcon("imgs/administrador/detalhesdousuario.png"));
		logo.setBounds(30, 21, 502, 41);
		add(logo);
	}
	
}
