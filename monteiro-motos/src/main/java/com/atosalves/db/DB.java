package com.atosalves.db;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import com.atosalves.model.Corrida;
import com.atosalves.model.Usuario;

public class DB {
    private static volatile DB dbInstace;
   

    private static Persistencia persistencia = new Persistencia();

    private Map<String, Usuario> usuarios;
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

    public void salvarDados(){
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
