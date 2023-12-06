package com.atosalves.model.facadepattern;

import com.atosalves.dto.PassageiroBoletoDTO;

public class MensageiroFacade {

	public static void enviarBoletoPorEmail(PassageiroBoletoDTO passageiro, float valor) {
		try {
			String pdfPath = GeradorPDF.gerarBoletoPDF(passageiro, valor);
			EmailService.enviarEmailComAnexo(
				passageiro.email(),
				"BOLETO",
				"Enviamos seu boleto, Obrigado pela compra sr. " + passageiro.nome(),
				pdfPath
			);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	public static void enviarCodigoPorEmail(String destinatario, String corpo) throws RuntimeException {
		EmailService.enviarEmail(destinatario, "CONFIRME SEU EMAIL", "Seu código é " + corpo);
	}
}
