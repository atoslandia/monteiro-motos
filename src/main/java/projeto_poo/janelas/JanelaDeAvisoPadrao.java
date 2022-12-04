package projeto_poo.janelas;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;

import projeto_poo.componentes.BotaoPadrao;
import projeto_poo.componentes.TextoImagemPadrao;

public class JanelaDeAvisoPadrao extends JanelaPadrao{
	
	public JanelaDeAvisoPadrao(String aviso, JanelaPadrao janela) {
		super("Atenção");
		this.aviso = aviso;
		setSize(250,150);
		setLocationRelativeTo(janela);
		textoAviso();
		botaoVoltarAviso();
		setVisible(true);
	}
	
	private String aviso;
	private JButton botaoProsseguirAviso;
	
	private void textoAviso() {
		JLabel texto = new TextoImagemPadrao(aviso);
		texto.setBounds(-5, 5, 250, 50);
		texto.setHorizontalAlignment(JLabel.CENTER);
		add(texto);
	}
	
	private void botaoVoltarAviso() {
		botaoProsseguirAviso = getBotaoVoltar();
		botaoProsseguirAviso.setBounds(90, 75, 58, 22);
		botaoProsseguirAviso.addActionListener(new OuvinteBotaoVoltarAviso());
		add(botaoProsseguirAviso);
	}
	
	private class OuvinteBotaoVoltarAviso implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			dispose();
		}
	}

}
