package br.edu.ifsp.projeto.EOL.repositorio;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import br.edu.ifsp.projeto.EOL.model.OrdemServico;

public interface OrdemServicoRepositorio extends CrudRepository<OrdemServico, Long> {
    
	//Lista de OS’s com execução atrasada (o prazo de fechamento é de 5 dias)
    @Query(value = "SELECT * FROM os WHERE DATEDIFF(DATE(execucao), DATE(abertura)) > 5", nativeQuery = true)
	List<OrdemServico> findAllExpired();

    //OS's fechadas no prazo de um instalador
    @Query(value="select s.* from os s inner join usuarios u on s.instalador_id = u.id where s.instalador_id = :id and DATEDIFF(DATE(s.execucao), DATE(s.abertura)) <= 5", nativeQuery = true)
    List<OrdemServico> findAllClosedByInstalador(@Param("id") Long id);

    //Lista de instaladores com OS’s atrasadas, organizada por ordem decrescente de número de OS’s pendentes
    @Query(value="select * from os s inner join usuarios u on s.instalador_id = u.id where s.instalador_id = :id and DATEDIFF(CURDATE(), DATE(s.abertura)) > 5 and s.execucao is null", nativeQuery = true)
    List<OrdemServico> findAllExpiredByInstalador(@Param("id") Long id);   
    
    @Query(value="SELECT * FROM os where instalador_id is null", nativeQuery = true)
    List<OrdemServico> findAllOpen();
	
    @Query(value="SELECT * FROM os where instalador_id = :id AND execucao is null", nativeQuery = true)
    List<OrdemServico> findAllOsAbertasByInstalador(@Param("id") Long id);

}
