package com.atosalves.model.facadepattern;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.OutputStream;

import org.apache.commons.mail.DefaultAuthenticator;
import org.apache.commons.mail.EmailAttachment;
import org.apache.commons.mail.MultiPartEmail;
import org.apache.commons.mail.SimpleEmail;

import com.atosalves.dto.PassageiroBoletoDTO;
import com.atosalves.dto.UsuarioDTO;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.Image;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;

public class MensageiroFacade {

	public static void gerarBoleto(PassageiroBoletoDTO passageiro, float valor) throws Exception {

		Document doc = new Document(PageSize.A4, 72,72,72,72);
		OutputStream os = new FileOutputStream("boleto.pdf");
		PdfWriter.getInstance(doc, os);
		doc.open();
		
		Paragraph titulo = new Paragraph("MONTEIRO-MOTOS BOLETO", FontFactory.getFont(FontFactory.HELVETICA_BOLD, 17));
		titulo.setAlignment(PdfWriter.RUN_DIRECTION_NO_BIDI);
		doc.add(titulo);
		
		Paragraph cliente = new Paragraph(30f,"Cliente: "+passageiro.nome(), FontFactory.getFont(FontFactory.HELVETICA, 12));
		cliente.setAlignment(PdfWriter.RUN_DIRECTION_LTR);
		doc.add(cliente);
		
		Paragraph valorTotal = new Paragraph(30f,"Valor total: "+valor+" R$", FontFactory.getFont(FontFactory.HELVETICA, 12));
		valorTotal.setAlignment(PdfWriter.RUN_DIRECTION_LTR);
		doc.add(valorTotal);

		EmailAttachment anexo = anexarArquivo("boleto.pdf", "boleto.pdf");
		
		doc.close();
		os.close();
		String mensagem = "Enviamos seu boleto, Obrigado pela compra sr. " + passageiro.nome();
		enviarPeloEmail(passageiro.email(), "BOLETO", mensagem, anexo);

		
	}

	public static void enviarCodigo(String destinatario, String corpo) throws Exception{
	
		String mensagem = "Seu codigo é " + corpo;

		enviarPeloEmail(destinatario, "CONFIRME SEU EMAIL", mensagem ,null);  
	}

	private static EmailAttachment anexarArquivo(String path, String nomeDoArquivo){
		EmailAttachment anexo = new EmailAttachment();
		anexo.setPath(path);
		anexo.setDisposition(EmailAttachment.ATTACHMENT);
		anexo.setName(nomeDoArquivo); 
		return anexo;

	}

	private static void enviarPeloEmail(String destinatario, String assunto, String mensagem, EmailAttachment anexo) throws Exception{
		MultiPartEmail email = new MultiPartEmail();
		
		
		email.setHostName("smtp.gmail.com");
		email.setSmtpPort(587);
		email.setAuthenticator(new DefaultAuthenticator("pombomensageiro489@gmail.com", "orxk xuht bvlr unrd"));
		email.setSSLOnConnect(true);
		email.setSubject(assunto);
		
		email.setFrom("pombomensageiro489@gmail.com");
		
		email.addTo(destinatario);
		email.setMsg(mensagem);
		if(anexo != null){
			email.attach(anexo);
		}
		email.send();
	}
}
