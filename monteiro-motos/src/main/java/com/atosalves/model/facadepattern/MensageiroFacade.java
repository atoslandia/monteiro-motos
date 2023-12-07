package com.atosalves.model.facadepattern;

import com.atosalves.dto.usuario.GerenciadorDePagamentoDTO;
import com.atosalves.dto.usuario.PassageiroBoletoDTO;

public class MensageiroFacade {

	private static EmailService emailService = new EmailService();
	private static GeradorPDF geradorPDF = new GeradorPDF();

	public static void enviarExtratoPorEmail(String destinatario, GerenciadorDePagamentoDTO passageiroDTO){
		String pdfPath = geradorPDF.gerarExtrato(passageiroDTO);
		emailService.enviarEmailComAnexo(destinatario, "EXTRATO",
		"Seu historico de pagamentos e depositos :)", pdfPath);
	}

	public static void enviarBoletoPorEmail(PassageiroBoletoDTO passageiro, float valor) {
			String pdfPath = geradorPDF.gerarBoletoPDF(passageiro, valor);
			emailService.enviarEmailComAnexo(
				passageiro.email(),
				"BOLETO",
				"Enviamos seu boleto, Obrigado pela compra sr. " + passageiro.nome(),
				pdfPath
			);
	}

	public static void enviarCodigoPorEmail(String destinatario, String corpo) throws RuntimeException {
		emailService.enviarEmail(destinatario, "CONFIRME SEU EMAIL", "Seu código é " + corpo);
	}
}
