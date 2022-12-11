package projeto_poo.diversos;

import javax.swing.ButtonGroup;
import javax.swing.JRadioButton;

import projeto_poo.Sexo;
import projeto_poo.erros.CaixaVaziaException;
import projeto_poo.janelas.JanelaPadrao;

public class EscolhaSexo extends JRadioButton {
	
	private JRadioButton feminino;
	private JRadioButton masculino;
	
	public EscolhaSexo() {
		setFont(getFont());
		opcoes();
	}
	
	private void opcoes() {
		feminino = new JRadioButton("Feminino");
		feminino.setBounds(140, 205, 100, 20);
		
		masculino = new JRadioButton("Masculino");
		masculino.setBounds(255, 205, 100, 20);
		
		ButtonGroup grupo = new ButtonGroup();
		grupo.add(feminino);
		grupo.add(masculino);
	}
	
	public Sexo selecionado() throws CaixaVaziaException {
		if(feminino.isSelected())
			return Sexo.FEMININO;
		if(masculino.isSelected())
			return Sexo.MASCULINO;
		throw new CaixaVaziaException();
	}

	public JRadioButton getFeminino() {
		return feminino;
	}

	public JRadioButton getMasculino() {
		return masculino;
	}
	
}
