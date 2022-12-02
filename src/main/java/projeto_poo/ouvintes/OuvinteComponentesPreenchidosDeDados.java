package projeto_poo.ouvintes;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.border.Border;
import javax.swing.plaf.BorderUIResource;

import projeto_poo.janelas.JanelaConfirmarEmail;
import projeto_poo.janelas.JanelaPadrao;

public class OuvinteComponentesPreenchidosDeDados implements ActionListener{
	
	private JanelaPadrao janela;
	private boolean todosPreenchidos = true;
	
	public OuvinteComponentesPreenchidosDeDados(JanelaPadrao janela) {
		this.janela = janela;
	}
	
	public void actionPerformed(ActionEvent e) {
		Border borda = BorderFactory.createMatteBorder(1,1,1,1, Color.BLACK);
		Border bordaErro = BorderFactory.createMatteBorder(2,2,2,2, new Color(231, 110, 84));
		
			if(janela.getNome().getText().equals("")) {
				janela.getNome().setBorder(bordaErro);
				todosPreenchidos = false;
			}
			else janela.getNome().setBorder(borda);
			
			if(janela.getSobrenome().getText().equals("")) {
				janela.getSobrenome().setBorder(bordaErro);
				todosPreenchidos = false;
			}
			else 
				janela.getSobrenome().setBorder(borda);
			
			if(janela.getEmail().getText().equals("")) {
				janela.getEmail().setBorder(bordaErro);
				todosPreenchidos = false;
			}
			else 
				janela.getEmail().setBorder(borda);
			
			if(new String(janela.getSenha().getPassword()).equals("")) {
				todosPreenchidos = false;
				janela.getSenha().setBorder(bordaErro);
			}
			else
				janela.getSenha().setBorder(borda);
			
			if(!janela.getFeminino().isSelected() && !janela.getMasculino().isSelected())	{
				janela.getFeminino().setForeground(new Color(231, 110, 84));
				janela.getMasculino().setForeground(new Color(231, 110, 84));
				todosPreenchidos = false;
			}
			else {
				janela.getFeminino().setForeground(null);
				janela.getMasculino().setForeground(null);
			}
			
			if(!janela.getNome().getText().equals("") && !janela.getSobrenome().getText().equals("") && !janela.getEmail().getText().equals("") && !new String(janela.getSenha().getPassword()).equals("") && (janela.getFeminino().isSelected() | janela.getMasculino().isSelected()))
				todosPreenchidos = true;
	}
	
	public boolean isTodosPreenchidos() {
		return todosPreenchidos;
	}
			
}
