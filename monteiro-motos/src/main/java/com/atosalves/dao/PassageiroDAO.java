package com.atosalves.dao;

import java.time.Duration;
import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.util.Map;

import com.atosalves.db.Persistencia;
import com.atosalves.dto.PassageiroDTO;
import com.atosalves.model.Passageiro;
import com.atosalves.model.Usuario;

public class PassageiroDAO implements DAO<PassageiroDTO, String>{

    private Map<String, Usuario> usuarios;
	private Persistencia persistencia;


    // public static void main(String[] args) {
    //     DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd/MM/yyyy");
    //     LocalDate data = LocalDate.parse("28/02/2004", formato);
    //     var usu = new Passageiro("robson", null, data , "robson@gmail.com", "1234");
    //     var dto =  new PassageiroDTO(usu);
    //     var teste = new PassageiroDAO();
    //     System.out.println(teste.cadastrar(dto));
    //     System.out.println(teste.recuperarPeloId(usu.getEmail()));
    //     // teste.deletePeloId(usu.getEmail());
    // }

    public PassageiroDAO() {
        persistencia = Persistencia.getInstance();
		usuarios = persistencia.carregarUsuarios();
    }

    @Override
    public boolean cadastrar(PassageiroDTO entidade) {
        Usuario usuario = entidade.passageiro();
        LocalDate dataDeNascimento = usuario.getDataNascimento();
        LocalDate dataAtual = LocalDate.now();
        Period idade = Period.between(dataDeNascimento, dataAtual);

        PassageiroDTO passageiro = recuperarPeloId(usuario.getEmail());
        if (passageiro != null || idade.getYears() < 18 ) {
            // TODO r: fazer exceptions personalizadas
            return false;
        }
        Passageiro cadastrado = new Passageiro(usuario.getNome(), usuario.getSobrenome(), dataDeNascimento,
             usuario.getEmail(), usuario.getSenha());
        
        usuarios.put(cadastrado.getEmail(), cadastrado);
        persistencia.salvarUsuarios(usuarios);
        return true;

    }

    @Override
    public PassageiroDTO recuperarPeloId(String id) {
        Passageiro passageiro = (Passageiro) usuarios.get(id);
        if(passageiro == null){
            return null;
        }
        return new PassageiroDTO(passageiro);
    }

    @Override
    public PassageiroDTO update(PassageiroDTO entidade) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'update'");
    }
    
    @Override
    public void deletePeloId(String id) {
        usuarios.remove(id);
        persistencia.salvarUsuarios(usuarios);
    }


}
