package projeto_poo.paineis;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;

import projeto_poo.botoes.BotaoInicio;
import projeto_poo.botoes.BotaoListarCorridas;
import projeto_poo.botoes.BotaoPerfil;
import projeto_poo.diversos.TextoImagemPadrao;

public class PainelPrincipal extends PainelPadrao{
	
	private BotaoInicio botaoInicio;
	private BotaoListarCorridas botaoListarCorridas;
	private BotaoPerfil botaoPerfil;
	
	private TextoImagemPadrao barraInicio;
	private TextoImagemPadrao barraListarCorridas;
	private TextoImagemPadrao barraPerfil;
	
	public PainelPrincipal() {
		super();
		botaoInicio();
		botaoListarCorridas();
		botaoPerfil();
		barraInicio();
		barraPerfil();
		barraListarCorridas();
		setVisible(true);
	}
	
	private void botaoInicio() {
		botaoInicio = new BotaoInicio();
	}
	
	private void botaoPerfil() {
		botaoPerfil = new BotaoPerfil();
	}
	
	private void botaoListarCorridas() {
		botaoListarCorridas = new BotaoListarCorridas();
	}
	
	private void barraInicio() {
		barraInicio = new TextoImagemPadrao(new ImageIcon("imgs/fundo-botaoinicio.png"));
		barraInicio.setBounds(0, 331, 761, 51);
	}
	
	private void barraListarCorridas() {
		barraListarCorridas = new TextoImagemPadrao(new ImageIcon("imgs/fundo-botaolistarcorridas.png"));
		barraListarCorridas.setBounds(0, 331, 761, 51);
	}
	
	private void barraPerfil() {
		barraPerfil = new TextoImagemPadrao(new ImageIcon("imgs/fundo-botaoperfil.png"));
		barraPerfil.setBounds(0, 331, 761, 51);
	}

	public BotaoInicio getBotaoInicio() {
		return botaoInicio;
	}

	public BotaoListarCorridas getBotaoListarCorridas() {
		return botaoListarCorridas;
	}

	public BotaoPerfil getBotaoPerfil() {
		return botaoPerfil;
	}

	public TextoImagemPadrao getBarraInicio() {
		return barraInicio;
	}

	public TextoImagemPadrao getBarraListarCorridas() {
		return barraListarCorridas;
	}

	public TextoImagemPadrao getBarraPerfil() {
		return barraPerfil;
	}
	
}
