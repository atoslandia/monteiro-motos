package com.atosalves.view.componentes;

import com.atosalves.enums.TipoUsuario;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;

public class TipoUsuarioCombo extends JComboBox<TipoUsuario> {

	public TipoUsuarioCombo(TipoUsuario[] tipos) {
		setModel(new DefaultComboBoxModel<TipoUsuario>(tipos));
	}

	public TipoUsuario pegarSelecionado() {
		return (TipoUsuario) getSelectedItem();
	}
}
