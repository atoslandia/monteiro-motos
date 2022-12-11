package passageiro;

import projeto_poo.Passageiro;
import projeto_poo.janelas.JanelaPadrao;

public class JanelaExcluirPerfil extends JanelaPadrao{
	private Passageiro passageiro;
	
	public JanelaExcluirPerfil(Passageiro passageiro) {
		super("Excluir perfil");
		this.passageiro = passageiro;
		add(getFundoPadrao());
		setVisible(true);
	}

}
