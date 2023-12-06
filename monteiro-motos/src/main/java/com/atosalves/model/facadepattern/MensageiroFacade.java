package com.atosalves.model.facadepattern;

import com.atosalves.dto.PassageiroBoletoDTO;
import com.atosalves.dto.GerenciadorDePagamentoDTO;

public class MensageiroFacade {

	public static void enviarExtratoPorEmail(String destinatario, GerenciadorDePagamentoDTO passageiroDTO){
		String pdfPath = GeradorPDF.gerarExtrato(passageiroDTO);
		EmailService.enviarEmailComAnexo(destinatario, "EXTRATO",
		"Seu historico de pagamentos e depositos :)", pdfPath);
	}

	public static void enviarBoletoPorEmail(PassageiroBoletoDTO passageiro, float valor) {
			String pdfPath = GeradorPDF.gerarBoletoPDF(passageiro, valor);
			EmailService.enviarEmailComAnexo(
				passageiro.email(),
				"BOLETO",
				"Enviamos seu boleto, Obrigado pela compra sr. " + passageiro.nome(),
				pdfPath
			);
	}

	public static void enviarCodigoPorEmail(String destinatario, String corpo) throws RuntimeException {
		EmailService.enviarEmail(destinatario, "CONFIRME SEU EMAIL", "Seu código é " + corpo);
	}
}
