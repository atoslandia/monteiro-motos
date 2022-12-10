package projeto_poo.janelas;

import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.LayoutManager;
import java.awt.Rectangle;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.LayoutStyle;
import javax.swing.plaf.basic.BasicScrollBarUI;

import projeto_poo.Usuario;
import projeto_poo.botoes.BotaoOpcoes;
import projeto_poo.botoes.BotaoVoltar;
import projeto_poo.diversos.TextoImagemPadrao;
import projeto_poo.erros.NaoExisteXmlException;
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
			listaUsuarios();
		}		
		private void listaUsuarios() {
			ArrayList<Usuario> usuarios;
			try {
				usuarios = getPersistencia().buscarCentral().getTodosOsUsuarios();
				for(int i = 0; i < usuarios.size(); i++) {
					BotaoOpcoes botao = new BotaoOpcoes(usuarios.get(i).getNome());
					botao.setLocation(30, -10+((i+1)*50));
					add(botao);
				}
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
