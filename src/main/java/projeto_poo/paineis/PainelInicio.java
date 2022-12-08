package projeto_poo.paineis;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

import projeto_poo.botoes.BotaoListarCorridas;
import projeto_poo.botoes.BotaoPadrao;
import projeto_poo.botoes.BotaoPerfil;
import projeto_poo.diversos.TextoImagemPadrao;

public class PainelInicio extends PainelPadrao{
	
	private BotaoListarCorridas botaoListarCorridas;
	private BotaoPerfil botaoPerfil;
	
	public PainelInicio() {
		setSize(760, 420);
		botaoListarCorridas();
		botaoPerfil();
		barra();
		fundo();
	}
	
	private void fundo() {
        JLabel fundoLogin = new TextoImagemPadrao(new ImageIcon("imgs/fundo-inicio.png"));
        fundoLogin.setBounds(15, 8, 768, 326);
        add(fundoLogin);
	}
	
	private void barra() {
        JLabel fundoLogin = new TextoImagemPadrao(new ImageIcon("imgs/fundo-botaoinicio.png"));
        fundoLogin.setBounds(0, 331, 761, 51);
        add(fundoLogin);
	}
	
	private void botaoListarCorridas() {
		botaoListarCorridas = new BotaoListarCorridas();
        add(botaoListarCorridas);
	}
	
	private void botaoPerfil() {
		botaoPerfil = new BotaoPerfil();
		add(botaoPerfil);
	}

	public BotaoListarCorridas getBotaoListarCorridas() {
		return botaoListarCorridas;
	}

	public BotaoPerfil getBotaoPerfil() {
		return botaoPerfil;
	}
	
}
