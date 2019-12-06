package br.edu.ifsp.projeto.EOL.repositorio;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import br.edu.ifsp.projeto.EOL.model.Usuario;

public interface UsuarioRepositorio extends CrudRepository<Usuario, Long> {

    Usuario findByUsername(String username);

    @Query(value="SELECT * FROM usuarios u INNER JOIN papeis p ON u.id = p.usuario_id WHERE p.papel = 'ROLE_INSTALADOR'", nativeQuery = true)
    List<Usuario> findAllInstaladores();
    
    @Query(value="SELECT * FROM usuarios u INNER JOIN papeis p ON u.id = p.usuario_id WHERE p.papel = :role", nativeQuery = true)
    List<Usuario> findAllByRole(@Param("role")String role);
    
    @Query(value="SELECT * FROM usuarios u INNER JOIN papeis p ON u.id = p.usuario_id", nativeQuery = true)
    List<Usuario> findAll();

}
