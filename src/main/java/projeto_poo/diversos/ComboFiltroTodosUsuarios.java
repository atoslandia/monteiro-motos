package projeto_poo.diversos;

import java.awt.Font;

import javax.swing.JComboBox;

public class ComboFiltroTodosUsuarios extends JComboBox<String> {
	public ComboFiltroTodosUsuarios() {
		setFont(new Font("Calibrii", Font.PLAIN, 10));
		setBounds(80, 85, 180, 20);
		addItem("Todos usuários");
		addItem("Apenas passageiros");
		addItem("Apenas mototaxistas");
	}
}
