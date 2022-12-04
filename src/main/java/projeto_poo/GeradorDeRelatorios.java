package projeto_poo;

import java.io.FileOutputStream;
import java.io.OutputStream;

import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Document;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;

public class GeradorDeRelatorios {
//	public static void obterSolicitacoesDeCorrida() {
//		Persistencia persistencia = new Persistencia();
//		CentralDeInformacoes recuperarCdi = persistencia.recuperarCentral("backup.xml");
//		try {
//			Document doc = new Document(PageSize.A4, 72,72,72,72);
//			OutputStream os = new FileOutputStream("relatorio.pdf");
//			PdfWriter.getInstance(doc, os);
//			doc.open();
//			PdfPTable tabela = new PdfPTable(2);
//			PdfPCell cabecalho = new PdfPCell(new Paragraph("tabela de passageiros"));
//			cabecalho.setColspan(2);
//			cabecalho.setBackgroundColor(new BaseColor(205,205,205));
//			tabela.addCell(cabecalho);
//			for(Passageiro p: recuperarCdi.getTodosOsPassageiros()) {
//				tabela.addCell(p.getNome());
//				tabela.addCell(""+recuperarCdi.recuperarCorridasDeUmPassageiro(p.getEmail()).size());
//			}
//			doc.add(tabela);
//			doc.close();
//			os.close();
//		}catch (Exception e) {e.printStackTrace();}
//	}
}
