package projeto_poo.paineis;

import java.awt.Color;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

import projeto_poo.botoes.BotaoInicio;
import projeto_poo.botoes.BotaoListarCorridas;
import projeto_poo.botoes.BotaoPerfil;
import projeto_poo.diversos.TextoImagemPadrao;

public abstract class PainelPadrao extends JPanel{
	
	private TextoImagemPadrao fundoInicio;
	private TextoImagemPadrao fundoPadrao;
	
	private TextoImagemPadrao avisoPreencherDados;

	public PainelPadrao() {
		setLayout(null);
		setSize(760, 420);
		fundoPadrao();
		fundoInicio();
		avisos();
	}
	
	private void avisos() {
    	avisoPreencherDados = new TextoImagemPadrao("Preencha todos os dados!");
    	avisoPreencherDados.setForeground(Color.RED);
    	avisoPreencherDados.setVisible(false);
    	avisoPreencherDados.setBounds(120, 65, 150, 20);
    	add(avisoPreencherDados);
    }
	
	private void fundoPadrao() {
		fundoPadrao = new TextoImagemPadrao(new ImageIcon("imgs/fundo-padrao.png"));
		fundoPadrao.setBounds(15, -7, 768, 406);
	}
	
	private void fundoInicio() {
		fundoInicio = new TextoImagemPadrao(new ImageIcon("imgs/fundo-inicio.png"));
		fundoInicio.setBounds(15, 8, 768, 326);
	}
	
	public TextoImagemPadrao getFundoPadrao() {
		return fundoPadrao;
	}

	public TextoImagemPadrao getFundoInicio() {
		return fundoInicio;
	}
	
	public TextoImagemPadrao getAvisoPreencherDados() {
		return avisoPreencherDados;
	}
	
}
