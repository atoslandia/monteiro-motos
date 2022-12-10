package administrador;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import projeto_poo.Mototaxista;
import projeto_poo.Passageiro;
import projeto_poo.Usuario;
import projeto_poo.botoes.BotaoDetalhar;
import projeto_poo.botoes.BotaoOpcoes;
import projeto_poo.botoes.BotaoVoltar;
import projeto_poo.caixas.CaixaNomeSobrenome;
import projeto_poo.diversos.ComboFiltroTodosUsuarios;
import projeto_poo.diversos.TabelaUsuarios;
import projeto_poo.diversos.TextoImagemPadrao;
import projeto_poo.erros.NaoExisteXmlException;
import projeto_poo.janelas.JanelaPadrao;
import projeto_poo.paineis.PainelPadrao;

public class JanelaTodosUsuarios extends JanelaPadrao{
	
	private PainelDetalhe painelDetalhe;
	private ListaTodosUsuarios listaTodosUsuarios;
	
	private JScrollPane scroll;
	private JTable tabela;
	private DefaultTableModel modelo;
	private ArrayList<Usuario> listaUsuarios;
	private CaixaNomeSobrenome filtroTexto;
	
	public JanelaTodosUsuarios() {
		super("Lista de todos os usuários");
		iniciarValor();
		add(listaTodosUsuarios = new ListaTodosUsuarios());
		setVisible(true);
	}
	
	private void iniciarValor() {
		try {
			listaUsuarios = getPersistencia().buscarCentral().getTodosOsUsuarios();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	private void gerarUsuarios(ArrayList<Usuario> usuarios) {
		Object[] linha = new Object[2];
		for(Usuario u: usuarios) {
			linha[0] = u.getNome()+" "+u.getSobrenome();
			if(u instanceof Passageiro)
				linha[1] = "Passageiro";
			if(u instanceof Mototaxista)
				linha[1] = "Mototaxista";
			modelo.addRow(linha);
		}
	}
	
	private class ListaTodosUsuarios extends PainelPadrao{
		public ListaTodosUsuarios() {
			filtros();
			painelUsuarios();
			botoes();
			logo();
			add(getFundoPadrao());
		}
		
		private void filtros() {
			TextoImagemPadrao texto = new TextoImagemPadrao("Filtros: ");
			texto.setBounds(30, 85, 50, 20);
			add(texto);
			filtroTexto = new CaixaNomeSobrenome();
			filtroTexto.setText("");
			filtroTexto.setBounds(280, 85, 230, 20);
			filtroTexto.addKeyListener(new OuvinteFiltroTexto());
			add(filtroTexto);

			ComboFiltroTodosUsuarios filtro = new ComboFiltroTodosUsuarios();
			add(filtro);
			
		}
		
		private void painelUsuarios() {
			modelo = new DefaultTableModel();
			modelo.addColumn("Nome");
			modelo.addColumn("Tipo de conta");
			gerarUsuarios(listaUsuarios);
			tabela = new JTable(modelo);
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
			add(voltar);
		}
		
		private void logo() {
			JLabel logo = new TextoImagemPadrao(new ImageIcon("imgs/administrador/todososusuarios.png"));
			logo.setBounds(30, 21, 451, 40);
			add(logo);
		}
	}
	
	private class PainelDetalhe extends PainelPadrao{
		
		private Usuario usuario;
		
		public PainelDetalhe(Usuario usuario) {
			this.usuario = usuario;
			botoes();
			detalhes();
			setVisible(true);
		}
		
		private void botoes() {
			BotaoVoltar voltar = new BotaoVoltar();
			voltar.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					listaTodosUsuarios.setVisible(true);
					setVisible(false);
				}
			});
			add(voltar);
		}
		
		private void detalhes() {
			TextoImagemPadrao detalhes = new TextoImagemPadrao(usuario.toString());
			detalhes.setBounds(30, 80, 300, 200);
			add(detalhes);
			
			
		}
		
		private void logo() {
			JLabel logo = new TextoImagemPadrao(new ImageIcon("imgs/administrador/todososusuarios.png"));
			logo.setBounds(30, 21, 451, 40);
			add(logo);
		}
		
		
		
	}
	
	private class OuvinteBotaoDetalhar implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			add(painelDetalhe = new PainelDetalhe(listaUsuarios.get(tabela.getSelectedRow())));
			listaTodosUsuarios.setVisible(false);
		}
	}
	
	private class OuvinteFiltroTexto implements KeyListener{
		public void keyPressed(KeyEvent e) {
		}

		public void keyTyped(KeyEvent e) {
		}
		
		public void keyReleased(KeyEvent e) {
			String filtro = filtroTexto.getText();
			if(filtro.equals("")) {
				modelo.setNumRows(0);
				gerarUsuarios(listaUsuarios);
			}
			if(Character.isLetter(e.getKeyChar())) {
				modelo.setNumRows(0);
				Object[] linha = new Object[2];
				for(Usuario u: listaUsuarios) {
					if(u.getNome().contains(filtro) || u.getSobrenome().contains(filtro)) {
						linha[0] = u.getNome()+" "+u.getSobrenome();
						if(u instanceof Passageiro)
							linha[1] = "Passageiro";
						if(u instanceof Mototaxista)
							linha[1] = "Mototaxista";
						modelo.addRow(linha);
					}
				}
			}
			scroll.repaint();
		}
	}
}
