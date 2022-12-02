package projeto_poo.ouvintes;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.border.Border;
import javax.swing.plaf.BorderUIResource;

import projeto_poo.Mensageiro;
import projeto_poo.janelas.JanelaConfirmarEmail;
import projeto_poo.janelas.JanelaPadrao;
import projeto_poo.janelas.PrimeiroAcesso;

public class OuvinteComponentesPreenchidosDeDados implements ActionListener{
	
	private PrimeiroAcesso janela;
	
	public OuvinteComponentesPreenchidosDeDados(PrimeiroAcesso janela) {
		this.janela = janela;
	}
	
	public void actionPerformed(ActionEvent e) {
		Border borda = BorderFactory.createMatteBorder(1,1,1,1, Color.BLACK);
		Border bordaErro = BorderFactory.createMatteBorder(2,2,2,2, new Color(231, 110, 84));

		if(janela.getNome().getText().equals(""))
			janela.getNome().setBorder(bordaErro);
		else janela.getNome().setBorder(borda);
		
		if(janela.getSobrenome().getText().equals(""))
			janela.getSobrenome().setBorder(bordaErro);
		else janela.getSobrenome().setBorder(borda);
		
		if(janela.getEmail().getText().equals(""))
			janela.getEmail().setBorder(bordaErro);
		else janela.getEmail().setBorder(borda);
		if(new String(janela.getSenha().getPassword()).length() < 4 || new String(janela.getSenha().getPassword()).equals("")) 
			janela.getSenha().setBorder(bordaErro);
		else janela.getSenha().setBorder(borda);
		
		if(!janela.getFeminino().isSelected() && !janela.getMasculino().isSelected())	{
			janela.getFeminino().setForeground(new Color(231, 110, 84));
			janela.getMasculino().setForeground(new Color(231, 110, 84));
		}
		else {
			janela.getFeminino().setForeground(null);
			janela.getMasculino().setForeground(null);
		}
		
		if(!janela.getNome().getText().equals("") && !janela.getSobrenome().getText().equals("") && !janela.getEmail().getText().equals("") && !new String(janela.getSenha().getPassword()).equals("") && new String(janela.getSenha().getPassword()).length() > 3 && (janela.getFeminino().isSelected() | janela.getMasculino().isSelected())) {
			
			try {
				Mensageiro.enviarHistoricoCorridas(janela.getEmail().getText());
				janela.setVisible(false);
				new JanelaConfirmarEmail();
			} catch (Exception e1) {
				e1.printStackTrace();
			}
			
		}
	}
}
