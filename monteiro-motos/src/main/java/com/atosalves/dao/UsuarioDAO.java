package com.atosalves.dao;

import com.atosalves.dao.interfaceDAO.DAO;
import com.atosalves.db.DB;
import com.atosalves.dto.usuario.UsuarioDTO;
import com.atosalves.model.Usuario;
import com.thoughtworks.xstream.annotations.XStreamAsAttribute;

public class UsuarioDAO implements DAO<UsuarioDTO, String> {

	@XStreamAsAttribute
	private DB dataBase;

	public UsuarioDAO() {
		dataBase = DB.getInstance();
	}

	@Override
	public UsuarioDTO update(UsuarioDTO entidade, String id) {
		Usuario usuario = recuperarPeloId(id).usuario();
		usuario = entidade.usuario();
		dataBase.salvarDados();
		return new UsuarioDTO(usuario);
	}

	@Override
	public void cadastrar(UsuarioDTO entidade) {
		Usuario usuario = entidade.usuario();
		dataBase.getUsuarios().put(usuario.getEmail(), usuario);
		dataBase.salvarDados();
	}

	@Override
	public UsuarioDTO recuperarPeloId(String id) {
		Usuario usuario = dataBase.getUsuarios().get(id);
		if (usuario == null) {
			return null;
		}
		return new UsuarioDTO(usuario);
	}

	@Override
	public void deletePeloId(String id) {
		dataBase.getUsuarios().remove(id);
		dataBase.salvarDados();
	}
}
