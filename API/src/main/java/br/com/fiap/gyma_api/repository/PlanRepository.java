package br.com.fiap.gyma_api.repository;

import br.com.fiap.gyma_api.model.Exercise;
import br.com.fiap.gyma_api.model.Plan;
import br.com.fiap.gyma_api.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import java.util.List;

public interface PlanRepository extends JpaRepository<Plan, Long>, JpaSpecificationExecutor<Plan> {
    List<Exercise> findByUser(User user);
}


