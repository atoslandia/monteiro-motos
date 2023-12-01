package com.atosalves.dao;

import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.util.Map;

import com.atosalves.dao.exceptions.UsuarioNaoEncontradoException;
import com.atosalves.dao.interfaceDAO.DAO;
import com.atosalves.dao.interfaceDAO.UpdateDAO;
import com.atosalves.db.Persistencia;
import com.atosalves.dto.PassageiroBoletoDTO;
import com.atosalves.dto.UpdateUsuarioDTO;
import com.atosalves.dto.UsuarioDTO;
import com.atosalves.model.Mototaxista;
import com.atosalves.model.Passageiro;
import com.atosalves.model.Usuario;
import com.atosalves.model.facadepattern.MensageiroFacade;

public class UsuarioDAO implements DAO<UsuarioDTO, String>, UpdateDAO<UsuarioDTO, UpdateUsuarioDTO, String> {

    private Map<String, Usuario> usuarios;
	private Persistencia persistencia;
    
    public UsuarioDAO() {
        persistencia = Persistencia.getInstance();
        usuarios = persistencia.carregarUsuarios();
    }


    @Override
    public UsuarioDTO update(UpdateUsuarioDTO entidade, String id) {
        UsuarioDTO usuarioDTO = recuperarPeloId(id);
        Usuario usuario = usuarioDTO.usuario();

        usuario.setNome(entidade.nome());
        usuario.setSenha(entidade.senha());

        persistencia.salvarUsuarios(usuarios);
        return new UsuarioDTO(usuario);
    }

    @Override
    public void cadastrar(UsuarioDTO entidade) {
        Usuario usuario = entidade.usuario();
        usuarios.put(usuario.getEmail(), usuario);
        persistencia.salvarUsuarios(usuarios);
    }

    @Override
    public UsuarioDTO recuperarPeloId(String id){
        Usuario usuario = usuarios.get(id);
        if(usuario == null){
            return null;
        }
        return new UsuarioDTO(usuario);
    }

    @Override
    public void deletePeloId(String id) {
        usuarios.remove(id);
        persistencia.salvarUsuarios(usuarios);
    }


    // public static void main(String[] args) {
    //     DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd/MM/yyyy");
    //     LocalDate data = LocalDate.parse("28/02/2004", formato);
    //     var usu = new Passageiro("ivan", data , "robsoncaliban@gmail.com", "1234");
    //     var dto =  new UsuarioDTO(usu);
    //     var teste = new UsuarioDAO();
        
    //     var mototaxista = new Mototaxista("atos", data, "atos@gmail.com", "5555");
    //     var dto02 = new UsuarioDTO(mototaxista);


    //     System.out.println(teste.cadastrar(dto));
    //     System.out.println(teste.recuperarPeloId(usu.getEmail()));
    //     UpdateUsuarioDTO updateUsuarioDTO = new UpdateUsuarioDTO("atos",  "4321");
    //     System.out.println(teste.update(updateUsuarioDTO, usu.getEmail()));

    //     System.out.println(teste.cadastrar(dto02));
    //     System.out.println(teste.recuperarPeloId(mototaxista.getEmail()));

        // teste.deletePeloId(usu.getEmail());

    //     // try {
    //     //     MensageiroFacade.gerarBoleto(new PassageiroDTO(usu), 100);
    //     // } catch (Exception e) {
    //     //     System.out.println(e.getMessage());
    //     // }

    //     try {
    //         MensageiroFacade.gerarBoleto(dto, 1000);
    //         MensageiroFacade.enviarCodigo(dto.email(), "444458t");
    //     } catch (Exception e) {
    //         System.out.println(e.getMessage());
    //     }
    // }
    
}
