package com.atosalves.view.componentes;

import com.atosalves.controller.GerenciadorDeCorrida;
import com.atosalves.dto.CorridaDTO;
import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;

public class ListaDeCorridas extends JScrollPane {

	private DefaultTableModel items;
	private JTable tabela;

	private Runnable acao;

	public ListaDeCorridas(CorridaDTO[] lista) {
		items = new DefaultTableModel();
		preencherTabela(lista);

		tabela = new JTable(items);

		tabela
			.getSelectionModel()
			.addListSelectionListener(
				new ListSelectionListener() {
					@Override
					public void valueChanged(ListSelectionEvent e) {
						if (!e.getValueIsAdjusting()) {
							pegarSelecionado();
							acao.run();
						}
					}
				}
			);

		setViewportView(tabela);
	}

	private void preencherTabela(CorridaDTO[] lista) {
		items.addColumn("ID DA CORRIDA");
		items.addColumn("PONTO DE ENCONTRO");
		items.addColumn("DESTINO");

		for (CorridaDTO corridaDTO : lista) {
			items.addRow(
				new Object[] {
					corridaDTO.corrida().getId(),
					"rua: " +
					corridaDTO.corrida().getPontoDeEncontro().getRua() +
					", bairro: " +
					corridaDTO.corrida().getPontoDeEncontro().getBairro(),
					"rua: " +
					corridaDTO.corrida().getDestino().getRua() +
					", bairro: " +
					corridaDTO.corrida().getDestino().getBairro(),
				}
			);
		}
	}

	public CorridaDTO pegarSelecionado() {
		int linhaSelecionada = tabela.getSelectedRow();
		DefaultTableModel model = (DefaultTableModel) tabela.getModel();

		Long idCorrida = (Long) model.getValueAt(linhaSelecionada, 0);

		GerenciadorDeCorrida gerenciadorDeCorrida = new GerenciadorDeCorrida();
		CorridaDTO corrida = gerenciadorDeCorrida.getCorridaById(idCorrida);

		return corrida;
	}

	public void aoClicar(Runnable acao) {
		this.acao = acao;
	}
}
