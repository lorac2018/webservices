package engsotware.projectws2.Repositories;

import engsotware.projectws2.Models.Consulta;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface ConsultaRepoI extends CrudRepository<Consulta, Long> {

    Optional<Consulta> findById(long id);

    Optional<Consulta> saveConsulta(Consulta consulta, String nameMedico);
}
