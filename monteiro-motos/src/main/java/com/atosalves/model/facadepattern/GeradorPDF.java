package com.atosalves.model.facadepattern;

import com.atosalves.dto.PassageiroBoletoDTO;
import com.atosalves.dto.GerenciadorDePagamentoDTO;
import com.atosalves.model.GerenciadorDePagamento;
import com.atosalves.model.OperacaoFinanceira;
import com.itextpdf.text.Document;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.util.ArrayList;


class GeradorPDF {

	public static String gerarExtrato(GerenciadorDePagamentoDTO passageiro) {
		String pdfPath = "extrato.pdf";

		GerenciadorDePagamento gerenciadorDePagamento = passageiro.gerenciadorDePagamento();
		ArrayList<OperacaoFinanceira> depositos = gerenciadorDePagamento.getHistoricoDepositos();
		ArrayList<OperacaoFinanceira> pagamentos = gerenciadorDePagamento.getHistoricoPagamentos();

        try {
			Document doc = new Document(PageSize.A4, 72,72,72,72);
			OutputStream os = new FileOutputStream(pdfPath);
            PdfWriter.getInstance(doc, os);

            doc.open();

            PdfPTable tabelaDepositos = criarTabela("Depositos");
            adicionarLinhas(tabelaDepositos, pagamentos); 

            PdfPTable tabelaPagamentos = criarTabela("Pagamentos");
            adicionarLinhas(tabelaPagamentos, depositos); 

			doc.add(new Paragraph("EXTRATO GERADO"));
			doc.add(new Paragraph(" "));
            doc.add(tabelaDepositos);
			doc.add(new Paragraph(" "));
            doc.add(tabelaPagamentos);

            doc.close();
			os.close();

			return pdfPath;
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage());
        }
    }

    private static PdfPTable criarTabela(String titulo) {
        PdfPTable table = new PdfPTable(2); // Duas colunas
        table.setWidthPercentage(100);
        PdfPCell cell = new PdfPCell(new Paragraph(titulo));
        cell.setColspan(2);
        table.addCell(cell);
        return table;
    }

    private static void adicionarLinhas(PdfPTable table, ArrayList<OperacaoFinanceira> operacoes) {
        for (OperacaoFinanceira operacao : operacoes) {
            table.addCell(Float.toString(operacao.getValor()));
            table.addCell(operacao.getData().toString());
        }
    }


	public static String gerarBoletoPDF(PassageiroBoletoDTO passageiro, float valor) {
		try {

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
		} catch (Exception e) {
			throw new RuntimeException();
		}
	}
}
