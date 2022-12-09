package mototaxista;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

import projeto_poo.Mototaxista;
import projeto_poo.Usuario;
import projeto_poo.diversos.TextoImagemPadrao;
import projeto_poo.janelas.JanelaPadrao;
import projeto_poo.paineis.PainelPrincipal;

public class JanelaPrincipalMototaxista extends JanelaPadrao{
	
	private PainelInicio inicio;
	private PainelListarCorridas listarCorridas;
	private PainelPerfil perfil;
	
	public JanelaPrincipalMototaxista(Usuario mototaxista) {
		super("Monteiro-motos - "+mototaxista.getNome()+" "+mototaxista.getSobrenome());
		add(inicio = new PainelInicio());
		add(listarCorridas = new PainelListarCorridas());
		add(perfil = new PainelPerfil());
		setVisible(true);
	}
	
	
	
	private class PainelInicio extends PainelPrincipal{
		public PainelInicio() {
			super();
			logo();
			botoes();
			add(getBotaoListarCorridas());
			add(getBotaoPerfil());
			add(getBarraInicio());
			add(getFundoInicio());
		}
		
		private void botoes() {
			getBotaoListarCorridas().addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
						inicio.setVisible(false);
						perfil.setVisible(false);
						listarCorridas.setVisible(true);
				}
			});
			getBotaoPerfil().addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
						listarCorridas.setVisible(false);
						inicio.setVisible(false);
						perfil.setVisible(true);
				}
			});
		}
		
		private void logo() {
			JLabel logo = new TextoImagemPadrao(new ImageIcon("imgs/mototaxista/bemvindo.png"));
			logo.setBounds(30, 30, 568, 32);
			add(logo);
		}
		
	}
	
	private class PainelListarCorridas extends PainelPrincipal {
		public PainelListarCorridas() {
			super();
			setVisible(false);
			logo();
			botoes();
			add(getBotaoInicio());
			add(getBotaoPerfil());
			add(getBarraListarCorridas());
			add(getFundoInicio());
		}
		
		private void botoes() {
			getBotaoInicio().addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
						listarCorridas.setVisible(false);
						perfil.setVisible(false);
						inicio.setVisible(true);
				}
			});
			getBotaoPerfil().addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
						listarCorridas.setVisible(false);
						inicio.setVisible(false);
						perfil.setVisible(true);
				}
			});
		}
		
		private void logo() {
			JLabel logo = new TextoImagemPadrao(new ImageIcon("imgs/mototaxista/corridasdisponiveis.png"));
			logo.setBounds(30, 21, 502, 40);
			add(logo);
		}
	}
	
	private class PainelPerfil extends PainelPrincipal{
		public PainelPerfil() {
			super();
			setVisible(false);
			logo();
			botoes();
			add(getBotaoInicio());
			add(getBotaoListarCorridas());
			add(getBarraPerfil());
			add(getFundoInicio());
		}
		
		private void botoes() {
			getBotaoInicio().addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
						listarCorridas.setVisible(false);
						perfil.setVisible(false);
						inicio.setVisible(true);
				}
			});
			getBotaoListarCorridas().addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
						inicio.setVisible(false);
						perfil.setVisible(false);
						listarCorridas.setVisible(true);
				}
			});
		}
		
		private void logo() {
			JLabel logo = new TextoImagemPadrao(new ImageIcon("imgs/editarperfil.png"));
			logo.setBounds(30, 30, 309, 31);
			add(logo);
		}
	}
}
