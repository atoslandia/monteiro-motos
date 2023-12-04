package com.atosalves.db;

import com.atosalves.model.Corrida;
import com.atosalves.model.Usuario;
import com.thoughtworks.xstream.annotations.XStreamAsAttribute;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class DB {

	@XStreamAsAttribute
	private static volatile DB dbInstace;

	@XStreamAsAttribute
	private static Persistencia persistencia = new Persistencia();

	@XStreamAsAttribute
	private Map<String, Usuario> usuarios;

	@XStreamAsAttribute
	private Map<String, ArrayList<Corrida>> corridas;

	private DB() {
		usuarios = new HashMap<>();
		corridas = new HashMap<>();
		corridas = new HashMap<>();
		corridas.put("PENDENTES", new ArrayList<>());
		corridas.put("REINVINDICADAS", new ArrayList<>());
		corridas.put("FINALIZADAS", new ArrayList<>());
		corridas.put("CANCELADAS", new ArrayList<>());
	}

	public void salvarDados() {
		persistencia.salvarDB(dbInstace);
	}

	public static DB getInstance() {
		dbInstace = persistencia.buscarDb();
		if (dbInstace == null) {
			synchronized (DB.class) {
				if (dbInstace == null) {
					dbInstace = new DB();
				}
			}
		}
		return dbInstace;
	}

	public Map<String, Usuario> getUsuarios() {
		return dbInstace.usuarios;
	}

	public Map<String, ArrayList<Corrida>> getCorridas() {
		return dbInstace.corridas;
	}
}
