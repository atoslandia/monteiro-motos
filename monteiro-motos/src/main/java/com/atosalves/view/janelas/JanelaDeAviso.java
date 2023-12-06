package com.atosalves.view.janelas;

import com.atosalves.dto.LoginDTO;
import com.atosalves.model.facadepattern.MensageiroFacade;
import com.atosalves.view.exception.CampoInvalidoException;
import javax.swing.JOptionPane;

public class JanelaDeAviso extends Janela {

	private String codigoRandom;
	private LoginDTO loginDTO;

	public JanelaDeAviso(String aviso) {
		JOptionPane.showMessageDialog(this, aviso);
	}

	public JanelaDeAviso(LoginDTO loginDTO) throws CampoInvalidoException {
		this.loginDTO = loginDTO;
		compararCodigo();
	}

	private void compararCodigo() throws CampoInvalidoException {
		codigoRandom = Integer.toString((int) (Math.random() * (99999 - 10000 + 1) + 10000));
		MensageiroFacade.enviarCodigoPorEmail(loginDTO.email(), codigoRandom);

		String codigoDoUsuario = JOptionPane.showInputDialog(this, "Digite o código recebido");

		if (codigoRandom.equals(codigoDoUsuario)) {
			JOptionPane.showMessageDialog(this, "Email verificado");
		} else {
			throw new CampoInvalidoException();
		}
	}
}
