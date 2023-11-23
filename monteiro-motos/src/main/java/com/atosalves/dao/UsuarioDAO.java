package com.atosalves.dao;

import com.atosalves.db.Persistencia;
import com.atosalves.dto.CadastroDTO;
import com.atosalves.dto.UsuarioDTO;
import com.atosalves.model.Usuario;
import java.util.HashSet;
import java.util.Set;

// TODO r: classe para conectar com o banco de dados
public class UsuarioDAO implements DAO<CadastroDTO, String> {

	private Set<Usuario> usuarios = new HashSet<>();

	@Override
	public Set<CadastroDTO> recuperarTodos() {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException("Unimplemented method 'recuperarTodos'");
	}

	@Override
	public boolean cadastrar(CadastroDTO entidade) {
		Usuario u = new Usuario(entidade.nome(), null, null, entidade.email(), null);
		usuarios.add(u);

		Persistencia p = new Persistencia();
		try {
			p.salvarUsuarios(usuarios);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return true;
	}

	@Override
	public CadastroDTO recuperarPeloId(String id) {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException("Unimplemented method 'recuperarPeloId'");
	}

	@Override
	public CadastroDTO update(CadastroDTO entidade) {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException("Unimplemented method 'update'");
	}

	@Override
	public void delete() {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException("Unimplemented method 'delete'");
	}
}
