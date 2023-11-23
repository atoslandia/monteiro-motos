package com.atosalves.dao;

import com.atosalves.db.Persistencia;
import com.atosalves.dto.CadastroDTO;
import com.atosalves.model.Usuario;

import java.util.Map;

// TODO r: classe para conectar com o banco de dados
public class UsuarioDAO implements DAO<CadastroDTO, String> {

	private Map<String, Usuario> usuarios;
	private Persistencia persistencia;

	public UsuarioDAO(){
		persistencia = Persistencia.getInstance();
		usuarios = persistencia.carregarUsuarios();
	}

	@Override
	public boolean cadastrar(CadastroDTO entidade) {
		if(recuperarPeloId(entidade.email()) != null){
			Usuario usuario = new Usuario(entidade.nome(), entidade.sobrenome(), entidade.dataNascimento(),
		 								entidade.email(), entidade.senha());
			usuarios.put(usuario.getEmail(), usuario);
			persistencia.salvarUsuarios(usuarios);
			return true;
		}
		return false;
		
	}

	@Override
	public CadastroDTO recuperarPeloId(String id) {
		Usuario usuario = usuarios.get(id);
		if(usuario == null){
			return null;
		}
		// CadastroDTO usuarioDTO = new CadastroDTO(usu, id, null, id, id);

		return null;
	}

	@Override
	public CadastroDTO update(CadastroDTO entidade) {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException("Unimplemented method 'update'");
	}

	@Override
	public void deletePeloId(String id) {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException("Unimplemented method 'delete'");
	}
}
