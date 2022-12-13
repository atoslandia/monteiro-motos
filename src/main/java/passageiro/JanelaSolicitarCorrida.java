package passageiro;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Calendar;
import java.util.Locale;
import java.util.TimeZone;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JTextField;

import projeto_poo.CentralDeInformacoes;
import projeto_poo.Corrida;
import projeto_poo.Destino;
import projeto_poo.Passageiro;
import projeto_poo.PontoDeEncontro;
import projeto_poo.Sexo;
import projeto_poo.Usuario;
import projeto_poo.botoes.BotaoAgendar;
import projeto_poo.botoes.BotaoProsseguir;
import projeto_poo.botoes.BotaoSolicitar;
import projeto_poo.botoes.BotaoVoltar;
import projeto_poo.caixas.CaixaCEPNumero;
import projeto_poo.caixas.CaixaDistancia;
import projeto_poo.caixas.CaixaTextoPadrao;
import projeto_poo.diversos.ComboDataNascimento;
import projeto_poo.diversos.TextoImagemPadrao;
import projeto_poo.erros.CaixaVaziaException;
import projeto_poo.erros.CorridaExistenteException;
import projeto_poo.erros.CorridaNaoExisteException;
import projeto_poo.erros.NaoExisteXmlException;
import projeto_poo.janelas.JanelaDeAvisoPadrao;
import projeto_poo.janelas.JanelaLogin;
import projeto_poo.janelas.JanelaPadrao;
import projeto_poo.paineis.PainelPadrao;
import projeto_poo.paineis.PainelSolicitarCorrida;

public class JanelaSolicitarCorrida extends JanelaPadrao {
	
	private Passageiro passageiro;
	
	private PainelDestino painelDestino;
	private PainelPontoDeEncontro painelPontoDeEncontro;
	private PainelAgendar painelAgendar;
	
	ComboDataNascimento dataMarcada;
	private PontoDeEncontro enderecoPontoDeEncontro;
	private Destino enderecoDestino;
	
	private CaixaDistancia distancia;
	

	public JanelaSolicitarCorrida(Passageiro passageiro) {
		super("Ponto de encontro");
		this.passageiro = passageiro;
		add(painelPontoDeEncontro = new PainelPontoDeEncontro());
		setVisible(true);
	}
	
	private class PainelPontoDeEncontro extends PainelSolicitarCorrida{
		
		public PainelPontoDeEncontro() {
			botaoVoltar();
			botaoProceguir();
			logo();
			add(getFundoPadrao());
		}
		
		private void logo() {
			JLabel logo = new TextoImagemPadrao(new ImageIcon("imgs/passageiro/pontodeencontro.png"));
			logo.setBounds(30, 30, 474, 32);
			add(logo);
		}
		
		private void botaoProceguir() {
			BotaoProsseguir botao = new BotaoProsseguir();
			botao.addActionListener(new OuvinteBotaoProsseguir());
			add(botao);
		}
		private void botaoVoltar() {
			BotaoVoltar botao = new BotaoVoltar();
			botao.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					dispose();
					new JanelaPrincipalPassageiro(passageiro);
				}
			});
			add(botao);
		}
	
	}
	
	private class PainelDestino extends PainelSolicitarCorrida{
		public PainelDestino() {
			caixaDistancia();
			botoes();
			logo();
			add(getFundoPadrao());
		}
		
		private void logo() {
			JLabel logo = new TextoImagemPadrao(new ImageIcon("imgs/passageiro/destino.png"));
			logo.setBounds(30, 30, 474, 32);
			add(logo);
		}
		
		private void caixaDistancia() {
			TextoImagemPadrao textoDistancia = new TextoImagemPadrao("Distancia (Km): ");
			textoDistancia.setBounds(30, 235, 100, 19);
			add(textoDistancia);
			
			distancia = new CaixaDistancia();
			distancia.setBounds(130, 235, 220, 19);
			add(distancia);
		}
		
		private void botoes() {
			BotaoSolicitar solicitar = new BotaoSolicitar();
			solicitar.addActionListener(new OuvinteBotaoSolicitar());
			add(solicitar);
			
			BotaoAgendar agendar = new BotaoAgendar();
			agendar.addActionListener(new OuvinteBotaoAgendar());
			add(agendar);
			
			BotaoVoltar botao = new BotaoVoltar();
			botao.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					setVisible(false);
					painelPontoDeEncontro.setVisible(true);
				}
			});
			add(botao);
		}
		
	}
	
	private class PainelAgendar extends PainelPadrao{
		public PainelAgendar() {
			add(getFundoPadrao());
			botaoProsseguir();
			botaoVoltar();
			agendamento();	
		}
		private void agendamento() {
			TextoImagemPadrao dia = new TextoImagemPadrao("Dia: ");
			dia.setBounds(30, 85, 100, 19);
			TextoImagemPadrao mes = new TextoImagemPadrao("Mes: ");
			mes.setBounds(30, 129, 100, 19);
			TextoImagemPadrao ano = new TextoImagemPadrao("Ano: ");
			ano.setBounds(30, 173, 100, 19);
			dataMarcada = new ComboDataNascimento();
			dataMarcada.getDia().setBounds(130, 85, 220, 19);
			dataMarcada.getMes().setBounds(130,129,220,19);
			dataMarcada.getAno().setBounds(130, 173, 220, 19);
			add(ano);
			add(dia);
			add(mes);
			add(dataMarcada.getDia());
			add(dataMarcada.getMes());
			add(dataMarcada.getAno());
		}
		
		
		private void botaoProsseguir() {
			BotaoProsseguir botao = new BotaoProsseguir();
			botao.addActionListener(new OuvinteBotaoProsseguirAgendar());
			add(botao);
		}
		private void botaoVoltar() {
			BotaoVoltar botao = new BotaoVoltar();
			botao.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					setVisible(false);
					painelDestino.setVisible(true);
				}
			});
			add(botao);
		}
	}
	
	private class OuvinteBotaoProsseguir implements ActionListener {
		
		public void actionPerformed(ActionEvent e) {
			try {
				add(painelDestino = new PainelDestino());

				getAvisoPreencherDados().setVisible(false);
				
				String endereco = painelPontoDeEncontro.getEndereco().pegarConteudo();
				String CEP = painelPontoDeEncontro.getCEP().pegarConteudo();
				String bairro = painelPontoDeEncontro.getBairro().pegarConteudo();
				int numero = Integer.parseInt(painelPontoDeEncontro.getNumero().pegarConteudo());
				String complemento = painelPontoDeEncontro.getComplemento().getText();
				
				enderecoPontoDeEncontro = new PontoDeEncontro(endereco, CEP, numero, bairro, complemento);
				painelPontoDeEncontro.setVisible(false);
			} catch (CaixaVaziaException e1) {
				getAvisoPreencherDados().setVisible(true);	
			}
		}
	}
	
	private class OuvinteBotaoProsseguirAgendar implements ActionListener{

		public void actionPerformed(ActionEvent e) {
			try {
				getAvisoPreencherDados().setVisible(false);
				
				String endereco = painelDestino.getEndereco().pegarConteudo();
				String CEP = painelDestino.getCEP().pegarConteudo();
				String bairro = painelDestino.getBairro().pegarConteudo();
				int numero = Integer.parseInt(painelDestino.getNumero().pegarConteudo());
				String complemento = painelDestino.getComplemento().getText();
				float caixaDistancia = Float.parseFloat(distancia.pegarConteudo());
				
				enderecoDestino = new Destino(endereco, CEP, numero, bairro, complemento, caixaDistancia);
				Corrida corrida = new Corrida(enderecoPontoDeEncontro, enderecoDestino, passageiro);
				
				corrida.setAgendamento(dataMarcada.pegarData());
				corrida.setEstadoDaCorrida("Em espera");
				
				CentralDeInformacoes cdi = getPersistencia().buscarCentral();
				cdi.adicionarCorrida(corrida);
				getPersistencia().salvarPersistencia(cdi);
				new JanelaDeAvisoPadrao("<html>"+"Corrida solicitada com sucesso!"+"<br>"+"Aguarde a reinvidicação no local e "+"<br>"+"na data marcada."+"</html>", new JanelaPrincipalPassageiro(passageiro));
			} catch (CaixaVaziaException e1) {
				getAvisoPreencherDados().setVisible(true);
			} catch (CorridaExistenteException e2) {
				e2.printStackTrace();
				new JanelaDeAvisoPadrao(e2.getMessage());
			} catch (Exception e1) {
				e1.printStackTrace();
			}
		}
		
	}
	
	private class OuvinteBotaoSolicitar implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			try {
				getAvisoPreencherDados().setVisible(false);
				
				String endereco = painelDestino.getEndereco().pegarConteudo();
				String CEP = painelDestino.getCEP().pegarConteudo();
				String bairro = painelDestino.getBairro().pegarConteudo();
				int numero = Integer.parseInt(painelDestino.getNumero().pegarConteudo());
				String complemento = painelDestino.getComplemento().getText();
				float caixaDistancia = Float.parseFloat(distancia.pegarConteudo());
				
				enderecoDestino = new Destino(endereco, CEP, numero, bairro, complemento, caixaDistancia);
				Corrida corrida = new Corrida(enderecoPontoDeEncontro,enderecoDestino, passageiro);

				corrida.setEstadoDaCorrida("Em espera");
				
				CentralDeInformacoes cdi = getPersistencia().buscarCentral();
				cdi.adicionarCorrida(corrida);
				getPersistencia().salvarPersistencia(cdi);
				new JanelaDeAvisoPadrao("<html>"+"Corrida solicitada com sucesso!"+"<br>"+"Aguarde a reinvidicação no local."+"</html>", new JanelaPrincipalPassageiro(passageiro));
			} catch (CaixaVaziaException e1) {
				getAvisoPreencherDados().setVisible(true);
			} catch (CorridaExistenteException e2) {
				e2.printStackTrace();
				new JanelaDeAvisoPadrao(e2.getMessage());
			} catch (Exception e1) {
				e1.printStackTrace();
			}
			
		}
		
	}
	
	private class OuvinteBotaoAgendar implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			painelDestino.setVisible(false);
			add(painelAgendar = new PainelAgendar());
		}
	}
}
