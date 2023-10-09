package com.atosalves.view.componentes;

import com.atosalves.enums.TiposUsuario;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;

public class TipoUsuarioCombo extends JComboBox<TiposUsuario> {

	public TipoUsuarioCombo(TiposUsuario[] tipos) {
		setModel(new DefaultComboBoxModel<TiposUsuario>(tipos));
	}
}
