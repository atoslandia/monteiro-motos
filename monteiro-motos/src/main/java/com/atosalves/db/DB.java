package com.atosalves.db;

import com.atosalves.enums.EstadoCorrida;
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
	private Map<EstadoCorrida, ArrayList<Corrida>> corridas;

	private DB() {
		usuarios = new HashMap<>();
		corridas = new HashMap<>();
		corridas = new HashMap<>();
		corridas.put(EstadoCorrida.PENDENTE, new ArrayList<>());
		corridas.put(EstadoCorrida.REINVINDICADA, new ArrayList<>());
		corridas.put(EstadoCorrida.CANCELADA, new ArrayList<>());
		corridas.put(EstadoCorrida.FINALIZADA, new ArrayList<>());
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

	public Map<EstadoCorrida, ArrayList<Corrida>> getCorridas() {
		return dbInstace.corridas;
	}
}
