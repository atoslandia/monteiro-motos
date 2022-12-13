package mototaxista;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import projeto_poo.Corrida;
import projeto_poo.Mensageiro;
import projeto_poo.Mototaxista;
import projeto_poo.Usuario;
import projeto_poo.botoes.BotaoEspecial;
import projeto_poo.botoes.BotaoOpcoes;
import projeto_poo.diversos.TextoImagemPadrao;
import projeto_poo.erros.SemCreditosException;
import projeto_poo.janelas.JanelaDeAvisoPadrao;
import projeto_poo.janelas.JanelaPadrao;
import projeto_poo.paineis.PainelPrincipal;

public class JanelaPrincipalMototaxista extends JanelaPadrao{
	
	private PainelInicio inicio;
	private PainelListarCorridas listarCorridas;
	private PainelPerfil perfil;
	
	private Mototaxista mototaxista;
	
	public JanelaPrincipalMototaxista(Mototaxista mototaxista) {
		super("Monteiro-motos - "+mototaxista.getNome()+" "+mototaxista.getSobrenome());
		this.mototaxista = mototaxista;
		add(inicio = new PainelInicio());
		add(listarCorridas = new PainelListarCorridas());
		add(perfil = new PainelPerfil());
		setVisible(true);
	}
	
	private class PainelInicio extends PainelPrincipal{
		public PainelInicio() {
			super();
			totalCreditos();
			logo();
			botoes();
			add(getBotaoListarCorridas());
			add(getBotaoPerfil());
			add(getBarraInicio());
			add(getFundoInicio());
		}
		
		private void totalCreditos() {
			TextoImagemPadrao textoTotalCreditos;
			try {
				textoTotalCreditos = new TextoImagemPadrao("Creditos de reinvidicação: "+mototaxista.getCreditos());
				textoTotalCreditos.setBounds(30, 67, 200, 20);
				add(textoTotalCreditos);
			} catch (SemCreditosException e) {
				e.printStackTrace();
			}
		}
		
		private void botoes() {
			
			BotaoOpcoes comprarCreditos = new BotaoOpcoes("COMPRAR CRÉDITOS DE REINVIDICAÇÃO");
			comprarCreditos.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					dispose();
					new JanelaComprarCreditosDeReinvidicacao(mototaxista);
				}
			});
			add(comprarCreditos);
			
			
			
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
		
		private DefaultTableModel modelo;
		private JTable tabela;
		private JScrollPane scroll;
		
		public PainelListarCorridas() {
			super();
			gerarLista();
			logo();
			botoes();
			add(getBotaoInicio());
			add(getBotaoPerfil());
			add(getBarraListarCorridas());
			add(getFundoInicio());
			setVisible(false);
		}
		
		private void gerarLista() {
			try {
				modelo = new DefaultTableModel();
				modelo.addColumn("Endereço");
				modelo.addColumn("Data");
				int numero = 1;
				ArrayList<Corrida> corridasEmEspera = new ArrayList<>();
				for(Corrida c: getPersistencia().buscarCentral().getTodasAsCorridas()) {
					if(c.getEstadoDaCorrida().equals("Em espera")) {
						corridasEmEspera.add(c);
					}
					Object[] linha = new Object[2];
					if(c.getEstadoDaCorrida().equals("Em espera")) {
						linha[0] = "corrida "+numero++;
						linha[1] = "##/##/##";
					}
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
		
		private void botoes() {
			
			BotaoEspecial reinvidicar = new BotaoEspecial("REINVIDICAR");
			reinvidicar.setLocation(520,170);
			reinvidicar.addActionListener(new ActionListener() {
				
				public void actionPerformed(ActionEvent e) {
					try {
						mototaxista.setCreditos(mototaxista.getCreditos()-1);
						new JanelaCorridaReinvidicada(mototaxista, getPersistencia().buscarCentral().getTodasAsCorridas().get(tabela.getSelectedRow()));
						Mensageiro.enviarCodigoEmail(getPersistencia().buscarCentral().getTodasAsCorridas().get(tabela.getSelectedRow()).getPassageiro().getEmail(), "STATUS DA CORRIDA", mototaxista.getNome()+" "+mototaxista.getSobrenome()+" está indo para o ponto de encontro definido, Aguarde.");
						dispose();
					} catch (SemCreditosException e1) {
						new JanelaDeAvisoPadrao("Você não possui créditos de reinvidicação");
					} catch (Exception e1) {
						e1.printStackTrace();
					}
				}
			}
			);
			add(reinvidicar);
			
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
			
			BotaoOpcoes editarPerfil = new BotaoOpcoes("EDITAR PERFIL");
			editarPerfil.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					dispose();
					new JanelaEditarPerfilMototaxista(mototaxista);
				}
			});
			add(editarPerfil);
			
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
