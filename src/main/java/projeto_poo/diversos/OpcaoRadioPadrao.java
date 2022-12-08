package projeto_poo.diversos;

import javax.swing.ButtonGroup;
import javax.swing.JRadioButton;

import projeto_poo.erros.CaixaVaziaException;

public class OpcaoRadioPadrao extends JRadioButton{
	public OpcaoRadioPadrao(String nome) {
		setText(nome);
		setFont(getFont());
	}
}
