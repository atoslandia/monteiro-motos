package com.atosalves.dao;

import java.time.LocalDate;
import java.time.Period;
import java.util.Map;

import com.atosalves.dao.interfaceDAO.DAO;
import com.atosalves.dao.interfaceDAO.UpdateDAO;
import com.atosalves.db.Persistencia;
import com.atosalves.dto.MototaxistaDTO;
import com.atosalves.dto.UpdateUsuarioDTO;
import com.atosalves.model.Mototaxista;
import com.atosalves.model.Usuario;

public class MototaxistaDAO implements DAO<MototaxistaDTO, String>, UpdateDAO<MototaxistaDTO, UpdateUsuarioDTO, String>{

    private Map<String, Usuario> usuarios;
	private Persistencia persistencia;

    public MototaxistaDAO() {
        persistencia = Persistencia.getInstance();
		usuarios = persistencia.carregarUsuarios();
    }

    @Override
    public MototaxistaDTO update(UpdateUsuarioDTO entidade, String id) {
        MototaxistaDTO mototaxistaDTO = recuperarPeloId(id);
        Mototaxista mototaxista = mototaxistaDTO.mototaxista();

        mototaxista.setNome(entidade.nome());
        mototaxista.setSobrenome(entidade.sobrenome());
        mototaxista.setSenha(entidade.senha());
        
        persistencia.salvarUsuarios(usuarios);
        return new MototaxistaDTO(mototaxista);
    }

    @Override
    public boolean cadastrar(MototaxistaDTO entidade) {
        usuarios = persistencia.carregarUsuarios();
        Usuario usuario = entidade.mototaxista();
        LocalDate dataDeNascimento = usuario.getDataNascimento();
        LocalDate dataAtual = LocalDate.now();
        Period idade = Period.between(dataDeNascimento, dataAtual);

        MototaxistaDTO mototaxista = recuperarPeloId(usuario.getEmail());
        if (mototaxista != null || idade.getYears() < 18 ) {
            // TODO r: fazer exceptions personalizadas
            return false;
        }
        Mototaxista cadastrado = new Mototaxista(usuario.getNome(), usuario.getSobrenome(), dataDeNascimento,
            usuario.getEmail(), usuario.getSenha());
        
        usuarios.put(cadastrado.getEmail(), cadastrado);
        persistencia.salvarUsuarios(usuarios);
        return true;
    }

    @Override
    public MototaxistaDTO recuperarPeloId(String id) {
        Mototaxista mototaxista = (Mototaxista) usuarios.get(id);
        if(mototaxista == null){
            return null;
        }
        return new MototaxistaDTO(mototaxista);
    }

    @Override
    public void deletePeloId(String id) {
        usuarios.remove(id);
        persistencia.salvarUsuarios(usuarios);
    }
    
}
