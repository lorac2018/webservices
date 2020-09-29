package engsotware.projectws2.Repositories;

import engsotware.projectws2.Models.Clinica;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface ClinicaRepoI extends CrudRepository<Clinica, Long> {

        Optional<Clinica> findByName(String nome);
}

