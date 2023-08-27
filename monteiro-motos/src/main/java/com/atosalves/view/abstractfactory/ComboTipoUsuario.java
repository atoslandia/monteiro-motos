package com.atosalves.view.abstractfactory;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;

public class ComboTipoUsuario extends JComboBox<TiposUsuarios> {

	public ComboTipoUsuario(TiposUsuarios[] tipos) {
		setModel(new DefaultComboBoxModel<TiposUsuarios>(tipos));
	}
}
