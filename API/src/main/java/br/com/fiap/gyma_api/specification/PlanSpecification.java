package br.com.fiap.gyma_api.specification;

import br.com.fiap.gyma_api.controller.PlanController;
import br.com.fiap.gyma_api.model.Plan;
import jakarta.persistence.criteria.Expression;
import jakarta.persistence.criteria.Predicate;
import org.springframework.data.jpa.domain.Specification;
import java.util.ArrayList;

public class PlanSpecification {

    public static Specification<Plan> withFilters(PlanController.PlanFilters filters){
        return (root, query, cb) -> {

            var predicates = new ArrayList<>();
            if (filters.name() != null && !filters.name().isEmpty()){
                predicates.add(
                         cb.like(
                                cb.lower(root.get("name")), "%" + filters.name().toLowerCase() + "%"
                        )
                );
            }

            if (filters.planType() != null) {
                predicates.add(
                        cb.equal(root.get("planType").get("id"), filters.planType()));
            }

            if (filters.minExercises() != null || filters.maxExercises() != null) {
                Expression<Integer> size = cb.size(root.get("exercises"));
                if (filters.minExercises() != null) {
                    predicates.add(cb.ge(size, filters.minExercises()));
                }
                if (filters.maxExercises() != null) {
                    predicates.add(cb.le(size, filters.maxExercises()));
                }
            }

            var arrayPredicates = predicates.toArray(new Predicate[0]);
            return cb.and(arrayPredicates);
        };
    }
}
