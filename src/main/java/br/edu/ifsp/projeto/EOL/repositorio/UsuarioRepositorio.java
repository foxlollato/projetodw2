package br.edu.ifsp.projeto.EOL.repositorio;

import br.edu.ifsp.projeto.EOL.model.Usuario;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface UsuarioRepositorio extends CrudRepository<Usuario, Long> {

    Usuario findByUsername(String username);

    @Query("SELECT u FROM Usuario u JOIN u.papeis p WHERE p.papel = :role")
    List<Usuario> findAllByRole(String role);
}
