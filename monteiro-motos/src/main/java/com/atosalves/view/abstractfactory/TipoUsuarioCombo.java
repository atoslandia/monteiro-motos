package com.atosalves.view.abstractfactory;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;

public class TipoUsuarioCombo extends JComboBox<TiposUsuarios> {

	public TipoUsuarioCombo(TiposUsuarios[] tipos) {
		setModel(new DefaultComboBoxModel<TiposUsuarios>(tipos));
	}
}
