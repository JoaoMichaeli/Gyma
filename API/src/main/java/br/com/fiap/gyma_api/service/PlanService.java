package br.com.fiap.gyma_api.service;

import br.com.fiap.gyma_api.model.Exercise;
import br.com.fiap.gyma_api.model.Plan;
import br.com.fiap.gyma_api.repository.ExerciseRepository;
import br.com.fiap.gyma_api.repository.PlanRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PlanService {

    @Autowired
    private PlanRepository planRepository;

    @Autowired
    private ExerciseRepository exerciseRepository;

    public Plan adicionarExercicioNoPlano(Long idPlano, Exercise novoExercise) {
        Plan plan = planRepository.findById(idPlano)
                .orElseThrow(() -> new RuntimeException("Plano não encontrado"));

        Exercise exerciseSalvo = exerciseRepository.save(novoExercise);

        plan.getExercises().add(exerciseSalvo);

        return planRepository.save(plan);
    }
}

