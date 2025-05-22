package br.com.fiap.gyma_api.controller;

import br.com.fiap.gyma_api.model.Plan;
import br.com.fiap.gyma_api.model.PlanType;
import br.com.fiap.gyma_api.model.User;
import br.com.fiap.gyma_api.repository.PlanRepository;
import br.com.fiap.gyma_api.specification.PlanSpecification;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.net.URI;
import java.util.Optional;

@RestController
@RequestMapping("plans")
@Slf4j
public class PlanController {

    public record PlanFilters(String name, PlanType planType, Integer minExercises, Integer maxExercises) {}

    @Autowired
    private PlanRepository repository;

    @GetMapping
    @Operation(summary = "Listar planos", description = "Retorna um array com todos os planos")
    @Cacheable("plans")
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

    @PostMapping
    @CacheEvict(value = "plans", allEntries = true)
    @Operation(summary = "Inserir planos", description = "Inserir um plano novo",responses = @ApiResponse(responseCode = "400", description = "Validação falhou"))
    @ResponseStatus(code = HttpStatus.CREATED)
    public Plan create(@RequestBody @Valid Plan plan, @AuthenticationPrincipal User user) {
        log.info("Cadastrando plano: " + plan.getName());
        plan.setUser(user);
        Plan saved = repository.save(plan);
        return repository.save(plan);
    }

    @GetMapping("{id}")
    @Operation(summary = "Buscar plano pelo id", description = "Retorna o plano buscado pelo ID")
    public ResponseEntity<Plan> get(@PathVariable Long id) {
        log.info("Buscando plano: " + id);
        return ResponseEntity.ok(getPlan(id));
    }

    @DeleteMapping("{id}")
    @Operation(summary = "Deletar plano", description = "Deleta o plano escolhido")
    public ResponseEntity<Void> delete(@PathVariable Long id, @AuthenticationPrincipal User user) {
        log.info("Deletando plano: " + id);
        repository.delete(getPlan(id));
        return ResponseEntity.noContent().build();
    }

    @PutMapping("{id}")
    @Operation(summary = "Atualizar plano", description = "Atualizar o plano")
    public ResponseEntity<Plan> update(@PathVariable Long id, @RequestBody @Valid Plan plan, @AuthenticationPrincipal User user) {
        log.info("Atualizando plano: " + id + " com " + plan);
        var oldPlano = getPlan(id);
        BeanUtils.copyProperties(plan, oldPlano, "id");
        repository.save(oldPlano);
        return ResponseEntity.ok(oldPlano);
    }

    private Plan getPlan(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Exercício não encontrado"));
    }
}
