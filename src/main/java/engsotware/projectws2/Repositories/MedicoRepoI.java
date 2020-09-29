package engsotware.projectws2.Repositories;

import engsotware.projectws2.Models.Medico;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface MedicoRepoI extends CrudRepository<Medico, Long> {

    Optional<Medico> findByName(String nome);
}
