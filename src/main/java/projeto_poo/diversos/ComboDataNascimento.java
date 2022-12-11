package projeto_poo.diversos;

import java.awt.Font;
import java.time.LocalDate;
import java.time.Period;

import javax.swing.JComboBox;

import projeto_poo.erros.MenorDeIdadeException;

public class ComboDataNascimento extends JComboBox<String>{
	
	private JComboBox<String> dia;
	private JComboBox<String> mes;
	private JComboBox<String> ano;
	
	public ComboDataNascimento() {
		setFont(new Font("Calibrii", Font.PLAIN, 10));
		data();
	}
	
	private void data() {
		String[] meses = new String[12];
		String[] dias = new String[31];
		String[] anos = new String[101];
		
		for(int i = 0; i < anos.length; i++) {
			if(i < meses.length)
				meses[i] = Integer.toString(i+1);
			if(i < dias.length)
				dias[i] = Integer.toString(i+1);
			anos[i] = Integer.toString(LocalDate.now().getYear()-i);
		}
		
		dia = new JComboBox<String>(dias);
		dia.setBounds(190, 235, 45, 20);
		
		mes = new JComboBox<String>(meses);
		mes.setBounds(240, 235, 45, 20);
		
		ano = new JComboBox<String>(anos);
		ano.setBounds(290, 235, 60, 20);
		ano.setSelectedIndex(18);
	}
	
	public LocalDate pegarDataNascimento() throws MenorDeIdadeException {
		LocalDate data = LocalDate.of(Integer.parseInt((String)ano.getSelectedItem()), Integer.parseInt((String)mes.getSelectedItem()), Integer.parseInt((String)dia.getSelectedItem()));
		LocalDate dataAtual = LocalDate.now();
		Period periodo = Period.between(data, dataAtual);
		if(periodo.getYears() < 18)
			throw new MenorDeIdadeException();
		return data;
	}
	
	public LocalDate pegarData() {
		return LocalDate.of(Integer.parseInt((String)ano.getSelectedItem()), Integer.parseInt((String)mes.getSelectedItem()), Integer.parseInt((String)dia.getSelectedItem()));
	}

	public JComboBox<String> getDia() {
		return dia;
	}

	public JComboBox<String> getMes() {
		return mes;
	}

	public JComboBox<String> getAno() {
		return ano;
	}
	
}
