package projeto_poo.janelas;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;
import java.util.Random;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;

import projeto_poo.Administrador;
import projeto_poo.CentralDeInformacoes;
import projeto_poo.Mensageiro;
import projeto_poo.Mototaxista;
import projeto_poo.Passageiro;
import projeto_poo.Sexo;
import projeto_poo.Usuario;
import projeto_poo.botoes.BotaoConcluir;
import projeto_poo.botoes.BotaoProsseguir;
import projeto_poo.botoes.BotaoVoltar;
import projeto_poo.erros.CaixaVaziaException;
import projeto_poo.erros.MenorDeIdadeException;
import projeto_poo.paineis.PainelConfirmarEmail;
import projeto_poo.paineis.PainelEntradas;

public class JanelaPrimeiroAcesso extends JanelaPadrao{
	
	private CriarAdministrador criarAdministrador;
	private ConfirmarCodigoPainel confirmarCodigoPainel;
	private Random c = new Random();
	private String codigoGerado;
	
	public JanelaPrimeiroAcesso() {
		super("Primeiro acesso");
		add(criarAdministrador = new CriarAdministrador());
		setVisible(true);
	}
	
	private class CriarAdministrador extends PainelEntradas{
		public CriarAdministrador() {
			super();
			prosseguir();
			logoPrimeiroAcesso();
			add(getFundoPadrao());
		}
		
		private void logoPrimeiroAcesso() {
    		JLabel logo = new JLabel(new ImageIcon("imgs/primeiroacesso.png"));
    		logo.setBounds(30, 30, 394, 32);
    		add(logo);
    	}
		
    	private void prosseguir() {
    		JButton prosseguir = new BotaoProsseguir();
    		prosseguir.addActionListener(new OuvinteCriarAdministrador());
    		add(prosseguir);
    	}
	}
	
	private class ConfirmarCodigoPainel extends PainelConfirmarEmail{

		public ConfirmarCodigoPainel() {
    		super();
    		concluir();
    		voltar();
    		add(getFundoPadrao());
		}
		
    	private void concluir() {
    		BotaoConcluir concluir = new BotaoConcluir();
    		concluir.addActionListener(new OuvinteConfirmarCodigo());
    		add(concluir);
    	}
    	
    	private void voltar() {
    		JButton voltar = new BotaoVoltar();
    		voltar.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
				}
			});
    		add(voltar);
    	}
    	
	}
	
	private class OuvinteCriarAdministrador implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			criarAdministrador.getAvisoPreencherDados().setVisible(false);
				try {
					criarAdministrador.getNome().pegarConteudo();
					criarAdministrador.getSobrenome().pegarConteudo();
					criarAdministrador.getEmail().pegarConteudo();
					criarAdministrador.getSenha().pegarConteudo();
					criarAdministrador.getSexo().selecionado();
					criarAdministrador.getDataNascimento().pegarDataNascimento();
					
					codigoGerado = Integer.toString(c.nextInt(1000,9999));
					Mensageiro.enviarCodigoEmail(criarAdministrador.getEmail().pegarConteudo(), "CÓDIGO DE SEGURANÇA", "Seu código de segurança: "+codigoGerado);
					criarAdministrador.setVisible(false);
					add(confirmarCodigoPainel = new ConfirmarCodigoPainel());
				} catch (CaixaVaziaException e2) {
					criarAdministrador.getAvisoPreencherDados().setVisible(true);
				} catch (MenorDeIdadeException e2) {
					new JanelaDeAvisoPadrao("Você precisa ser maior de 18 anos!");
				} catch (Exception e2) {
					new JanelaDeAvisoPadrao("E-mail incorreto ou inexistente!");
				}
		}
	}
	
	private class OuvinteConfirmarCodigo implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			try {
				confirmarCodigoPainel.getCodigo().comparar(codigoGerado);
				CentralDeInformacoes cdi = getPersistencia().buscarCentral();
				Usuario usuario = new Administrador(criarAdministrador.getNome().pegarConteudo(), criarAdministrador.getSobrenome().pegarConteudo(),
										criarAdministrador.getDataNascimento().pegarDataNascimento(),
										criarAdministrador.getSexo().selecionado(),
										criarAdministrador.getEmail().getText(), criarAdministrador.getSenha().pegarConteudo());
				cdi.adicionarUsuario(usuario);
				getPersistencia().salvarPersistencia(cdi);
				dispose();
				new JanelaDeAvisoPadrao("Administrador cadastrado com sucesso!", new JanelaLogin());
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
	}
	
}
