package com.atosalves.view.paineis.factorymethod.menu;

import com.atosalves.controller.GerenciadorDeCorrida;
import com.atosalves.controller.UsuarioController;
import com.atosalves.dto.CorridaDTO;
import com.atosalves.dto.LoginDTO;
import com.atosalves.dto.UpdateUsuarioViewDTO;
import com.atosalves.enums.TipoUsuario;
import com.atosalves.view.componentes.ListaDeCorridas;
import com.atosalves.view.componentes.SenhaCaixa;
import com.atosalves.view.componentes.TextoCaixa;
import com.atosalves.view.janelas.JanelaDeAviso;
import com.atosalves.view.janelas.JanelaDeErro;
import com.atosalves.view.paineis.Painel;
import com.atosalves.view.paineis.factorymethod.PainelTemplate;
import com.atosalves.view.paineis.factorymethod.depoisdomenu.CorridasPendentesPainel;
import com.atosalves.view.paineis.factorymethod.depoisdomenu.DepositarSaldoPainel;
import com.atosalves.view.paineis.factorymethod.depoisdomenu.ExtratoPainel;
import com.atosalves.view.paineis.factorymethod.depoisdomenu.MinhaCorridaReinvidicadaPainel;
import com.atosalves.view.paineis.factorymethod.depoisdomenu.detalhescorrida.DetalhadorDeCorridaPainel;
import com.atosalves.view.paineis.factorymethod.depoisdomenu.solicitarcorrida.PontoDeEncontroPainel;
import com.atosalves.view.paineis.factorymethod.inicio.LoginPainel;
import com.atosalves.view.paineis.painelbuilder.PainelBuilder;
import com.atosalves.view.paineis.painelbuilder.PainelBuilderImpl;
import com.atosalves.view.util.Tema;

public class MenuPainel extends PainelTemplate {

	private Painel inicioPainel;
	private Painel corridasPainel;
	private Painel editarPainel;

	private TextoCaixa emailCaixa;
	private TextoCaixa nomeCaixa;
	private SenhaCaixa senhaCaixa;

	private ListaDeCorridas listaDeItems;

	private LoginDTO loginDTO;
	private float avaliacaoMototaxista;

	private GerenciadorDeCorrida gerenciadorDeCorrida;

	public MenuPainel(LoginDTO loginDTO) {
		this.loginDTO = loginDTO;
		gerenciadorDeCorrida = new GerenciadorDeCorrida();
		if (!isPassageiro()) {
			avaliacaoMototaxista = gerenciadorDeCorrida.avaliacaoMediaDoMototaxista(loginDTO);
		}
	}

	private void solicitarCorridaBotao() {
		painel.setPainel(new PontoDeEncontroPainel(loginDTO).criarPainel());
	}

	private void depositarBotao() {
		painel.setPainel(new DepositarSaldoPainel(loginDTO).criarPainel());
	}

	private void saldoBotao() {
		painel.setPainel(new ExtratoPainel(loginDTO).criarPainel());
	}

	private void detalharCorrida() {
		painel.setPainel(new DetalhadorDeCorridaPainel(loginDTO, listaDeItems.pegarSelecionado()).criarPainel());
	}

	private void corridasPendentesBotao() {
		painel.setPainel(new CorridasPendentesPainel(loginDTO).criarPainel());
	}

	private CorridaDTO[] listarCorridas() {
		return gerenciadorDeCorrida.buscarHistoricoDeCorridas(loginDTO);
	}

	private void excluirContaBotao() {
		// TODO: fazer um painel de confirmação
		UsuarioController usuarioController = new UsuarioController();
		usuarioController.excluirUsuario(loginDTO.email());
		new JanelaDeAviso("Conta excluída com sucesso");
		sairBotao();
	}

	private void editarContaBotao() {
		try {
			String nome = nomeCaixa.pegarCampo();
			String senha = senhaCaixa.pegarCampo();
			UpdateUsuarioViewDTO updateUsuarioDTO = new UpdateUsuarioViewDTO(nome, senha);

			UsuarioController usuarioController = new UsuarioController();
			usuarioController.editar(updateUsuarioDTO, loginDTO.email());
			new JanelaDeAviso("Editado com sucesso");
		} catch (Exception e) {
			new JanelaDeErro(e);
		}
	}

	private void minhaCorridaBotao() {
		painel.setPainel(new MinhaCorridaReinvidicadaPainel(loginDTO).criarPainel());
	}

	@Override
	public void inicializarComponentes() {
		listaDeItems = COMPONENTES_FACTORY.criarListaDeItems(listarCorridas());
		emailCaixa = COMPONENTES_FACTORY.criarCaixaTexto();
		nomeCaixa = COMPONENTES_FACTORY.criarCaixaTexto();
		senhaCaixa = COMPONENTES_FACTORY.criarCaixaSenha();
	}

	@Override
	public void construirPainel() {
		inicioPainel();
		corridasPainel();
		editarPainel();

		painel = new PainelBuilderImpl().addPainel(inicioPainel).addPainel(corridasPainel).addPainel(editarPainel).construir();
	}

	private void inicioPainel() {
		PainelBuilder builder = new PainelBuilderImpl().setTexto("BEM VINDO(A)", Tema.FONTE_MUITO_FORTE);

		if (isPassageiro()) {
			builder.setBotao("SOLICITAR CORRIDA", this::solicitarCorridaBotao).setBotao("DEPOSITAR", this::depositarBotao);
		} else {
			builder
				.setTexto("MINHA AVALIAÇÃO: " + avaliacaoMototaxista, Tema.FONTE_NORMAL)
				.setBotao("CORRIDAS PENDENTES", this::corridasPendentesBotao)
				.setBotao("MINHA CORRIDA", this::minhaCorridaBotao);
		}

		inicioPainel =
			builder
				.setBotaoMenu("INICIO", this::inicioBotao, false)
				.setBotaoMenu("CORRIDAS", this::corridasBotao, true)
				.setBotaoMenu("PERFIL", this::editarBotao, true)
				.setBotao("SALDO", this::saldoBotao)
				.construir();
	}

	private void corridasPainel() {
		corridasPainel =
			new PainelBuilderImpl()
				.setTexto("HISTÓRICO DE CORRIDAS", Tema.FONTE_MUITO_FORTE)
				.setListaDeItems(listaDeItems, this::detalharCorrida)
				.setBotaoMenu("INICIO", this::inicioBotao, true)
				.setBotaoMenu("CORRIDAS", this::corridasBotao, false)
				.setBotaoMenu("PERFIL", this::editarBotao, true)
				.construir();
		corridasPainel.setVisible(false);
	}

	private void editarPainel() {
		editarPainel =
			new PainelBuilderImpl()
				.setTexto("EDITAR PERFIL", Tema.FONTE_MUITO_FORTE)
				.setBotaoMenu("INICIO", this::inicioBotao, true)
				.setBotaoMenu("CORRIDAS", this::corridasBotao, true)
				.setBotaoMenu("PERFIL", this::editarBotao, false)
				.setTextoCaixa("EMAIL", emailCaixa)
				.setTextoCaixa("NOME", nomeCaixa)
				.setSenhaCaixa(senhaCaixa)
				.setBotao("EDITAR", this::editarContaBotao)
				.setBotao("EXCLUIR CONTA", this::excluirContaBotao)
				.setBotao("SAIR", this::sairBotao)
				.construir();

		emailCaixa.setEnabled(false);
		emailCaixa.setText(loginDTO.email());
		nomeCaixa.setText(new UsuarioController().buscarNomeUsuario(loginDTO.email()));
		senhaCaixa.setText(loginDTO.senha());

		editarPainel.getBotao("SAIR").setBounds(630, 10, 100, 35);
		editarPainel.setVisible(false);
	}

	private void sairBotao() {
		painel.setPainel(new LoginPainel().criarPainel());
	}

	private void inicioBotao() {
		inicioPainel.setVisible(true);
		corridasPainel.setVisible(false);
		editarPainel.setVisible(false);
		painel.repaint();
	}

	private void corridasBotao() {
		inicioPainel.setVisible(false);
		corridasPainel.setVisible(true);
		editarPainel.setVisible(false);
		painel.repaint();
	}

	private void editarBotao() {
		inicioPainel.setVisible(false);
		corridasPainel.setVisible(false);
		editarPainel.setVisible(true);
		painel.repaint();
	}

	private boolean isPassageiro() {
		return loginDTO.tipoUsuario().equals(TipoUsuario.PASSAGEIRO);
	}
}
