package projeto_poo.diversos;

import java.awt.Color;
import java.util.ArrayList;

import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import projeto_poo.Mototaxista;
import projeto_poo.Passageiro;
import projeto_poo.Usuario;
import projeto_poo.janelas.JanelaPadrao;

public class TabelaUsuarios extends JTable{
	
	private ArrayList<Usuario> lista;
	private DefaultTableModel modelo;
	
	public DefaultTableModel getModelo() {
		return modelo;
	}



	public TabelaUsuarios(ArrayList<Usuario> lista) {
		this.lista = lista;
		setFont(getFont());
		tabelaTodosUsuarios();
		setModel(modelo);
		setBackground(new Color(204, 204, 204));
		
	}
	
	private void tabelaTodosUsuarios() {
		try {
			
			modelo = new DefaultTableModel();
			modelo.addColumn("Nome");
			modelo.addColumn("Tipo de conta");
			ArrayList<Usuario> usuarios = lista;
			Object[] linha = new Object[2];
			for(Usuario u: usuarios) {
				linha[0] = u.getNome()+" "+u.getSobrenome();
				if(u instanceof Passageiro)
					linha[1] = "Passageiro";
				if(u instanceof Mototaxista)
					linha[1] = "Mototaxista";
				modelo.addRow(linha);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
