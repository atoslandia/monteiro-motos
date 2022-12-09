package projeto_poo.janelas;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;
import java.util.Random;

import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JRadioButton;

import projeto_poo.CentralDeInformacoes;
import projeto_poo.Mensageiro;
import projeto_poo.Mototaxista;
import projeto_poo.Passageiro;
import projeto_poo.Sexo;
import projeto_poo.Usuario;
import projeto_poo.botoes.BotaoConcluir;
import projeto_poo.botoes.BotaoProsseguir;
import projeto_poo.botoes.BotaoVoltar;
import projeto_poo.caixas.CaixaCodigo;
import projeto_poo.diversos.EscolhaSexo;
import projeto_poo.diversos.EscolhaUsuario;
import projeto_poo.diversos.TextoImagemPadrao;
import projeto_poo.erros.CaixaVaziaException;
import projeto_poo.erros.UsuarioNaoExisteException;
import projeto_poo.paineis.PainelConfirmarEmail;
import projeto_poo.paineis.PainelEntradas;
import projeto_poo.paineis.PainelPadrao;

public class JanelaCriarConta extends JanelaPadrao{
	
	private EscolhaUsuario tipoUsuario;
	
	private Random c = new Random();
	private String codigoGerado;
	
	private CriarUsuarioPainel criarUsuarioPainel;
	private ConfirmarCodigoPainel confirmarCodigoPainel;
	
	public JanelaCriarConta() {
		super("Criar conta");
		add(criarUsuarioPainel = new CriarUsuarioPainel());
		setVisible(true);
	}
	
    private class CriarUsuarioPainel extends PainelEntradas{
    	public CriarUsuarioPainel() {
    		super();
    		prosseguir();
    		tipoDeConta();
    		voltar();
    		logoCadastro();
    		add(getFundoPadrao());
    	}
    	
    	private void logoCadastro() {
    		JLabel logo = new JLabel(new ImageIcon("imgs/criarconta.png"));
    		logo.setBounds(30, 30, 282, 32);
    		add(logo);
    	}
    	
    	private void tipoDeConta() {
    	    JLabel textoTipoDeConta = new TextoImagemPadrao("Tipo de Conta: ");
    	    textoTipoDeConta.setBounds(30 , 265, 100 ,20);
    	    add(textoTipoDeConta);
    	    
    	    tipoUsuario = new EscolhaUsuario();
    	    add(tipoUsuario.getPassageiro());
    	    add(tipoUsuario.getMototaxista());
    	}
    	
    	private void prosseguir() {
    		BotaoProsseguir prosseguir = new BotaoProsseguir();
    		prosseguir.addActionListener(new OuvinteBotaoProsseguir());
    		add(prosseguir);
    	}
    	
    	private void voltar() {
    		BotaoVoltar voltar = new BotaoVoltar();
    		voltar.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					dispose();
					new JanelaLogin();
				}
			});
    		add(voltar);
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
    		concluir.addActionListener(new OuvinteBotaoConfirmarCodigo());
    		add(concluir);
    	}
    	
    	private void voltar() {
    		JButton voltar = new BotaoVoltar();
    		voltar.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					confirmarCodigoPainel.setVisible(false);
					criarUsuarioPainel.setVisible(true);
				}
			});
    		add(voltar);
    	}
    	
    }
    
    private class OuvinteBotaoProsseguir implements ActionListener{
		
		public void actionPerformed(ActionEvent e) {

			getAvisoPreencherDados().setVisible(false);
			try {
				criarUsuarioPainel.getNome().pegarConteudo();
				criarUsuarioPainel.getSobrenome().pegarConteudo();
				criarUsuarioPainel.getEmail().pegarConteudo();
				criarUsuarioPainel.getSenha().pegarConteudo();
				criarUsuarioPainel.getSexo().selecionado();
				tipoUsuario.selecionado();
				
				getPersistencia().buscarCentral().recuperarUsuarioPeloEmail(criarUsuarioPainel.getEmail().pegarConteudo());
				new JanelaDeAvisoPadrao("Usuário já existente!");
			} catch (CaixaVaziaException e2) {
				getAvisoPreencherDados().setVisible(true);
			} catch (UsuarioNaoExisteException e2) {
				try {
					codigoGerado = Integer.toString(c.nextInt(1000,9999));
					Mensageiro.enviarCodigoEmail(criarUsuarioPainel.getEmail().pegarConteudo(), codigoGerado);
					criarUsuarioPainel.setVisible(false);
					add(confirmarCodigoPainel = new ConfirmarCodigoPainel());
				} catch (Exception e1) {
					System.out.println(e1);
					new JanelaDeAvisoPadrao("E-mail incorreto ou inexistente");
				}
			} catch (Exception e2) {
				System.out.println(e2);
			}
		}
	}
    
    private class OuvinteBotaoConfirmarCodigo implements ActionListener{
    	public void actionPerformed(ActionEvent e) {
				try {
					confirmarCodigoPainel.getCodigo().comparar(codigoGerado);
					CentralDeInformacoes cdi = getPersistencia().buscarCentral();
					Usuario usuario = tipoUsuario.criarUsuario(criarUsuarioPainel.getNome().pegarConteudo(), criarUsuarioPainel.getSobrenome().pegarConteudo(),
							criarUsuarioPainel.getDataNascimento().pegarData(),
							criarUsuarioPainel.getSexo().selecionado(), criarUsuarioPainel.getEmail().getText(), criarUsuarioPainel.getSenha().pegarConteudo());
					cdi.adicionarUsuario(usuario);
					getPersistencia().salvarPersistencia(cdi);
					dispose();
					new JanelaDeAvisoPadrao("Usuário cadastrado com sucesso!", new JanelaLogin());
				} catch (Exception e2) {
					e2.printStackTrace();
				}
    	}
    }
}