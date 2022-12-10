package passageiro;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JTextField;

import projeto_poo.Passageiro;
import projeto_poo.PontoDeEncontro;
import projeto_poo.Usuario;
import projeto_poo.botoes.BotaoProsseguir;
import projeto_poo.botoes.BotaoVoltar;
import projeto_poo.caixas.CaixaCEPNumero;
import projeto_poo.caixas.CaixaDistancia;
import projeto_poo.caixas.CaixaTextoPadrao;
import projeto_poo.diversos.TextoImagemPadrao;
import projeto_poo.erros.CaixaVaziaException;
import projeto_poo.janelas.JanelaPadrao;
import projeto_poo.paineis.PainelSolicitarCorrida;

public class JanelaSolicitarCorrida extends JanelaPadrao {
	private PainelDestino painelDestino;
	private PainelPontoDeEncontro caixasSolicitarCorrida;
	private PontoDeEncontro encontro;
	private Usuario passageiro;
	private CaixaDistancia distancia;
	
	public JanelaSolicitarCorrida(Passageiro passageiro) {
		super("Ponto de encontro");
		this.passageiro = passageiro;
		add(caixasSolicitarCorrida = new PainelPontoDeEncontro());
		add(painelDestino = new PainelDestino());
		setVisible(true);
	}
	
	
	private class PainelPontoDeEncontro extends PainelSolicitarCorrida{
		
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
			botao.addActionListener(new OuvinteBotaoVoltar());
			add(botao);
		}
	
	}
	
	private class PainelDestino extends PainelSolicitarCorrida{
		public PainelDestino() {
			
			add(getFundoPadrao());
			caixaDistancia();
			botaoVoltar();
			setVisible(false);
			
		}
		
		private void caixaDistancia() {
			TextoImagemPadrao textoDistancia = new TextoImagemPadrao("Distancia (Km): ");
			textoDistancia.setBounds(30, 255, 100, 19);
			add(textoDistancia);
			
			distancia = new CaixaDistancia();
			distancia.setBounds(130, 255, 220, 19);
			add(distancia);
		}
		
		private void botaoVoltar() {
			BotaoVoltar botao = new BotaoVoltar();
			botao.addActionListener(new OuvinteBotaoVoltarDestino());
			add(botao);
		}
		
	}
	
	private class OuvinteBotaoProsseguir implements ActionListener {
		
		public void actionPerformed(ActionEvent e) {
			
			try {
				
				String endereco = caixasSolicitarCorrida.getEndereco().pegarConteudo();
				String CEP = caixasSolicitarCorrida.getCEP().pegarConteudo();
				String bairro = caixasSolicitarCorrida.getBairro().pegarConteudo();
				int numero = Integer.parseInt(caixasSolicitarCorrida.getNumero().pegarConteudo());
				String complemento = caixasSolicitarCorrida.getComplemento().getText();
				encontro = new PontoDeEncontro(endereco, CEP, numero, bairro, complemento);
				caixasSolicitarCorrida.setVisible(false);
				painelDestino.setVisible(true);
			} catch (CaixaVaziaException e1) {
				getAvisoPreencherDados().setVisible(true);	
			}
		}
	}
	private class OuvinteBotaoVoltar implements ActionListener{

		public void actionPerformed(ActionEvent e) {
			dispose();
			new JanelaPrincipalPassageiro(passageiro);
		}
		
	}
	private class OuvinteBotaoVoltarDestino implements ActionListener{

		public void actionPerformed(ActionEvent e) {
			painelDestino.setVisible(false);
			caixasSolicitarCorrida.setVisible(true);
		}
		
	}
	

	
}
