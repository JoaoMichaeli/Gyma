package br.com.fiap.gyma_api.repository;

import br.com.fiap.gyma_api.model.Exercise;
import br.com.fiap.gyma_api.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface ExerciseRepository extends JpaRepository<Exercise, Long> {

}
