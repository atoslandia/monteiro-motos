package passageiro;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import projeto_poo.Corrida;
import projeto_poo.Passageiro;
import projeto_poo.botoes.BotaoOpcoes;
import projeto_poo.diversos.TextoImagemPadrao;
import projeto_poo.erros.CorridaEmEsperaException;
import projeto_poo.erros.CorridaReinvidicadaException;
import projeto_poo.janelas.JanelaPadrao;
import projeto_poo.paineis.PainelPrincipal;

public class JanelaPrincipalPassageiro extends JanelaPadrao{

	private PainelInicio inicio;
	private PainelListarCorridas listarCorridas;
	private PainelPerfil perfil;
	private Passageiro passageiro;
	
	public JanelaPrincipalPassageiro(Passageiro passageiro) {
		super("Monteiro-motos - "+passageiro.getNome()+" "+passageiro.getSobrenome());
		this.passageiro = (Passageiro) passageiro;
		add(inicio = new PainelInicio());
		add(listarCorridas = new PainelListarCorridas());
		add(perfil = new PainelPerfil());
		setVisible(true);
		verificarCorridaAceita();
	}
	
	private void verificarCorridaAceita() {
		Corrida corrida = null;
		try {
			for(Corrida c: getPersistencia().buscarCentral().recuperarCorridasDeUmPassageiro(passageiro.getEmail())) {
				corrida = c;
				corrida.getEstadoDaCorrida();
				System.out.println("meu estado: "+corrida.getEstadoDaCorrida());
			}
			System.out.println("estou realmente sendo verificado?");
		} catch (CorridaReinvidicadaException e) {
			new JanelaCorridaConcluida(corrida);
			dispose();
		} catch (CorridaEmEsperaException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
			
	}
	
	private class PainelInicio extends PainelPrincipal{
		public PainelInicio() {
			super();
			logo();
			botoesBarra();
			botaoOpcoes();
			add(getBotaoListarCorridas());
			add(getBotaoPerfil());
			add(getBarraInicio());
			add(getFundoInicio());
		}
		
		private void botaoOpcoes() {
			BotaoOpcoes iniciarCorrida = new BotaoOpcoes("INICIAR CORRIDA");
			iniciarCorrida.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					dispose();
					new JanelaSolicitarCorrida(passageiro);
				}
			});
			add(iniciarCorrida);
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
			JLabel logo = new TextoImagemPadrao(new ImageIcon("imgs/passageiro/bemvindo.png"));
			logo.setBounds(30, 30, 536, 32);
			add(logo);
		}
		
	}
	
	private class PainelListarCorridas extends PainelPrincipal {
		
		private DefaultTableModel modelo;
		private JTable tabela;
		private JScrollPane scroll;
		
		
		public PainelListarCorridas() {
			super();
			listaCorridas();
			logo();
			botoesBarra();
			add(getBotaoInicio());
			add(getBotaoPerfil());
			add(getBarraListarCorridas());
			add(getFundoInicio());
			setVisible(false);
		}
		
		private void listaCorridas() {
			try {
				modelo = new DefaultTableModel();
				modelo.addColumn("Endereço");
				modelo.addColumn("Status");
				for(Corrida c: getPersistencia().buscarCentral().recuperarCorridasDeUmPassageiro(passageiro.getEmail())) {
					Object[] linha = new Object[2];
					linha[0] = c.getDestino().getEndereco();
					linha[1] = c.getEstadoDaCorrida();
					modelo.addRow(linha);
				}
				tabela = new JTable(modelo);
				tabela.setBackground(new Color(202,202,202));
				tabela.setDragEnabled(false);
				tabela.setRowHeight(25);
				scroll = new JScrollPane(tabela);
				scroll.setBounds(30, 70, 480, 230);
				add(scroll);
				} catch (Exception e) {
					e.printStackTrace();
			}
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
			JLabel logo = new TextoImagemPadrao(new ImageIcon("imgs/passageiro/suascorridas.png"));
			logo.setBounds(30, 30, 338, 32);
			add(logo);
		}
	}
	
	private class PainelPerfil extends PainelPrincipal{
		public PainelPerfil() {
			super();
			setVisible(false);
			logo();
			botoesBarra();
			add(getBotaoInicio());
			add(getBotaoListarCorridas());
			add(getBarraPerfil());
			add(getFundoInicio());
			botaoOpcoes();
		}
		
		private void botaoOpcoes() {
			BotaoOpcoes editarPerfil = new BotaoOpcoes("EDITAR PERFIL");
			editarPerfil.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					dispose();
					new JanelaEditarPerfil(passageiro);
				}
			});
			BotaoOpcoes excluirPerfil = new BotaoOpcoes("EXCLUIR PERFIL");
			excluirPerfil.setLocation(30, 135);
			excluirPerfil.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					dispose();
					new JanelaExcluirPerfil(passageiro);
				}
			});
			
			add(excluirPerfil);
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
