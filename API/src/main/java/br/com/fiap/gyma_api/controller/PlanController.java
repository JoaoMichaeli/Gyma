package br.com.fiap.gyma_api.controller;

import br.com.fiap.gyma_api.model.Plan;
import br.com.fiap.gyma_api.model.PlanType;
import br.com.fiap.gyma_api.model.User;
import br.com.fiap.gyma_api.repository.PlanRepository;
import br.com.fiap.gyma_api.specification.PlanSpecification;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("plans")
@Slf4j
public class PlanController {

    public record PlanFilters(String name, PlanType planType, Integer minExercises, Integer maxExercises) {}

    @Autowired
    private PlanRepository repository;

    @GetMapping
    public Page<Plan> index(
            PlanFilters filters,
            @PageableDefault(size = 10, sort = "name", direction = Sort.Direction.ASC) Pageable pageable,
            @AuthenticationPrincipal User user
    ) {
        var spec = PlanSpecification.withFilters(filters).and((root, query, cb) ->
            cb.equal(root.get("user"), user)
        );

        return repository.findAll(spec, pageable);
    }

}
