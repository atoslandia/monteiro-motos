package administrador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

import projeto_poo.Administrador;
import projeto_poo.Sexo;
import projeto_poo.Usuario;
import projeto_poo.botoes.BotaoListarCorridas;
import projeto_poo.botoes.BotaoOpcoes;
import projeto_poo.botoes.BotaoPadrao;
import projeto_poo.diversos.TextoImagemPadrao;
import projeto_poo.janelas.JanelaPadrao;
import projeto_poo.paineis.PainelPrincipal;

public class JanelaPrincipalAdministrador extends JanelaPadrao{

	private Administrador administrador;
	
	private PainelInicio inicio;
	private PainelListarCorridas listarCorridas;
	private PainelPerfil perfil;
	
	public JanelaPrincipalAdministrador(Administrador administrador) {
		super("Monteiro-motos - "+administrador.getNome()+" "+administrador.getSobrenome());
		this.administrador = administrador;
		add(inicio = new PainelInicio());
		add(listarCorridas = new PainelListarCorridas());
		add(perfil = new PainelPerfil());
		setVisible(true);
	}
	
	private class PainelInicio extends PainelPrincipal{
		public PainelInicio() {
			super();
			opcoes();
			logo();
			botoesBarra();
			add(getBotaoListarCorridas());
			add(getBotaoPerfil());
			add(getBarraInicio());
			add(getFundoInicio());
		}
		
		private void opcoes() {
			BotaoOpcoes listarTodosUsuarios = new BotaoOpcoes("LISTAR TODOS OS USUÁRIOS");
			listarTodosUsuarios.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					dispose();
					new JanelaTodosUsuarios(administrador);
				}
			});
			add(listarTodosUsuarios);
			
			BotaoOpcoes valorCreditos = new BotaoOpcoes("VALOR DE CRÉDITO REINVIDICADO");
			valorCreditos.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					dispose();
					new JanelaValorCreditoReinvidicacao(administrador);
				}
			});
			valorCreditos.setLocation(30, 140);
			add(valorCreditos);
			
			BotaoOpcoes manterCaixa = new BotaoOpcoes("MANTER CAIXA");
			manterCaixa.setLocation(30, 190);
			add(manterCaixa);
			
		}
		
		private void botoesBarra() {
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
			JLabel logo = new TextoImagemPadrao(new ImageIcon("imgs/administrador/bemvindo.png"));
			logo.setBounds(30, 30, 635, 32);
			add(logo);
		}
		
	}
	
	private class PainelListarCorridas extends PainelPrincipal {
		public PainelListarCorridas() {
			super();
			setVisible(false);
			logo();
			botoesBarra();
			todasAsCorridas();
			add(getBotaoInicio());
			add(getBotaoPerfil());
			add(getBarraListarCorridas());
			add(getFundoInicio());
		}
		
		private void todasAsCorridas() {
			
		}
		
		private void botoesBarra() {
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
			JLabel logo = new TextoImagemPadrao(new ImageIcon("imgs/administrador/todasascorridas.png"));
			logo.setBounds(30, 30, 434, 31);
			add(logo);
		}
	}
	
	private class PainelPerfil extends PainelPrincipal{
		public PainelPerfil() {
			super();
			setVisible(false);
			logo();
			botoesBarra();
			opcoes();
			add(getBotaoInicio());
			add(getBotaoListarCorridas());
			add(getBarraPerfil());
			add(getFundoInicio());
		}
		
		private void opcoes() {
			BotaoOpcoes editarPerfil = new BotaoOpcoes("EDITAR PERFIL");
			editarPerfil.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					dispose();
					new JanelaEditarPerfilAdministrador(administrador);
				}
			});
			add(editarPerfil);
		}
		
		private void botoesBarra() {
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
