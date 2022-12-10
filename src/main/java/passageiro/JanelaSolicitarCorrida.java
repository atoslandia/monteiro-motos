package passageiro;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

import projeto_poo.botoes.BotaoProsseguir;
import projeto_poo.botoes.BotaoVoltar;
import projeto_poo.diversos.TextoImagemPadrao;
import projeto_poo.janelas.JanelaPadrao;
import projeto_poo.paineis.PainelSolicitarCorrida;

public class JanelaSolicitarCorrida extends JanelaPadrao {


	public JanelaSolicitarCorrida() {
		super("Ponto de encontro");
		add(new PainelPontoDeEncontro());
		
		setVisible(true);
	}
	
	public class PainelPontoDeEncontro extends PainelSolicitarCorrida{
		
		public PainelPontoDeEncontro() {
			add(getFundoPadrao());
			botaoVoltar();
			botaoProceguir();
		}
		private void botaoProceguir() {
			BotaoProsseguir botao = new BotaoProsseguir();
			add(botao);
		}
		private void botaoVoltar() {
			BotaoVoltar botao = new BotaoVoltar();
			add(botao);
		}
		
	}
	
	public static void main(String[] args) {
		new JanelaSolicitarCorrida();
	}
	
}
