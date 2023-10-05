package com.atosalves.view.abstractfactory;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;

public class TipoUsuarioCombo extends JComboBox<TiposUsuario> {

	public TipoUsuarioCombo(TiposUsuario[] tipos) {
		setModel(new DefaultComboBoxModel<TiposUsuario>(tipos));
	}
}
