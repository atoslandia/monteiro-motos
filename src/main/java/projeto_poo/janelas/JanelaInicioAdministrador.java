package projeto_poo.janelas;

import javax.swing.ImageIcon;

import projeto_poo.botoes.BotaoPadrao;
import projeto_poo.paineis.PainelInicio;

public class JanelaInicioAdministrador extends JanelaPadrao{
	
	private Inicio inicio;
	
	public JanelaInicioAdministrador() {
		super("Monteiro-motos - Administrador");
		add(inicio = new Inicio());
		setVisible(true);
	}
	
	private class Inicio extends PainelInicio{
		public Inicio() {
			super();
		}
	}
	
}
