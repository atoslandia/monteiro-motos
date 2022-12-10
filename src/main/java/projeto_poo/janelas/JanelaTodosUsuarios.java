package projeto_poo.janelas;

import java.awt.Color;
import java.awt.Dimension;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import projeto_poo.Mototaxista;
import projeto_poo.Passageiro;
import projeto_poo.Usuario;
import projeto_poo.botoes.BotaoOpcoes;
import projeto_poo.botoes.BotaoVoltar;
import projeto_poo.diversos.TextoImagemPadrao;
import projeto_poo.paineis.PainelPadrao;

public class JanelaTodosUsuarios extends JanelaPadrao{
	private ListaTodosUsuarios listaTodosUsuarios;
	private Lista lista;
	
	public JanelaTodosUsuarios() {
		super("Lista de todos os usuários");
		add(listaTodosUsuarios = new ListaTodosUsuarios());
		add(lista = new Lista());
		setVisible(true);
	}
	
	private class Lista extends PainelPadrao{
		
		public Lista() {
			super();
			setBackground(Color.red);
			setBounds(30, 80, 420, 275);
			setPreferredSize(new Dimension(420, getComponentCount()*50));
			painelUsuarios();
		}		
		private void painelUsuarios() {
			ArrayList<Usuario> usuarios;
			
			DefaultTableModel modelo = new DefaultTableModel();
			modelo.addColumn("Nome");
			modelo.addColumn("Tipo de conta");
			
			
			try {
				usuarios = getPersistencia().buscarCentral().getTodosOsUsuarios();
				Object[] linha = new Object[2];
				for(Usuario u: usuarios) {
					linha[0] = u.getNome()+" "+u.getSobrenome();
					if(u instanceof Passageiro)
						linha[1] = "Passageiro";
					if(u instanceof Mototaxista)
						linha[1] = "Passageiro";
					modelo.addRow(linha);

				}
				JTable tabela = new JTable(modelo);
				JScrollPane scroll = new JScrollPane(tabela);
				scroll.setSize(420,	275);
				add(scroll);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
	
	private class ListaTodosUsuarios extends PainelPadrao{
		public ListaTodosUsuarios() {
			super();
			botoes();
			scrol();
			add(lista = new Lista());
			logo();
			add(getFundoPadrao());
		}
		
		private void botoes() {
			BotaoVoltar voltar = new BotaoVoltar();
			add(voltar);
		}
		
		private void scrol() {
			JScrollPane sp = new JScrollPane(lista);
			sp.setSize(300,300);
		}
		
		private void logo() {
			JLabel logo = new TextoImagemPadrao(new ImageIcon("imgs/administrador/todososusuarios.png"));
			logo.setBounds(30, 21, 451, 40);
			add(logo);
		}
	}
	
}
