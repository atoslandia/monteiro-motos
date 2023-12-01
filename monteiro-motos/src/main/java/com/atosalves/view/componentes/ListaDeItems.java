package com.atosalves.view.componentes;

import javax.swing.JList;
import javax.swing.JScrollPane;

public class ListaDeItems extends JScrollPane {

	private JList<Object> jLista;

	public ListaDeItems(Object[] lista) {
		this.jLista = new JList<>(lista);

		setBounds(159, 60, 450, 160);
		setViewportView(this.jLista);
	}

	public Object pegarSelecionado() {
		return jLista.getSelectedValue();
	}
}
