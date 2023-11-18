package com.atosalves.db;

import com.atosalves.dao.UsuarioDAO;
import com.atosalves.model.Corrida;
import com.atosalves.model.Usuario;
import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.DomDriver;
import com.thoughtworks.xstream.security.AnyTypePermission;
import java.io.File;
import java.io.FileReader;
import java.io.PrintWriter;
import java.util.ArrayList;

public class Persistencia {

	private XStream xs = new XStream(new DomDriver());
	private File arquivo = new File("persistencia.xml");

	public void salvarUsuarios(ArrayList<UsuarioDAO> usuarios) throws Exception {
		xs.addPermission(AnyTypePermission.ANY);
		PrintWriter escrever = new PrintWriter(arquivo);
		String xml = xs.toXML(usuarios);
		escrever.print(xml);
		escrever.close();
	}

	public void salvarCorridas(ArrayList<Corrida> corridas) throws Exception {
		xs.addPermission(AnyTypePermission.ANY);
		PrintWriter escrever = new PrintWriter(arquivo);
		String xml = xs.toXML(corridas);
		escrever.print(xml);
		escrever.close();
	}

	public ArrayList<Usuario> carregarUsuarios() throws Exception {
		if (arquivo.exists()) {
			FileReader ler = new FileReader("persistencia.xml");
			xs.addPermission(AnyTypePermission.ANY);
			ArrayList<Usuario> usuarios = (ArrayList<Usuario>) xs.fromXML(ler);
			return usuarios;
		}
		return new ArrayList<>();
	}

	public ArrayList<Corrida> carregarCorridas() throws Exception {
		if (arquivo.exists()) {
			FileReader ler = new FileReader("persistencia.xml");
			xs.addPermission(AnyTypePermission.ANY);
			ArrayList<Corrida> corridas = (ArrayList<Corrida>) xs.fromXML(ler);
			return corridas;
		}
		return new ArrayList<>();
	}
}
