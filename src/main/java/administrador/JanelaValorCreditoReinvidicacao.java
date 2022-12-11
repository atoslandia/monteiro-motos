package administrador;


import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;

import projeto_poo.Administrador;
import projeto_poo.CentralDeInformacoes;
import projeto_poo.Sexo;
import projeto_poo.botoes.BotaoConcluir;
import projeto_poo.botoes.BotaoMais;
import projeto_poo.botoes.BotaoMenos;
import projeto_poo.botoes.BotaoVoltar;
import projeto_poo.caixas.CaixaValor;
import projeto_poo.diversos.TextoImagemPadrao;
import projeto_poo.erros.CaixaVaziaException;
import projeto_poo.erros.NaoExisteXmlException;
import projeto_poo.janelas.JanelaDeAvisoPadrao;
import projeto_poo.janelas.JanelaPadrao;

public class JanelaValorCreditoReinvidicacao extends JanelaPadrao{
	
	private CaixaValor numero;
	private Administrador administrador;
	
	public JanelaValorCreditoReinvidicacao(Administrador administrador) {
		super("Defina um valor para os créditos de reinvidicação");
		this.administrador = administrador;
		caixaValor();
		botoes();
		logo();
		add(getFundoPadrao());
		setVisible(true);
	}
	
	private void logo() {
		JLabel logo = new TextoImagemPadrao(new ImageIcon("imgs/administrador/valordoscreditos.png"));
		logo.setBounds(30, 21, 466, 41);
		add(logo);
	}
	
	private void botoes() {
		
		BotaoConcluir concluir = new BotaoConcluir();
		concluir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					CentralDeInformacoes cdi = getPersistencia().buscarCentral();
					cdi.setValorCreditoReinvidicacao(Float.parseFloat(numero.pegarConteudo()));
					getPersistencia().salvarPersistencia(cdi);
					dispose();
					new JanelaDeAvisoPadrao("Valor definido!", new JanelaPrincipalAdministrador(administrador));
				} catch (CaixaVaziaException e1) {
					e1.printStackTrace();
				} catch (Exception e1) {
					new JanelaDeAvisoPadrao("Algo deu errado, tente novamente!");
					e1.printStackTrace();
				}
			}
		});
		add(concluir);
		
		BotaoVoltar voltar = new BotaoVoltar();
		voltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				new JanelaPrincipalAdministrador(administrador);
			}
		});
		add(voltar);
	}
	
	private void caixaValor() {
		
		TextoImagemPadrao textoValor = new TextoImagemPadrao("Defina o valor:");
		textoValor.setBounds(30, 100, 90, 20);
		add(textoValor);
		
		TextoImagemPadrao rS = new TextoImagemPadrao("R$");
		rS.setBounds(190, 100, 90, 20);
		add(rS);
		
		numero = new CaixaValor();
		numero.setBounds(120, 100, 60, 20);
		
		add(numero);
	}
}
