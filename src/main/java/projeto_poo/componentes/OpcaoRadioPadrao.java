package projeto_poo.componentes;

import javax.swing.JRadioButton;

public class OpcaoRadioPadrao extends JRadioButton{
	public OpcaoRadioPadrao(String nome) {
		setText(nome);
		setFont(getFont());
	}
}
