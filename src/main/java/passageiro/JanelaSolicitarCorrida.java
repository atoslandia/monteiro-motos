package passageiro;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

import projeto_poo.botoes.BotaoProsseguir;
import projeto_poo.botoes.BotaoVoltar;
import projeto_poo.diversos.TextoImagemPadrao;
import projeto_poo.erros.CaixaVaziaException;
import projeto_poo.janelas.JanelaPadrao;
import projeto_poo.paineis.PainelSolicitarCorrida;

public class JanelaSolicitarCorrida extends JanelaPadrao {

	
	PainelSolicitarCorrida caixasSolicitarCorrida;

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
			botao.addActionListener(new OuvinteBotaoProsseguir());
			add(botao);
		}
		private void botaoVoltar() {
			BotaoVoltar botao = new BotaoVoltar();
			add(botao);
		}
	
		private class OuvinteBotaoProsseguir implements ActionListener {

			public void actionPerformed(ActionEvent e) {
				try {
					caixasSolicitarCorrida.getEndereco().pegarConteudo();
					caixasSolicitarCorrida.getCEP().pegarConteudo();
					caixasSolicitarCorrida.getBairro().pegarConteudo();
					caixasSolicitarCorrida.getNumero().pegarConteudo();
				} catch (CaixaVaziaException e1) {
					getAvisoPreencherDados().setVisible(true);	
				}
			}
		}
	}
	
	
	
	
	public static void main(String[] args) {
		new JanelaSolicitarCorrida();
	}
	
}
