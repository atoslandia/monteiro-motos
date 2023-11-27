package com.atosalves.view.main;

import com.atosalves.view.componentes.componentesafactory.ComponentesFactoryImpl;
import com.atosalves.view.janelas.JanelaPrincipal;
import com.atosalves.view.paineis.Painel;
import com.atosalves.view.painelabstractfactory.PainelFactory;
import com.atosalves.view.painelabstractfactory.PainelFactoryImpl;
import javax.swing.SwingUtilities;

public class Main {

	public static void main(String[] args) {
		SwingUtilities.invokeLater(() -> {
			ComponentesFactoryImpl componenetesFactory = new ComponentesFactoryImpl();
			PainelFactory painelFactory = new PainelFactoryImpl(componenetesFactory);

			Painel loginPainel = painelFactory.loginPainel();
			Painel cadastroPainel = painelFactory.cadastroPainel();
			// MENU
			Painel inicioMenuPainel = painelFactory.inicioMenuPainel();
			Painel corridasMenuPainel = painelFactory.corridasMenuPainel();
			Painel editarMenuPainel = painelFactory.editarMenuPainel();

			JanelaPrincipal janela = new JanelaPrincipal(loginPainel);

			// BOTOES LOGIN
			loginPainel
				.getBotao("CADASTRO")
				.aoClicar(() -> {
					janela.setPainel(cadastroPainel);
				});
			loginPainel
				.getBotao("LOGIN")
				.aoClicar(() -> {
					janela.setPainel(inicioMenuPainel);
				});

			// BOTOES CADASTRO
			cadastroPainel
				.getBotao("VOLTAR")
				.aoClicar(() -> {
					janela.setPainel(loginPainel);
				});
			cadastroPainel
				.getBotao("CADASTRAR")
				.aoClicar(() -> {
					janela.setPainel(inicioMenuPainel);
				});

			// BOTOES CORRIDAS
			corridasMenuPainel
				.getBotao("SAIR")
				.aoClicar(() -> {
					janela.setPainel(loginPainel);
				});
			corridasMenuPainel
				.getBotao("INICIO")
				.aoClicar(() -> {
					janela.setPainel(inicioMenuPainel);
				});
			corridasMenuPainel
				.getBotao("EDITAR")
				.aoClicar(() -> {
					janela.setPainel(editarMenuPainel);
				});
			// BOTOES EDITAR
			editarMenuPainel
				.getBotao("SAIR")
				.aoClicar(() -> {
					janela.setPainel(loginPainel);
				});
			editarMenuPainel
				.getBotao("INICIO")
				.aoClicar(() -> {
					janela.setPainel(inicioMenuPainel);
				});
			editarMenuPainel
				.getBotao("CORRIDAS")
				.aoClicar(() -> {
					janela.setPainel(corridasMenuPainel);
				});
		});
	}
}
