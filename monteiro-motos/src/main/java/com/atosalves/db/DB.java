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
		corridas.put("PENDENTE", new ArrayList<>());
		corridas.put("REIVINDICADA", new ArrayList<>());
		corridas.put("FINALIZADA", new ArrayList<>());
		corridas.put("CANCELADA", new ArrayList<>());
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
