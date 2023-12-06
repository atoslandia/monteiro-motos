package com.atosalves.view.componentes;

import com.atosalves.view.exception.CampoInvalidoException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class EmailCaixa extends TextoCaixa {

	private String EMAIL_PATTERN = "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@" + "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";
	private Pattern pattern = Pattern.compile(EMAIL_PATTERN, Pattern.CASE_INSENSITIVE);

	private boolean isValido(String email) {
		Matcher matcher = pattern.matcher(email);
		return matcher.matches();
	}

	@Override
	public String pegarCampo() throws CampoInvalidoException {
		if (isValido(super.pegarCampo())) {
			return super.pegarCampo();
		} else {
			throw new CampoInvalidoException();
		}
	}
}
