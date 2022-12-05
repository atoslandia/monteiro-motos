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
	
	XStream xs = new XStream(new DomDriver());
	File arquivo;
	
	public void salvarPersistencia(CentralDeInformacoes pessoa) throws Exception {
		arquivo = new File("persistencia.xml");
		xs.addPermission(AnyTypePermission.ANY);
		xs.alias("CentralDeInformacoes", CentralDeInformacoes.class);
		PrintWriter escrever = new PrintWriter(arquivo);
		String xml = xs.toXML(pessoa);
		escrever.print(xml);
		escrever.close();
	}
	
	public CentralDeInformacoes buscarCentral() throws Exception {
		arquivo = new File("persistencia.xml");
		if(arquivo.exists()) {
			FileReader ler = new FileReader("persistencia.xml");
			xs.addPermission(AnyTypePermission.ANY);
			xs.alias("CentralDeInformacoes", CentralDeInformacoes.class);
			CentralDeInformacoes dados = (CentralDeInformacoes)xs.fromXML(ler);
			return dados;
		}
		throw new Exception();
	}
}
