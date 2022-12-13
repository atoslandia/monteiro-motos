package administrador;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.time.LocalDate;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.border.Border;
import javax.swing.table.DefaultTableModel;

import projeto_poo.Administrador;
import projeto_poo.CentralDeInformacoes;
import projeto_poo.Corrida;
import projeto_poo.Mensageiro;
import projeto_poo.Mototaxista;
import projeto_poo.Passageiro;
import projeto_poo.Sexo;
import projeto_poo.Usuario;
import projeto_poo.botoes.BotaoConcluir;
import projeto_poo.botoes.BotaoDetalhar;
import projeto_poo.botoes.BotaoEspecial;
import projeto_poo.botoes.BotaoOpcoes;
import projeto_poo.botoes.BotaoVoltar;
import projeto_poo.caixas.CaixaEmail;
import projeto_poo.caixas.CaixaNomeSobrenome;
import projeto_poo.caixas.CaixaTextoPadrao;
import projeto_poo.diversos.ComboFiltroTodosUsuarios;
import projeto_poo.diversos.TabelaUsuarios;
import projeto_poo.diversos.TextoImagemPadrao;
import projeto_poo.erros.CaixaVaziaException;
import projeto_poo.erros.NaoExisteXmlException;
import projeto_poo.erros.UsuarioNaoExisteException;
import projeto_poo.janelas.JanelaDeAvisoPadrao;
import projeto_poo.janelas.JanelaPadrao;
import projeto_poo.paineis.PainelEditarPerfil;
import projeto_poo.paineis.PainelEntradas;
import projeto_poo.paineis.PainelPadrao;

public class JanelaTodosUsuarios extends JanelaPadrao{
	
	private PainelDetalhe painelDetalhe;
	private ListaTodosUsuarios painelListaTodosUsuarios;
	private EnviarEmail painelEnviarEmail;
	private EditarPerfil editarPerfil;
	
	private ComboFiltroTodosUsuarios filtro;
	
	private CaixaNomeSobrenome filtroTexto;
	private ArrayList<Usuario> listaFiltrada = new ArrayList<>();
	private ArrayList<Usuario> lista = new ArrayList<>();
	
	private JScrollPane scroll;
	private JTable tabela;
	private DefaultTableModel modelo;
	
	private Administrador administrador;
	
	public JanelaTodosUsuarios(Administrador administrador) {
		super("Lista de todos os usuários");
		gerarLista();
		this.administrador = administrador;
		add(painelListaTodosUsuarios = new ListaTodosUsuarios());
		setVisible(true);
	}
	
	/* PAINEL LISTA */
	
	private void gerarLista() {
		try {
			lista = getPersistencia().buscarCentral().getTodosOsUsuarios();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	private class ListaTodosUsuarios extends PainelPadrao{
		
		public ListaTodosUsuarios() {
			gerarTabela();
			botoes();
			logo();
			add(getFundoPadrao());
		}
		
		private void gerarTabela() {
			
			TextoImagemPadrao texto = new TextoImagemPadrao("Filtros: ");
			texto.setBounds(30, 85, 50, 20);
			add(texto);
			
			filtro = new ComboFiltroTodosUsuarios();
			filtro.addActionListener(new OuvinteComboFiltro());
			add(filtro);
				
			filtroTexto = new CaixaNomeSobrenome();
			filtroTexto.addKeyListener(new OuvinteTextoFiltro());
			filtroTexto.setBounds(280, 85, 230, 20);
			
			modelo = new DefaultTableModel();
			modelo.addColumn("Nome");
			modelo.addColumn("Tipo de conta");
			for(Usuario u: lista) {
				Object[] linha = new Object[2];
				linha[0] = u.getNome()+" "+u.getSobrenome();
				listaFiltrada.add(u);
				if(u instanceof Passageiro)
					linha[1] = "Passageiro";
				if(u instanceof Mototaxista)
					linha[1] = "Mototaxista";
				modelo.addRow(linha);
			}
			add(filtroTexto);
			
			tabela = new JTable(modelo);
			tabela.setBackground(new Color(202,202,202));
			tabela.setDragEnabled(false);
			tabela.setRowHeight(25);
			scroll = new JScrollPane(tabela);
			scroll.setBounds(30, 120, 480, 230);
			scroll.repaint();
			add(scroll);
		}
		
		private void botoes() {
			BotaoDetalhar detalhar = new BotaoDetalhar();
			detalhar.addActionListener(new OuvinteBotaoDetalhar());
			add(detalhar);
			BotaoVoltar voltar = new BotaoVoltar();
			voltar.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					dispose();
					new JanelaPrincipalAdministrador(administrador);
				}
			});
			add(voltar);
		}
		
		private void logo() {
			JLabel logo = new TextoImagemPadrao(new ImageIcon("imgs/administrador/todososusuarios.png"));
			logo.setBounds(30, 21, 451, 40);
			add(logo);
		}
	}
	
	/* PAINEL DETALHE */
	
	private class PainelDetalhe extends PainelPadrao{
		
		private Usuario usuario;
		
		public PainelDetalhe(Usuario usuario) {
			this.usuario = usuario;
			botoes();
			detalhes();
			logo();
			add(getFundoPadrao());
			setVisible(true);
		}
		
		private void botoes() {
			BotaoEspecial enviarEmail = new BotaoEspecial("ENVIAR EMAIL");
			enviarEmail.addActionListener(new OuvinteEnviarEmail());
			add(enviarEmail);
			
			BotaoEspecial editarPerfil = new BotaoEspecial("EDITAR PERFIL");
			editarPerfil.setLocation(510, 170);
			editarPerfil.addActionListener(new OuvinteEditarPerfil());
			add(editarPerfil);
			
			BotaoVoltar voltar = new BotaoVoltar();
			voltar.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					painelListaTodosUsuarios.setVisible(true);
					setVisible(false);
				}
			});
			add(voltar);
		}
		
		private void detalhes() {
			TextoImagemPadrao detalhes = new TextoImagemPadrao(usuario.toString());
			detalhes.setBounds(30, 60, 300, 200);
			add(detalhes);
		}
		
		private void logo() {
			JLabel logo = new TextoImagemPadrao(new ImageIcon("imgs/administrador/detalhesdousuario.png"));
			logo.setBounds(30, 21, 502, 41);
			add(logo);
		}
	}
	
	private class EnviarEmail extends PainelPadrao{
		
		private CaixaTextoPadrao assunto;
		private JTextArea corpo;
		
		public EnviarEmail(Usuario usuario) {
			logo();
			botoes();
			caixasTextos();
			add(getFundoPadrao());
		}
		
		private void logo() {
			JLabel logo = new TextoImagemPadrao(new ImageIcon("imgs/administrador/enviaremail.png"));
			logo.setBounds(30, 30, 328, 31);
			add(logo);
		}
		
		private void botoes() {
			
			BotaoConcluir concluir = new BotaoConcluir();
			concluir.addActionListener(new ActionListener() {
				
				public void actionPerformed(ActionEvent e) {
					try {
						Mensageiro.enviarCodigoEmail(listaFiltrada.get(tabela.getSelectedRow()).getEmail(), assunto.getText(), corpo.getText());
						new JanelaDeAvisoPadrao("E-mail enviado com sucesso!");
						setVisible(false);
						painelDetalhe.setVisible(true);
					} catch (Exception e1) {
						e1.printStackTrace();
					}
				}
			});
			add(concluir);
			
			BotaoVoltar voltar = new BotaoVoltar();
			voltar.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					painelDetalhe.setVisible(true);
					setVisible(false);
				}
			});
			add(voltar);
		}
		
		private void caixasTextos() {
			JLabel textoAssunto = new TextoImagemPadrao("Assunto: ");
			textoAssunto.setBounds(30, 90, 80, 20);
	        add(textoAssunto);
	        
	        assunto = new CaixaTextoPadrao();
	        assunto.setBounds(100, 90, 340, 20);
	        add(assunto);
	        
	        JLabel textoCorpo = new TextoImagemPadrao("Corpo: ");
	        textoCorpo.setBounds(30, 120, 80, 20);
	        add(textoCorpo);
	        
	        corpo = new JTextArea();
	        corpo.setBounds(100, 120, 340, 200);
	        corpo.setBorder(BorderFactory.createMatteBorder(1,1,1,1, Color.BLACK));
	        corpo.setLineWrap(true);
	        add(corpo);
		}
		
	}
	
	private class EditarPerfil extends PainelEditarPerfil{
		
		private Usuario usuario;
		
		public EditarPerfil(Usuario usuario) {
			super(usuario);
			this.usuario = usuario;
			botoes();
			add(getFundoPadrao());
		}
		
		private void botoes() {
			BotaoConcluir concluir = new BotaoConcluir();
			concluir.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					try {
						System.out.println("Fui apertado!");
						usuario.setNome(getNome().pegarConteudo());
						usuario.setSobrenome(getSobrenome().pegarConteudo());
						usuario.setSenha(getSenha().pegarConteudo());
						usuario.setDataNascimento(getDataNascimento().pegarData());
						CentralDeInformacoes cdi = getPersistencia().buscarCentral();
						cdi.atualizarUsuario(usuario);
						getPersistencia().salvarPersistencia(cdi);
						new JanelaDeAvisoPadrao("Usuário editado com sucesso!");
						setVisible(false);
						painelDetalhe.setVisible(true);
					} catch (CaixaVaziaException e1) {
						e1.printStackTrace();
					} catch (Exception e1) {
						e1.printStackTrace();
					}
					
				}
			});
			add(concluir);
			
			BotaoVoltar voltar = new BotaoVoltar();
			voltar.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					System.out.println("Fui apertado02!");
					setVisible(false);
					painelDetalhe.setVisible(true);
				}
			});
			add(voltar);
		}
		
		
	}
	
	private class OuvinteEditar implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			
		}
	}
	
	private class OuvinteEditarPerfil implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			add(editarPerfil = new EditarPerfil(listaFiltrada.get(tabela.getSelectedRow())));
			painelDetalhe.setVisible(false);
		}
	}
	
	private class OuvinteBotaoDetalhar implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			add(painelDetalhe = new PainelDetalhe(listaFiltrada.get(tabela.getSelectedRow())));
			painelListaTodosUsuarios.setVisible(false);
		}
	}
	
	private class OuvinteTextoFiltro implements KeyListener{
		public void keyTyped(KeyEvent e) {
		}
		public void keyPressed(KeyEvent e) {
		}
		public void keyReleased(KeyEvent e) {
			String f = filtroTexto.getText();
			if(Character.isLetter(e.getKeyChar()) || e.getKeyCode() == 8 /*quando apertar backspace*/ || e.getKeyCode() == 127 /*quando apertar delete*/) {
				listaFiltrada.clear();
				modelo.setRowCount(0);
				for(Usuario u: lista) {
					Object[] linha = new Object[2];
					String filtroCombo = (String)filtro.getSelectedItem();
					
					switch (filtroCombo) {
					case "Todos usuários":
						if(u.getNome().contains(f) | u.getSobrenome().contains(f)) {
							linha[0] = u.getNome()+" "+u.getSobrenome();
							listaFiltrada.add(u);
						if(u instanceof Passageiro)
							linha[1] = "Passageiro";
						if(u instanceof Mototaxista)
							linha[1] = "Mototaxista";
						modelo.addRow(linha);
						}
						break;
					case "Apenas passageiros":
						if(u instanceof Passageiro) {
							linha[0] = u.getNome()+" "+u.getSobrenome();
							listaFiltrada.add(u);
							linha[1] = "Passageiro";
						modelo.addRow(linha);
						}
						break;
					case "Apenas mototaxistas":
						if(u instanceof Mototaxista) {
							linha[0] = u.getNome()+" "+u.getSobrenome();
							listaFiltrada.add(u);
							linha[1] = "Mototaxista";
						modelo.addRow(linha);
						}
					default:
						break;
					}
					
					
				}
			}
		}
	}
	
	private class OuvinteComboFiltro implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			
			String filtroCombo =(String)filtro.getSelectedItem();
			if(listaFiltrada.size() == 0)
				listaFiltrada = lista;
				
			switch (filtroCombo) {
				case "Todos usuários":
					modelo.setRowCount(0);
					for(Usuario u: listaFiltrada) {
						Object[] linha = new Object[2];
						linha[0] = u.getNome()+" "+u.getSobrenome();
						if(u instanceof Passageiro)
							linha[1] = "Passageiro";
						if(u instanceof Mototaxista)
							linha[1] = "Mototaxista";
						modelo.addRow(linha);
					}
					break;
				case "Apenas passageiros":
					modelo.setRowCount(0);
					for(Usuario u: listaFiltrada) {
						if(u instanceof Passageiro) {
							Object[] linha = new Object[2];
							linha[0] = u.getNome()+" "+u.getSobrenome();
							linha[1] = "Passageiro";
							modelo.addRow(linha);
						}
					}
					break;
				case "Apenas mototaxistas":
					modelo.setRowCount(0);
					for(Usuario u: listaFiltrada) {
						if(u instanceof Mototaxista) {
							Object[] linha = new Object[2];
							linha[0] = u.getNome()+" "+u.getSobrenome();
							linha[1] = "Mototaxista";
							modelo.addRow(linha);
						}
					}
					break;
			}
		}
	}
	
	private class OuvinteEnviarEmail implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			painelDetalhe.setVisible(false);
			add(painelEnviarEmail = new EnviarEmail(administrador));
			
		}
	}
	
}
