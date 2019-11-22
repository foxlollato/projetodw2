package br.edu.ifsp.projeto.EOL.repositorio;

import br.edu.ifsp.projeto.EOL.model.OrdemServico;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.Date;
import java.util.List;

public interface OrdemServicoRepositorio extends CrudRepository<OrdemServico, Long> {
    //Lista de OS’s com execução atrasada (o prazo de fechamento é de 5
    //dias);
    @Query(value = "SELECT * FROM os WHERE DATEDIFF(abertura, :dataAtual) > 5 and instalador_id is null", nativeQuery = true)
    List<OrdemServico> findAllExpired(Date dataAtual);

    //Lista de instaladores OS’s atrasadas, organizada por ordem decres-
    //cente de número de OS’s pendentes.
    @Query(value="SELECT os.id, u.nome " +
            "FROM os " +
            "INNER JOIN usuario u" +
            "ON os.instalador_id=u.id " +
            "INNER JOIN papeis p "+
            "ON u.id=p.id "+
            "WHERE os.instalador is not null" +
            "AND os.fechamento is not null" +
            "AND p.papel = 'ROLE_INSTALADOR'", nativeQuery = true)
    List<OrdemServico> findAllClosed();

    //Lista de instaladores OS’s atrasadas, organizada por ordem decres-
    //cente de número de OS’s pendentes.
    @Query(value="SELECT os.id, u.nome " +
            "FROM os " +
            "INNER JOIN usuario u" +
            "ON os.instalador_id=u.id " +
            "INNER JOIN papeis p "+
            "ON u.id=p.id "+
            "WHERE os.instalador is not null" +
            "AND DATEDIFF(os.abertura, :dataAtual) > 5" +
            "AND p.papel = 'ROLE_INSTALADOR'", nativeQuery = true)
    List<OrdemServico> findAllExpiredInstaller(Date dataAtual);

    @Query(value="SELECT * FROM os where instalador is null", nativeQuery = true)
    List<OrdemServico> findAllOpen();


}
