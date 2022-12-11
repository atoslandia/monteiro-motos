package projeto_poo.paineis;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

import projeto_poo.Sexo;
import projeto_poo.Usuario;
import projeto_poo.botoes.BotaoConcluir;
import projeto_poo.botoes.BotaoVoltar;
import projeto_poo.diversos.TextoImagemPadrao;

public class PainelEditarPerfil extends PainelEntradas{
	
	private Usuario usuario;
	private BotaoVoltar voltar;
	private BotaoConcluir concluir;
	
	public PainelEditarPerfil(Usuario usuario) {
		this.usuario = usuario;
		botoes();
		valores();
		logo();
		add(getFundoPadrao());
	}
	
	private void botoes() {
		concluir = new BotaoConcluir();
		add(concluir);
		
		voltar = new BotaoVoltar();
		add(voltar);
	}
	
	private void valores() {
		getNome().setText(usuario.getNome());
		getSobrenome().setText(usuario.getSobrenome());
		getEmail().setText(usuario.getEmail());
		getEmail().setEnabled(false);
		getSenha().setText(usuario.getSenha());
		if(usuario.getSexo().equals(Sexo.FEMININO))
			getSexo().getFeminino().setSelected(true);
		else
			getSexo().getMasculino().setSelected(true);
		getDataNascimento().getDia().setSelectedItem(Integer.toString(usuario.getDataNascimento().getDayOfMonth()));
		getDataNascimento().getMes().setSelectedItem(Integer.toString(usuario.getDataNascimento().getMonth().getValue()));
		getDataNascimento().getAno().setSelectedItem(Integer.toString(usuario.getDataNascimento().getYear()));
	}
	
	private void logo() {
		JLabel logo = new TextoImagemPadrao(new ImageIcon("imgs/editarperfil.png"));
		logo.setBounds(30, 30, 309, 31);
		add(logo);
	}

	public BotaoVoltar getVoltar() {
		return voltar;
	}

	public BotaoConcluir getConcluir() {
		return concluir;
	}
	
}
