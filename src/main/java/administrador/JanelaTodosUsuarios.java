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
import projeto_poo.janelas.JanelaPadrao;
import projeto_poo.paineis.PainelPadrao;

public class JanelaTodosUsuarios extends JanelaPadrao{
	
	
	
	private ListaTodosUsuarios listaTodosUsuarios;
	private JScrollPane scroll;
	private JTable tabela;
	private DefaultTableModel modelo;
	
	private CaixaNomeSobrenome filtroTexto;
	
	public JanelaTodosUsuarios() {
		super("Lista de todos os usuários");
		add(listaTodosUsuarios = new ListaTodosUsuarios());
		setVisible(true);
	}
	
	
	private class ListaTodosUsuarios extends PainelPadrao{
		public ListaTodosUsuarios() {
			painelUsuarios();
			botoes();
			filtros();
			logo();
			add(getFundoPadrao());
		}
		
		private void filtros() {
			TextoImagemPadrao texto = new TextoImagemPadrao("Filtros: ");
			texto.setBounds(30, 85, 50, 20);
			add(texto);
			
			filtroTexto = new CaixaNomeSobrenome();
			filtroTexto.setBounds(280, 85, 230, 20);
			filtroTexto.addKeyListener(new KeyListener() {
				
				public void keyTyped(KeyEvent e) {
					try {
						modelo.setRowCount(0);
						String filtro = filtroTexto.getText();
						if(Character.isWhitespace(e.getKeyChar()))
							filtro += e.getKeyChar();

						for(Usuario u: getPersistencia().buscarCentral().getTodosOsUsuarios()) {
							if(u.getNome().contains(filtro))
								lista(u);
						}
						
						scroll.repaint();
						} catch (Exception e2) {
						// TODO: handle exception
					}
				}
				
				public void keyReleased(KeyEvent e) {
				}
				public void keyPressed(KeyEvent e) {
				}
			});
			add(filtroTexto);

			ComboFiltroTodosUsuarios filtro = new ComboFiltroTodosUsuarios();
			add(filtro);
			
		}
		
		private void lista(Usuario u) {
			Object[] linha = new Object[2];
			linha[0] = u.getNome()+" "+u.getSobrenome();
			if(u instanceof Passageiro)
				linha[1] = "Passageiro";
			if(u instanceof Mototaxista)
				linha[1] = "Mototaxista";
			modelo.addRow(linha);
		}
		
		private void painelUsuarios() {
			try {
				modelo = new DefaultTableModel();
				modelo.addColumn("Nome");
				modelo.addColumn("Tipo de conta");
				
				for(Usuario u: getPersistencia().buscarCentral().getTodosOsUsuarios()) {
						lista(u);
					}
				} catch (Exception e) {
					e.printStackTrace();
				}
				tabela = new JTable(modelo);
				scroll = new JScrollPane(tabela);
				scroll.setBounds(30, 120, 480, 230);
				add(scroll);
		}
			
		private void botoes() {
			BotaoDetalhar detalhar = new BotaoDetalhar();
			detalhar.addActionListener(new ActionListener() {
				
				public void actionPerformed(ActionEvent e) {
					
				}
			});
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
}
