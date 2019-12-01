package br.edu.ifsp.projeto.EOL.repositorio;

import br.edu.ifsp.projeto.EOL.model.Usuario;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface UsuarioRepositorio extends CrudRepository<Usuario, Long> {

    Usuario findByUsername(String username);

    @Query(value="SELECT u.nome, p.papel FROM usuario u INNER JOIN papel p ON p.papel = :role", nativeQuery = true)
    List<Usuario> findAllByRole(String role);
    
    @Query(value="SELECT u.nome, p.papel FROM usuario u INNER JOIN papel p ON u.id = p.usuario_id", nativeQuery = true)
    List<Usuario> findAll();
}
