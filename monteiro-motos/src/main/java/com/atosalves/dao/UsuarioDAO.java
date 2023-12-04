package com.atosalves.dao;

import com.atosalves.dao.interfaceDAO.DAO;
import com.atosalves.dao.interfaceDAO.UpdateDAO;
import com.atosalves.db.DB;
import com.atosalves.dto.UpdateUsuarioDTO;
import com.atosalves.dto.UsuarioDTO;
import com.atosalves.model.Usuario;
import com.thoughtworks.xstream.annotations.XStreamAsAttribute;

public class UsuarioDAO implements DAO<UsuarioDTO, String>, UpdateDAO<UsuarioDTO, UpdateUsuarioDTO, String> {

	@XStreamAsAttribute
	private DB dataBase;

	public UsuarioDAO() {
		dataBase = DB.getInstance();
	}

	@Override
	public UsuarioDTO update(UpdateUsuarioDTO entidade, String id) {
		UsuarioDTO usuarioDTO = recuperarPeloId(id);
		Usuario usuario = usuarioDTO.usuario();

		usuario.setNome(entidade.nome());
		usuario.setSenha(entidade.senha());
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
