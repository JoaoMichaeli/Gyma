package br.com.fiap.gyma_api.controller;

import br.com.fiap.gyma_api.model.Exercise;
import br.com.fiap.gyma_api.repository.ExerciseRepository;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@RequestMapping("exercises")
@Slf4j
public class ExerciseController {

    @Autowired
    private ExerciseRepository repository;

    @GetMapping
    @Operation(summary = "Listar exercícios", description = "Retorna um array com todos os exercícios")
    @Cacheable("exercises")
    public List<Exercise> index() {
        return repository.findAll();
    }

    @PostMapping
    @CacheEvict(value = "exercises", allEntries = true)
    @Operation(summary = "Inserir exercícios", description = "Inserir um exercício novo", responses = @ApiResponse(responseCode = "400", description = "Validação falhou"))
    @ResponseStatus(code = HttpStatus.CREATED)
    public Exercise create(@RequestBody @Valid Exercise exercise) {
        log.info("Cadastrando exercício: " + exercise.getName());
        return repository.save(exercise);
    }

    @GetMapping("{id}")
    @Operation(summary = "Buscar exercício pelo id", description = "Retorna o exercício buscado pelo ID")
    public ResponseEntity<Exercise> get(@PathVariable Long id) {
        log.info("Buscando exercício: " + id);
        return ResponseEntity.ok(getExercise(id));
    }

    @DeleteMapping("{id}")
    @Operation(summary = "Deletar exercício", description = "Deleta o exercício escolhido")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        log.info("Deletando exercício: " + id);
        repository.delete(getExercise(id));
        return ResponseEntity.noContent().build();
    }

    @PutMapping("{id}")
    @Operation(summary = "Atualizar exercício", description = "Atualizar o exercício")
    public ResponseEntity<Exercise> update(@PathVariable Long id, @RequestBody @Valid Exercise exercise) {
        log.info("Atualizando exercício: " + id + " com " + exercise);
        var oldExercise = getExercise(id);
        BeanUtils.copyProperties(exercise, oldExercise, "id");
        repository.save(oldExercise);
        return ResponseEntity.ok(oldExercise);
    }

    private Exercise getExercise(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Exercício não encontrado"));
    }
}
