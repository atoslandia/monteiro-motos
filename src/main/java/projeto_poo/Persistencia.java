package projeto_poo;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.DomDriver;
import com.thoughtworks.xstream.security.AnyTypePermission;

public class Persistencia {
	
	
//	public void salvarCentral(CentralDeInformacoes cdi, String nomeDoArquivo) {
//		arquivo = new File(nomeDoArquivo);
//		try {
//			arquivo.createNewFile();
//			PrintWriter pw = new PrintWriter(arquivo);
//			String xml = xs.toXML(cdi);
//			pw.print(xml);
//			pw.close();
//		} catch (IOException e) {e.printStackTrace();}
//	}
	
	public void gerarXML(CentralDeInformacoes adm) throws Exception {
		XStream xs = new XStream(new DomDriver());
		xs.addPermission(AnyTypePermission.ANY);
		xs.alias("CentralDeInformacoes", CentralDeInformacoes.class);
		String xml = xs.toXML(adm);
		File arquivo = new File("persistencia.xml");
		
		PrintWriter escrever = new PrintWriter(arquivo);
		escrever.print(xml);
		escrever.flush();
		escrever.close();
	}
	
	public CentralDeInformacoes buscarCentral(/*String nomeDoArquivo*/) throws Exception {
		FileReader ler = new FileReader("persistencia.xml");
		XStream xs = new XStream(new DomDriver());
		xs.addPermission(AnyTypePermission.ANY);
		xs.alias("CentralDeInformacoes", CentralDeInformacoes.class);
		CentralDeInformacoes dados = (CentralDeInformacoes)xs.fromXML(ler);
		return dados;
	}
}
