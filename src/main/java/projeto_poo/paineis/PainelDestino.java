package projeto_poo.paineis;

public class PainelDestino extends PainelPadrao {
	public PainelDestino() {
		add(new PainelSolicitarCorrida());
		
		setVisible(true);
	}
}
