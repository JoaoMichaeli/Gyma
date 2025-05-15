package br.com.fiap.gyma_api.repository;

import br.com.fiap.gyma_api.model.PlanType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface PlanTypeRepository extends JpaRepository<PlanType, Long>, JpaSpecificationExecutor<PlanType> {}
