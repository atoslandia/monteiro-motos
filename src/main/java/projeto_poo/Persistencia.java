package projeto_poo;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.DomDriver;
import com.thoughtworks.xstream.security.AnyTypePermission;

public class Persistencia {
	
	private XStream sx = new XStream(new DomDriver("UTF-8"));
	private File arquivo;
	
	public void salvarCentral(CentralDeInformacoes cdi, String nomeDoArquivo) {
		arquivo = new File(nomeDoArquivo);
		try {
			arquivo.createNewFile();
			PrintWriter pw = new PrintWriter(arquivo);
			String xml = sx.toXML(cdi);
			pw.print(xml);
			pw.close();
		} catch (IOException e) {e.printStackTrace();}
	}
	
	public CentralDeInformacoes recuperarCentral(String nomeDoArquivo) throws Exception {
		arquivo = new File(nomeDoArquivo);
		if(arquivo.exists()) {
			FileInputStream fis = new FileInputStream(arquivo);
			sx.addPermission(AnyTypePermission.ANY);
			return (CentralDeInformacoes) sx.fromXML(fis);
			}
		return new CentralDeInformacoes();
	}
}
