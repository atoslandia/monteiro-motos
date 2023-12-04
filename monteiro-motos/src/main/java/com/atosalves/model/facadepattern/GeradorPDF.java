package com.atosalves.model.facadepattern;

import com.atosalves.dto.PassageiroBoletoDTO;
import com.itextpdf.text.Document;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;
import java.io.FileOutputStream;
import java.io.OutputStream;

class GeradorPDF {

	public static String gerarBoletoPDF(PassageiroBoletoDTO passageiro, float valor) throws Exception {
		String pdfPath = "boleto.pdf";

		Document doc = new Document(PageSize.A4, 72, 72, 72, 72);
		OutputStream os = new FileOutputStream(pdfPath);
		PdfWriter.getInstance(doc, os);
		doc.open();

		Paragraph titulo = new Paragraph("MONTEIRO-MOTOS BOLETO", FontFactory.getFont(FontFactory.HELVETICA_BOLD, 17));
		titulo.setAlignment(Paragraph.ALIGN_CENTER);
		doc.add(titulo);

		Paragraph cliente = new Paragraph(
			30f,
			"Cliente: " + passageiro.nome(),
			FontFactory.getFont(FontFactory.HELVETICA, 12)
		);
		cliente.setAlignment(Paragraph.ALIGN_LEFT);
		doc.add(cliente);

		Paragraph valorTotal = new Paragraph(
			30f,
			"Valor total: " + valor + " R$",
			FontFactory.getFont(FontFactory.HELVETICA, 12)
		);
		valorTotal.setAlignment(Paragraph.ALIGN_LEFT);
		doc.add(valorTotal);

		doc.close();
		os.close();

		return pdfPath;
	}
}
