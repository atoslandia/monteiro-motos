package com.atosalves.db;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.DomDriver;
import com.thoughtworks.xstream.security.AnyTypePermission;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.PrintWriter;

public class Persistencia {

	private XStream xs = new XStream(new DomDriver());
	private File arquivo;
	private final String nomeDoArquivo = "persistencia.xml";

	public Persistencia() {
		this.arquivo = new File(nomeDoArquivo);
	}

	public void salvarDB(DB dataBase) {
		xs.addPermission(AnyTypePermission.ANY);
		try (PrintWriter escrever = new PrintWriter(arquivo)) {
			xs.autodetectAnnotations(true);
			String xml = xs.toXML(dataBase);
			escrever.print(xml);
		} catch (FileNotFoundException e) {
			throw new RuntimeException(e.getMessage());
		}
	}

	public DB buscarDb() throws RuntimeException {
		if (arquivo.exists()) {
			try {
				FileReader ler = new FileReader(nomeDoArquivo);
				xs.addPermission(AnyTypePermission.ANY);
				DB dados = (DB) xs.fromXML(ler);
				return dados;
			} catch (FileNotFoundException e) {
				throw new RuntimeException(e.getMessage());
			}
		}
		return null;
	}
}
