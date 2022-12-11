package projeto_poo;

import java.awt.Font;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.OutputStream;

import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.Image;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;

import projeto_poo.erros.NaoExisteXmlException;

public class GeradorDeRelatorios {
	public static void obterSolicitacoesDeCorrida() throws NaoExisteXmlException, Exception {
			Persistencia persistencia = new Persistencia();
			CentralDeInformacoes cdi = persistencia.buscarCentral();
			
			Document doc = new Document(PageSize.A4, 72,72,72,72);
			OutputStream os = new FileOutputStream("relatorio.pdf");
			PdfWriter.getInstance(doc, os);
			doc.open();
			PdfPTable tabela = new PdfPTable(2);
			PdfPCell cabecalho = new PdfPCell(new Paragraph("tabela de passageiros"));
			cabecalho.setColspan(2);
			cabecalho.setBackgroundColor(new BaseColor(205,205,205));
			tabela.addCell(cabecalho);
			
			for(Usuario p: cdi.getTodosOsUsuarios()) {
				if(p instanceof Passageiro) {
					tabela.addCell(p.getNome());
					tabela.addCell(""+cdi.recuperarCorridasDeUmPassageiro(p.getEmail()).size());
				}
			}
			doc.add(tabela);
			doc.close();
			os.close();
	}
	
	public static void gerarBoleto(Usuario usuario, float valor) throws Exception {

		Document doc = new Document(PageSize.A4, 72,72,72,72);
		OutputStream os = new FileOutputStream("boleto.pdf");
		PdfWriter.getInstance(doc, os);
		doc.open();
		
		Paragraph titulo = new Paragraph("MONTEIRO-MOTOS", FontFactory.getFont(FontFactory.HELVETICA_BOLD, 17));
		titulo.setAlignment(PdfWriter.RUN_DIRECTION_NO_BIDI);
		doc.add(titulo);
		
		Paragraph cliente = new Paragraph(30f,"Cliente: "+usuario.getNome()+" "+usuario.getSobrenome(), FontFactory.getFont(FontFactory.HELVETICA, 12));
		cliente.setAlignment(PdfWriter.RUN_DIRECTION_LTR);
		doc.add(cliente);
		
		Paragraph valorTotal = new Paragraph(30f,"Valor total: "+valor+" R$", FontFactory.getFont(FontFactory.HELVETICA, 12));
		valorTotal.setAlignment(PdfWriter.RUN_DIRECTION_LTR);
		doc.add(valorTotal);

		Image boletoGenerico = Image.getInstance("imgs/boleto.png");
		boletoGenerico.scalePercent(67);
		doc.add(boletoGenerico);
		doc.close();
		os.close();
	}
	
}
