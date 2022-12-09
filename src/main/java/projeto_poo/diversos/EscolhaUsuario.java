package projeto_poo.diversos;

import java.time.LocalDate;

import javax.swing.ButtonGroup;
import javax.swing.JRadioButton;

import projeto_poo.Mototaxista;
import projeto_poo.Passageiro;
import projeto_poo.Sexo;
import projeto_poo.Usuario;
import projeto_poo.erros.CaixaVaziaException;

public class EscolhaUsuario extends JRadioButton {
	private JRadioButton passageiro;
	private JRadioButton mototaxista;
	
	public EscolhaUsuario() {
		setFont(getFont());
		opcoes();
	}
	
	private void opcoes() {
		passageiro = new JRadioButton("Passageiro");
		passageiro.setBounds(140, 265, 100, 20);
		
		mototaxista = new JRadioButton("Mototaxista");
		mototaxista.setBounds(250, 265, 100, 20);
		
		ButtonGroup grupo = new ButtonGroup();
		grupo.getSelection();
		grupo.add(passageiro);
		grupo.add(mototaxista);
	}
	
	public Usuario criarUsuario(String nome, String sobrenome, LocalDate dataNascimento, Sexo sexo, String email, String senha) throws CaixaVaziaException {
		if(passageiro.isSelected())
			return new Passageiro(nome, sobrenome, dataNascimento, sexo, email, senha);
		else if(mototaxista.isSelected())
			return new Mototaxista(nome, sobrenome, dataNascimento, sexo, email, senha);
		throw new CaixaVaziaException();
	}
	
	public void selecionado() throws CaixaVaziaException {
		if(!passageiro.isSelected() && !mototaxista.isSelected())
			throw new CaixaVaziaException();
	}

	public JRadioButton getPassageiro() {
		return passageiro;
	}

	public JRadioButton getMototaxista() {
		return mototaxista;
	}
}
